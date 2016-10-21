package com.hp.tcp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.hp.tcp.application.ChatApplication;
import com.hp.tcp.util.DebugLog;


/**
 * @author zm
 * @version 创建时间：2014-9-15 上午11:04:05
 * 类说明 socket基类
 */
public class SocketBase {

	//private String TAG = SocketBase.class.getSimpleName();
	private  static String TAG = "aaaaaaaabbbbbbbbbbbb";

    protected boolean      m_isRuning = false;
	
	private Socket       	m_socket=null;
	private OutputStream 	m_os=null;
	private InputStream  	m_is=null;
	protected Context		 	m_Context=null;
	private CBuffer      	m_ReadBuffer=null;
	private int      	 	m_nVer=0;
	
	private String          m_IP;
	private int             m_Port;
	
	private Handler         m_hMessageHandler=null;
	private Thread 	        m_ReceiveThread = null;
	
	private Timer 			mTimer = null;  
	private TimerTask 		mTimerTask = null;
	public  boolean         m_bOpenHeartCheck=false;//连接后是否开启心跳检测
	
	public  int             m_heartFrequency=0;//心跳包计数
	public  int             m_heartDelay=20000;//心跳包间隔（默认20秒）
	public  int             m_MaxHeartNoReplyNum=3;//最大心跳包未响应次数（默认3次）
	
	//服务器无响应
	public int  Notice_ServerNoReply()
	{
		return 0;
	}
	
	//服务器断开连接   1客户端自己断 0服务器断
	public int  Notice_ServerCloseSocket()
	{
		
		return 0;
	}
		
	//发送心跳包消息
	public int  sendHeartBeatMSg()
	{
		if (!m_isRuning) {
			
			stopTimer();
	        return -1;
	    }
		
		return 0;
	}
	
	private void startTimer(){  
		
		DebugLog.i(TAG,"startTimer!");
		        
        if (mTimer == null) {  
        	mTimer = new Timer();  
        }  
  
        if (mTimerTask == null) {  
            mTimerTask = new TimerTask() {  
                @Override  
                public void run() {  
                	//发送心跳包消息
			        
                	 if(m_heartFrequency <m_MaxHeartNoReplyNum && 0==sendHeartBeatMSg())
                     {
                    	m_heartFrequency++;
                    	return;
                	 }
                	 
                	 m_heartFrequency=0;
                	 closeSocket();//关闭连接
			         //服务器无响应消息
                	 Notice_ServerNoReply();
                	 
                }
            };  
        }  
  
        if(mTimer != null && mTimerTask != null )  
        {
            mTimer.schedule(mTimerTask, m_heartDelay, m_heartDelay);  
        }
    }  
  
    private void stopTimer(){  
          
    	DebugLog.i(TAG,"stopTimer!");
        if (mTimer != null) {  
        	
            mTimer.cancel();  
            mTimer = null;  
        }  
  
        if (mTimerTask != null) {  
            mTimerTask.cancel();  
            mTimerTask = null;  
        }     
        
        m_heartFrequency   = 0;
    }  
	
	//线程:监听服务器发来的消息
	private Runnable m_RunnableReceive	= new Runnable(){

		public void run() {
			do{
				try{
					boolean bBreak = false;
					if(m_ReadBuffer == null)
					{
						m_ReadBuffer = new CBuffer(NetdataStruct.NetHeader.nBufferLen);
					}
					int nReadBytes = 0;
					while(m_ReadBuffer.GetBufferLen() - m_ReadBuffer.GetRealLen() > 0)
					{
						byte [] tempBuffer = new byte[m_ReadBuffer.GetBufferLen() - m_ReadBuffer.GetRealLen()];
									
						if(m_is==null)
						{
							tempBuffer=null;
							DebugLog.w(TAG,">>>>>>>Warning:: m_is==null,closeSocket!");
							closeSocket();
							Notice_ServerCloseSocket();
							return;
						}
						
						nReadBytes = m_is.read(tempBuffer, 0, tempBuffer.length);
						DebugLog.i(TAG,"长度："+tempBuffer.length);
						DebugLog.i(TAG,"nReadBytes="+nReadBytes+"!");
						if (nReadBytes == -1) {
							DebugLog.i(TAG,">>>>>>>Warning:: nReadBytes=-1!");
							closeSocket();
							Notice_ServerCloseSocket();
							return;
		                } 
						
						if(nReadBytes > 0)
						{
							System.arraycopy(tempBuffer, 0, m_ReadBuffer.m_buffer, m_ReadBuffer.m_nEndPos, nReadBytes);
							m_ReadBuffer.SetPos(0, m_ReadBuffer.GetRealLen() + nReadBytes);
							
							tempBuffer=null;
						}
					}
					
					NetdataStruct.NetHeader netHeader = new NetdataStruct.NetHeader();
					netHeader.SetBuffer(m_ReadBuffer.m_buffer);
					if(netHeader.nPacketSize<NetdataStruct.NetHeader.nBufferLen)
					{
						m_ReadBuffer = null;
						closeSocket();
						DebugLog.w(TAG, "rev packetsize too small,close socket!! (size="+netHeader.nPacketSize+")");
						break;
					}
					if(netHeader.nPacketSize >= 1024*1024*10)
					{
						m_ReadBuffer = null;
						closeSocket();
						DebugLog.w(TAG, "rev packetsize too bigger,close socket!! (size="+netHeader.nPacketSize+")");
						break;
					}
					DebugLog.i(TAG, "NetHeader.nMessageLength, m_ReadBuffer.GetRealLen()=="+netHeader.nPacketSize+"; "+m_ReadBuffer.GetRealLen());
					if(netHeader.nPacketSize == m_ReadBuffer.GetRealLen())
					{	
						CBuffer tempbuffer = new CBuffer(m_ReadBuffer);
						m_ReadBuffer = null;		
						if(0!=work(tempbuffer))
						{
							DebugLog.w(TAG, "work return -1!!");
						}
							
						tempbuffer=null;
					}
					else
					{ 
						CBuffer tempBuffer = new CBuffer(netHeader.nPacketSize);
						System.arraycopy(m_ReadBuffer.GetRealBuffer(), 0,tempBuffer.m_buffer, 0,  m_ReadBuffer.GetRealLen());
						tempBuffer.SetPos(0, m_ReadBuffer.GetRealLen());
						m_ReadBuffer = tempBuffer;
					}
					
				}catch (Exception e){
					e.printStackTrace();
					
					m_ReadBuffer = null;
					closeSocket();
					DebugLog.w(TAG, "rev find catch,close socket!!");	
					
					Notice_ServerCloseSocket();
					return;
				}
				
			}while(m_isRuning);
		}
	};
	
	public int work(CBuffer bufferIn)
	{
		DebugLog.i(TAG, "SocketBase 进入work函数");
		NetdataStruct.NetHeader netHeader = new NetdataStruct.NetHeader();
		netHeader.SetBuffer(bufferIn.m_buffer);
	    
	    if (netHeader.nPacketSize - netHeader.nDataLen != NetdataStruct.NetHeader.nBufferLen) {
	    	DebugLog.w(TAG,"work(), Invalid Packet ("+netHeader.nPacketSize+","+netHeader.nDataLen+")+++++++++++++\n");
	        
	    	netHeader=null;
	    	return -1;
	    }
	    
	    netHeader=null;
		return 0;
	}
	
	public SocketBase() {
	}
	
	/**
	 * 
	 * @param con 上下文
	 * @param nVer 可以随便传，暂时用不到
	 */
	public void init(Context con, int nVer){
		this.m_Context = con;
		this.m_nVer = nVer;
	}
	
	/**
	 * 
	 * @param con 上下文
	 * @param uiHandler uiHandler句柄
	 */
	public void init(Context con, Handler uiHandler){
		this.m_Context = con;
		this.m_hMessageHandler = uiHandler;
	}

	public boolean ConnectServer(String sServer, int nPort){
		
		DebugLog.i(TAG, "ConnectServer...");
		
		m_IP=sServer;
		m_Port=nPort;
		
		return connect();
	}
	
	public boolean ReConnectServer(){
			
		DebugLog.i(TAG, "ReConnectServer...");

		return connect();
	}
	
	@SuppressLint("NewApi")
	private boolean connect(){
		try{
			close();
			
			if(m_IP.isEmpty() || m_Port==0)
				return false;
			
			DebugLog.i(TAG, "connect::sServer="+ m_IP +";  nPort="+ m_Port);

			m_socket = new Socket();
			m_socket.setSoTimeout(120000);//读取数据超时设置2min
			m_socket.connect(new InetSocketAddress(m_IP, m_Port), 5000);//建立连接超时设置5sec
			m_os = m_socket.getOutputStream();
			m_is = m_socket.getInputStream();
			
			m_ReceiveThread = new Thread(m_RunnableReceive);
			m_isRuning = true;
			m_ReceiveThread.start();
			
			if(m_bOpenHeartCheck)
			{
				startTimer();
			}
			
			return true;
			
		}catch(AssertionError e){
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void closeSocket() {
		
		try
		{
			m_isRuning=false;
			stopTimer();
			if(null != m_ReceiveThread) m_ReceiveThread.interrupt();
			if (m_socket!=null) {
				m_socket.close();
				m_socket=null;
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean iscloseByClient=false;
	public void closeByClient(){
		iscloseByClient=true;
		close();
	}
	
	
	/**
	 * 组装包头
	 * @param buffer			包数据
	 * @param nMainCmd			主命令
	 * @param nSubCmd			子命令
	 */
	public boolean buildSockPack(byte[] buffer,int nMainCmd,int nSubCmd) {
		
		int nDataLen = buffer.length;
		int nSendBufferLenth = NetdataStruct.NetHeader.nBufferLen+nDataLen;
		
		NetdataStruct.NetHeader  netHeader	= new NetdataStruct.NetHeader();
		netHeader.nPacketSize = nSendBufferLenth ; 
		netHeader.isZip = 0 ;
		netHeader.nMainCmd  = nMainCmd;
		netHeader.nSubCmd = nSubCmd;
		netHeader.nDataLen = nDataLen;
		byte [] sendBuffer = new byte[nSendBufferLenth];
		System.arraycopy(netHeader.GetBuffer(), 0, sendBuffer, 0, NetdataStruct.NetHeader.nBufferLen);
		System.arraycopy(buffer, 0, sendBuffer, NetdataStruct.NetHeader.nBufferLen, nDataLen);
		return AddWriteBuffer(sendBuffer);
	}
	
	/**
	 * 组装包头
	 * @param nMainCmd			主命令
	 * @param nSubCmd			子命令
	 */
	public boolean buildSockPack(int nMainCmd,int nSubCmd) {
		
		int nDataLen = 0;
		int nSendBufferLenth = NetdataStruct.NetHeader.nBufferLen;
		
		NetdataStruct.NetHeader  netHeader	= new NetdataStruct.NetHeader();
		netHeader.nPacketSize = nSendBufferLenth ; 
		netHeader.isZip = 0 ;
		netHeader.nMainCmd  = nMainCmd;
		netHeader.nSubCmd = nSubCmd;
		netHeader.nDataLen = nDataLen;
		byte [] sendBuffer = new byte[nSendBufferLenth];
		System.arraycopy(netHeader.GetBuffer(), 0, sendBuffer, 0, NetdataStruct.NetHeader.nBufferLen);
		return AddWriteBuffer(sendBuffer);
	}
	
	public boolean AddWriteBuffer(byte[] buffer)
	{
		try {
			if(buffer == null){
				return false;
			}else if(m_os == null){
				return false;
			}
			/*if(m_socket != null)
			m_socket.sendUrgentData(0xFF);//判断一下网络是否断开
			*/
			m_os.write(buffer,0,buffer.length);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 关闭Socket资源
	 */
	public void close() {
		try {
			
			closeSocket();
			
			if(m_is != null){
				m_is.close();
				m_is = null;
			}
			if(m_os != null){
				m_os.close();
				m_os = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean sendHandelMessage(int msgcode, int arg1,int gar2,Object obj){
		Message msg=m_hMessageHandler.obtainMessage(msgcode, arg1, gar2, obj);
		return m_hMessageHandler.sendMessage(msg);
	}
	
	
	/**
	 * 获取Application的实例
	 * @return
	 */
	protected ChatApplication getApplicationInstance(){
		return (ChatApplication) m_Context.getApplicationContext();
	}
	
}
