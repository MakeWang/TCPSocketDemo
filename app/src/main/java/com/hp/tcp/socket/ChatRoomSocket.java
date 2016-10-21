package com.hp.tcp.socket;

import android.content.Context;
import android.os.Handler;

import com.hp.tcp.ChatGlobalDef;
import com.hp.tcp.application.ChatApplication;
import com.hp.tcp.pb.LoginSvr_RetCode;
import com.hp.tcp.pb.PB_HC_CLIENT_LOGIN;
import com.hp.tcp.pb.PB_HC_CLIENT_LOGIN_REP;
import com.hp.tcp.util.DebugLog;
import com.squareup.wire.Wire;

import java.io.IOException;

/**
 * Created by tgkj on 2016/10/10.
 */
public class ChatRoomSocket extends SocketBase{

    //private String TAG = ChatRoomSocket.class.getSimpleName();
    private  static String TAG = "aaaaaaaabbbbbbbbbbbb";

    private ChatApplication mApplication;

    public int   	m_appid=0; //游戏ID
    private int   	m_appsvrid=0;//游戏服ID
    private long 	m_appaccount=0;//游戏账号

    private String 	m_appToken="";//游戏票据
    private String 	m_userToken="";//用户票据

    //设备信息
    private String m_deviceid;
    private String m_deviceSoftVer;

    /**
     * 设置登陆相关参数
     * @param appid        应用ID
     * @param appsvrid		 应用服ID
     * @param appaccount	 应用账号
     * @param appToken		 应用票据
     * * @param userToken	应用账号票据
     */
    public void SetLoginInfo(int appid,int appsvrid,long appaccount,String appToken,String userToken)
    {
        m_appid=appid;
        m_appsvrid=appsvrid;
        m_appaccount=appaccount;
        m_appToken=appToken;
        m_userToken=userToken;
        m_bOpenHeartCheck=true;//开启心跳检测
    }

    public void setDeviceInfo(String deviceid,String version)
    {
        m_deviceid=deviceid;
        m_deviceSoftVer=version;
    }

    @Override
    public void init(Context con, Handler uiHandler) {
        super.init(con, uiHandler);
        mApplication = getApplicationInstance();
    }



    @Override
    public int work(CBuffer bufferIn){

        if(0!=super.work(bufferIn))
            return -1;

        DebugLog.i(TAG, "ChatRoomSocket 进入work函数");
        int nResult = -1;
        NetdataStruct.NetHeader netHeader = new NetdataStruct.NetHeader();
        netHeader.SetBuffer(bufferIn.m_buffer);

        if (netHeader.nMainCmd != ProtocolDef.MainCmdDef.NTP_CLIENT_ROOMSVR)
        {
            netHeader=null;
            DebugLog.w(TAG,"uncorrect client_room_server logic!\n");
            return -1;
        }

        DebugLog.i(TAG,"nMainCmd:"+netHeader.nMainCmd+",nSubCmd:"+netHeader.nSubCmd+",bufferLength:"+bufferIn.m_nBufferLen);

        int nDataBufferLenth =  bufferIn.GetBufferLen()-NetdataStruct.NetHeader.nBufferLen;
        byte [] dataBuffer = null;
        if(nDataBufferLenth>0)
        {
            dataBuffer = new byte[nDataBufferLenth];
            System.arraycopy(bufferIn.m_buffer, NetdataStruct.NetHeader.nBufferLen, dataBuffer, 0, nDataBufferLenth);
        }

        switch(netHeader.nSubCmd)
        {
            case ProtocolDef.SubRsCmdDef.CMD_RS_WELCOME_GET://欢迎消息
                nResult = doWelcome(dataBuffer,nDataBufferLenth);
                break;
            case ProtocolDef.SubRsCmdDef.CMD_RS_HEART_REP://服务器回复的心跳包
                nResult = doHeartBeatRep(dataBuffer,nDataBufferLenth);
                break;
            case ProtocolDef.SubRsCmdDef.CMD_RS_USER_LOGIN_REP://登录返回
                nResult = doLoginRep(dataBuffer,nDataBufferLenth);
                break;
            case ProtocolDef.SubRsCmdDef.CMD_RS_OTHER_LOGIN_GET://用户在其他地方登陆
                nResult = doOtherPlaceLogin(dataBuffer,nDataBufferLenth);
                break;

            default:
            {
                DebugLog.w(TAG,"rev unknown cmd msg! cmd:"+netHeader.nSubCmd);
                nResult=0;
            }
            break;
        }

        dataBuffer=null;
        netHeader=null;
        return nResult;
    }

    /**
     * 连接返回
     * @param buffer,数据缓存数组
     * @param nLenth,数据长度
     * @return
     */
    public int doWelcome(byte[] buffer,int nLenth)
    {
        DebugLog.i(TAG,"doWelcome! \n");
        if(!m_isRuning)
            return 0;
        //发送进入房间消息
        sendUserLogin();
        return 0;
    }

    /**
     * 心跳包返回
     * @param buffer,数据缓存数组
     * @param nLenth,数据长度
     * @return
     */
    public int doHeartBeatRep(byte[] buffer,int nLenth)
    {
        DebugLog.i(TAG,"doHeartBeatRep...\n");
        m_heartFrequency=0;//重置心跳计数器
        return 0;
    }

    /**
     * 处理进入房间返回结果
     * @param buffer,数据缓存数组
     * @param nLenth,数据长度
     * @return
     */
    public int doLoginRep(byte[] buffer,int nLenth) {
        DebugLog.i(TAG, "doLoginRep...\n");
        //ChatApplication.CHAT_SDK_NEW_FLUSH=true;//更新
        Wire wire = new Wire();
        try {
            PB_HC_CLIENT_LOGIN_REP loginRep = wire.parseFrom(buffer, PB_HC_CLIENT_LOGIN_REP.class);
            if (loginRep == null) {
                DebugLog.e(TAG, "doLoginRep,parse data from buffer fail!!");
                mApplication.setChatLogined(false);
                return -1;
            } else {
                //DebugLog.i("111", loginRep.reason);
                LoginSvr_RetCode retCode = loginRep.retcode;
                if(retCode == LoginSvr_RetCode.GC_LOGIN_SUCC){//登录成功
                    DebugLog.i(TAG, "登录成功！数据放回：");
                }else{
                    boolean bReLogin = true;
                    String retStr;
                    if (retCode == LoginSvr_RetCode.GC_LOGIN_NOUSER) {

                        // retStr
                        // =getResources().getString(R.string.im_login_error_nouser);
                        retStr = "登录无该游戏角色！请联系游戏客服。";
                        bReLogin = false;

                    } else if (retCode == LoginSvr_RetCode.GC_LOGIN_NOUSER) {

                        retStr = "登录无该游戏角色！请联系游戏客服。";
                        bReLogin = false;
                    } else if (retCode == LoginSvr_RetCode.GC_LOGIN_TOKENERROR) {

                        retStr = "登录TOKEN过期，请退出游戏重新登录";
                        bReLogin = false;

                    } else if (retCode == LoginSvr_RetCode.GC_LOGIN_DB_SAVEUI_FAIL) {
                        retStr = "注册用户失败,请检查本账号对应的角色ID是否冲突。";
                        bReLogin = false;
                    } else if (retCode == LoginSvr_RetCode.GC_LOGIN_DB_SAVEFAMILY_FAIL) {
                        retStr = "更新用户信息失败！请联系游戏客服。";
                        bReLogin = false;
                    } else if (retCode == LoginSvr_RetCode.GC_LOGIN_DB_GETCHATSVR_FAIL) {
                        retStr = "此服对应的聊天房间暂未开通！请联系游戏客服。";
                        bReLogin = false;
                    } else if (retCode == LoginSvr_RetCode.GC_LOGIN_UNKNOW) {
                        retStr = "系统拒绝服务，稍后再试！";
                        bReLogin = false;
                    } else {
                        retStr = "登录失败！错误号:" + retCode.getValue();
                        bReLogin = false;
                    }
                    DebugLog.i(TAG, "登录失败"+retStr);
                }

                /*
                if (loginRep.ret == eLOGIN_Ret.LOGIN_SUCC) {
                    mApplication.setChatLogined(true);
                    //DebugLog.i(TAG, "游戏IDappId=" + m_appid + ",游戏服IDappsvrid=" + m_appsvrid + ",游戏账号appaccount=" + m_appaccount + ",游戏票据appToken=" + m_appToken + ",用户票据userToken=" + m_userToken);
                    //DebugLog.i(TAG, "doLoginRep,Login Success!" + loginRep.user.headicon + "," + loginRep.user.nickname + "," + loginRep.user.level + "," + loginRep.user.location);
                    //int level = loginRep.user.level == null ? 0 : loginRep.user.level;
                    //String location = loginRep.user.location == null ? "" : loginRep.user.location;
                    String nickname = loginRep.user.nickname == null ? "" : loginRep.user.nickname;
                    //DebugLog.i(TAG, "headicon =" + loginRep.user.headicon);
                    //String headicon = loginRep.user.headicon == null ? "" : loginRep.user.headicon;

                    DebugLog.i(TAG, "登录成功！数据放回：" + nickname);

                    //getChatList();
                } else if (loginRep.ret == eLOGIN_Ret.LOGIN_FAIL_UNKNOWN) {
                    //失败,未知错误
                    DebugLog.i(TAG, "doLoginRep,LOGIN_FAIL_UNKNOWN!");
                    mApplication.setChatLogined(false);
                    sendHandelMessage(ChatGlobalDef.WM_START_RECONNECT_RS_TIMER, 0, 0, null);
                } else if (loginRep.ret == eLOGIN_Ret.LOGIN_FAIL_NOUSER) {
                    //失败,无此用户
                    DebugLog.i(TAG, "doLoginRep,LOGIN_FAIL_NOUSER!");
                    mApplication.setChatLogined(false);
                    sendHandelMessage(ChatGlobalDef.WM_LOGIN_FAIL_AND_CALL_BACK, 401, 0, null);
                } else if (loginRep.ret == eLOGIN_Ret.LOGIN_FAIL_TOKENERROR) {
                    //失败,用户票据错误
                    DebugLog.i(TAG, "doLoginRep,LOGIN_FAIL_TOKENERROR!");
                    mApplication.setChatLogined(false);
                    sendHandelMessage(ChatGlobalDef.WM_LOGIN_FAIL_AND_CALL_BACK, 402, 0, null);
                } else if (loginRep.ret == eLOGIN_Ret.LOGIN_FAIL_PARAMERROR) {
                    //失败,参数错误
                    DebugLog.i(TAG, "doLoginRep,LOGIN_FAIL_PARAMERROR!");
                    mApplication.setChatLogined(false);
                    sendHandelMessage(ChatGlobalDef.WM_LOGIN_FAIL_AND_CALL_BACK, 403, 0, null);
                } else {
                    //Toast.makeText(m_Context, ""+loginRep.reason, 200).show();
                    DebugLog.i(TAG, "doLoginRep,login fail!");
                    mApplication.setChatLogined(false);
                }*/
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 用户在其他地方登陆
     * @param buffer,数据缓存数组
     * @param nLenth,数据长度
     * @return
     */
    public int doOtherPlaceLogin(byte[] buffer,int nLenth)
    {
        DebugLog.i(TAG,"doOtherPlaceLogin...");
        closeSocket();//关闭连接
        sendHandelMessage(ChatGlobalDef.WM_RS_OTHERPLACE_LOGIN,0,0,null);
        return 0;
    }

    /**
     * 用户登录
     * @param
     * @return
     */
    public int sendUserLogin()
    {
        int errornum=0;
        DebugLog.e(TAG, "用户登录"+m_isRuning);
        if (!m_isRuning) {
            DebugLog.e(TAG, "用户登录1");
            errornum=-1;
            return errornum;
        }

        if (m_appToken.length()==0)  {
            DebugLog.e(TAG, "用户登录2");
            errornum=-2;
            DebugLog.w(TAG,"Please set the Logining appToken parameter! \n");
            return errornum;
        }

        if (m_appid == 0) {
            DebugLog.e(TAG, "用户登录3");
            errornum=-3;
            DebugLog.w(TAG,"Please set the Logining appid parameter!\n");
            return errornum;
        }

        if (m_appsvrid < 0) {
            DebugLog.e(TAG, "用户登录4");
            errornum=-4;
            DebugLog.w(TAG,"Please set the Logining appsvrid parameter!\n");
            return errornum;
        }

        if (m_appaccount==0) {
            DebugLog.e(TAG, "用户登录5");
            errornum=-5;
            DebugLog.w(TAG,"Please set the Logining appaccount parameter!\n");
            return errornum;
        }

        if(null==mApplication)
        {
            DebugLog.e(TAG, "用户登录6");
            errornum=-7;
            DebugLog.e(TAG, "null==mApplication");
            return errornum;
        }
        /*
        PB_USER_LOGIN.Builder  loginBuilder= new PB_USER_LOGIN.Builder();
        loginBuilder.appid(m_appid);
        loginBuilder.userid(Long.valueOf(m_appaccount));

        loginBuilder.token(m_userToken);
        loginBuilder.demotext("");
        DebugLog.e(TAG, "m_appid="+m_appid+",m_appaccount="+m_appaccount+",m_userToken="+m_userToken);
        int length = loginBuilder.build().getSerializedSize();
        DebugLog.i("The result length is " + length);
        //直接序列化到内存中，之后可对该内存进行二次加工后再写到本地文件或发送到远端，如加密。
        byte[] buf = loginBuilder.build().toByteArray();
        */
        DebugLog.e(TAG, "用户登录7==="+m_deviceid+","+m_deviceSoftVer);
        PB_HC_CLIENT_LOGIN.Builder playerInfo = new PB_HC_CLIENT_LOGIN.Builder();

        playerInfo.account(m_appaccount+"");
        playerInfo.appid(m_appid);
        playerInfo.apptoken(m_appToken);
        playerInfo.devid(m_deviceid);
        playerInfo.devtype(1);
        playerInfo.sysver(m_deviceSoftVer);
        playerInfo.userid((long) 0);
        playerInfo.token(m_userToken);
        playerInfo.logintype(0);
        // playerInfo.isfirstlogin(false);


        // 直接序列化到内存中，之后可对该内存进行二次加工后再写到本地文件或发送到远端，如加密。
        byte[] buf = playerInfo.build().toByteArray();

        buildSockPack(buf,ProtocolDef.MainCmdDef.NTP_CLIENT_LOGINSVR,ProtocolDef.SubRsCmdDef.CMD_RS_USER_LOGIN_SEND);
        return 0;

    }
}
