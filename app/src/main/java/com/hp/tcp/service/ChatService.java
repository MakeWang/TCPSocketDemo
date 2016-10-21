package com.hp.tcp.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import com.hp.tcp.ChatGlobalDef;
import com.hp.tcp.application.ChatApplication;
import com.hp.tcp.socket.ChatRoomSocket;
import com.hp.tcp.util.DebugLog;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by tgkj on 2016/10/10.
 */
public class ChatService extends Service {

    //private final static String TAG = ChatService.class.getSimpleName();
    private  static String TAG = "aaaaaaaabbbbbbbbbbbb";
    private MyBinder myBinder = new MyBinder();
    private static Context mContext;
    private static ChatService mService = null;
    private ChatApplication mChatApplication;
    private ChatRoomSocket mChatRoomSocket;

    //设备信息
    private String m_deviceid;
    private String m_deviceSoftVer;

    public static boolean needReLoginGame=false;//是否需要重新登录游戏
    public static int netState = ChatGlobalDef.NET_NONE;// 网络状态
    public static int needConSvr = 0;// 网络可用需要连接的服务器 0 不用，1 需要

    //重新连接房间服务器定时器
    public static int CRS_Delay=10000;//重新连接房间服务器间隔（10秒）

    public static int conRsFailNum = 0;// 重连房间服务器失败次数

    private Timer mTimer_R = null;
    private TimerTask mTimerTask_R = null;

    private final String CHAT_SDK_CALL_BACK_ACTION="com.tiangehz.chatlib.CHAT_SDK_CALL_BACK_ACTION";
    private final String CHAT_SDK_CALL_BACK_EXTRA ="errcode";

    public static int netType = -1;// 网络类型 ，0-－电信，1-－网通，2-－其他

    public class MyBinder extends Binder {
        public ChatService getChatService(){
            return ChatService.this;
        }
    }

    @Override
    public void onCreate() {
        DebugLog.i(TAG, "ChatSDKService onCreate");
        super.onCreate();
        mService = ChatService.this;
        //startNetWorkListen();
    }

    @Override
    public IBinder onBind(Intent intent) {
        DebugLog.e(TAG, "CharService onBind()");
        return myBinder;
    }


    public void setDeviceInfo(String deviceid,String version)
    {
        m_deviceid=deviceid;
        m_deviceSoftVer=version;

    }

    public static void initGGPPlus(Context mContext) {
        DebugLog.e(TAG, "ChatService initGGPPlus()");
        ChatService.mContext = mContext;
        DebugLog.e(TAG, "ChatService initGGPPlus()2");
        mService.mChatApplication = getApplicationInstance();
        DebugLog.e(TAG, "ChatService initGGPPlus()3");
        if (null == mService.mChatApplication) {
            DebugLog.e(TAG, "ChatService initGGPPlus()4");
            DebugLog.e(TAG, "null==ChatSDKApplication");
            return;
        }
        getInstance().goRoomLogin();

    }

    //链接房间服务器
    public void goRoomLogin(){
        DebugLog.i(TAG,"ChatService goRoomLogin()");
        if(mChatRoomSocket == null){
            mChatRoomSocket = new ChatRoomSocket();
            mChatRoomSocket.init(mContext, m_RoomHandler);
            mChatRoomSocket.setDeviceInfo(m_deviceid,m_deviceSoftVer);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DebugLog.i(TAG, "connectRoomSvr in thread...");
                if (!checkNet(mContext)) {
                    needConSvr = 2;
                    DebugLog.i(TAG, "connectRoomSvr in thread fail,checkNet false!!");
                    return;
                }
                if (null == mChatApplication) {
                    DebugLog.e(TAG, "null==app_status");
                    return;
                }
                String strHost = null;
                int port = 0 ;
                strHost = "60.191.222.20";
                port = 6006;

                DebugLog.i(TAG, "roomsvr strHost:"+strHost+",port:"+port);
                if (strHost == null || strHost.isEmpty() || port == 0) {
                    DebugLog.e(TAG, "roomsvr host or port error!!!");
                    return;
                }

                String strIP = "";
                int num = strHost.indexOf(";", 0);
                if (num <= 0) {
                    strIP = strHost;
                } else {
                    String strIP_DX = strHost.substring(0, num);
                    String strIP_WT = strHost.substring(num + 1);
                    strIP = (netType != 1) ? strIP_DX : strIP_WT;
                }

                if(mChatApplication.chat_initParam != null){
                    mChatRoomSocket.SetLoginInfo(mChatApplication.chat_initParam.appid, mChatApplication.chat_initParam.appsvrid
                            , mChatApplication.chat_initParam.acccount, mChatApplication.chat_initParam.appToken,mChatApplication.chat_initParam.userToken);
                }
                DebugLog.e(TAG, "链接IP="+strIP+","+port);
                // 服务器连接不上
                if (!mChatRoomSocket.ConnectServer(strIP, port)) {
                    mChatRoomSocket.sendHandelMessage(ChatGlobalDef.WM_CON_ROOMSERVER_FAIL,
                            0, 0, null);
                }else {
                    CRS_Delay = 10000;
                }

            }
        });
        thread.start();

    }

    Handler m_RoomHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try {
                int nCommand = msg.what;
                DebugLog.i(TAG, "嗨咯："+nCommand);
                switch (nCommand) {
                    case ChatGlobalDef.WM_START_RECONNECT_LS_TIMER: {
                        DebugLog.i(TAG, "rev WM_START_RECONNECT_LS_TIMER");

                        // 不需要重新登录游戏
                        if (!needReLoginGame){
                            if (netState != ChatGlobalDef.NET_NONE) {
                                //sendBroadcast(intent);// 发送广播
                                //startConLsTimer();// 打开重新连接登录服务器定时器
                            } else {
                                needConSvr = 1;
                            }
                        } else {
                            DebugLog.i(TAG, "need reLogin game!!!");
						}
                        break;
                    }
                    case ChatGlobalDef.WM_STOP_RECONNECT_LS_TIMER: {
                        DebugLog.i(TAG, "rev WM_STOP_RECONNECT_LS_TIMER");
                        //stopConLsTimer();// 关闭重新连接登录服务器定时器
                        break;
                    }
                    case ChatGlobalDef.WM_START_RECONNECT_RS_TIMER: {
                        DebugLog.i(TAG, "rev WM_START_RECONNECT_RS_TIMER");

                        if (!needReLoginGame)// 不需要重新登录游戏
                        {
                            if (netState != ChatGlobalDef.NET_NONE) {
                                DebugLog.i(TAG, "重启时间2:"+CRS_Delay);
                                startConRsTimer(CRS_Delay);// 打开重新连接房间服务器定时器
                                CRS_Delay = CRS_Delay*2;
                                DebugLog.i(TAG, "重启时间b:"+CRS_Delay);
                            } else {
                                needConSvr = 2;
                            }
                        } else {
                            DebugLog.i(TAG, "need reLogin game!!!");

						}
                        break;
                    }
                    case ChatGlobalDef.WM_CLOSE_SOCKET: {
                        DebugLog.i(TAG, "rev WM_CLOSE_SOCKET");
                        loginOutChatSDK();
                        break;
                    }
                    case ChatGlobalDef.WM_CLOSE_AND_RECONNECT_SOCKET: {
                        DebugLog.i(TAG, "rev WM_CLOSE_AND_RECONNECT_SOCKET");
                        loginOutChatSDK();
                        goRoomLogin();
                        break;
                    }
                    case ChatGlobalDef.WM_LOGIN_FAIL_AND_CALL_BACK: {
                        DebugLog.i(TAG, "rev WM_LOGIN_FAIL_AND_CALL_BACK :"+ msg.arg1);
                        loginOutChatSDK();
                        Intent intent = new Intent();
                        intent.setAction(CHAT_SDK_CALL_BACK_ACTION);
                        intent.putExtra(CHAT_SDK_CALL_BACK_EXTRA, msg.arg1);
                        sendBroadcast(intent);
                        break;
                    }
                    case ChatGlobalDef.WM_LOGINING_RS: {
                        DebugLog.i(TAG, "rev WM_LOGINING_RS");
                        //sendBroadcast(intent);// 发送广播
                    }
                    case ChatGlobalDef.WM_CON_ROOMSERVER_FAIL: {
                        DebugLog.i(TAG, "rev WM_CON_ROOMSERVER_FAIL");

                        if (conRsFailNum > 3) {// 三次连不上房间服务器，就重新登录获取房间服务器地址信息
                            conRsFailNum = 0;

                            if (netState != ChatGlobalDef.NET_NONE) {
                                //intent.putExtra("type", 0);
                                //sendBroadcast(intent);// 发送广播

                                //startConLsTimer();// 打开重新连接登录服务器定时器
                            } else {
                                needConSvr = 1;
                            }
                        } else {
                            conRsFailNum++;

                            if (netState != ChatGlobalDef.NET_NONE) {
                                //intent.putExtra("type", 1);
                                //sendBroadcast(intent);// 发送广播
                                DebugLog.i(TAG, "重启时间3:"+CRS_Delay);
                                startConRsTimer(CRS_Delay);// 打开重新连接房间服务器定时器
                                CRS_Delay = CRS_Delay * 2;
                                DebugLog.i(TAG, "重启时间a:"+CRS_Delay);
                            } else {
                                needConSvr = 2;
                            }
                        }
                        break;
                    }
                    case ChatGlobalDef.WM_SHOW_SYSMSG: {
                        DebugLog.i(TAG, "rev WM_SHOW_SYSMSG");
                        break;
                    }
                    case ChatGlobalDef.WM_RS_ENTERROOM_SUCCESS: {
                        DebugLog.i(TAG, "rev WM_SHOW_SYSMSG");
                        break;
                    }
                    case ChatGlobalDef.WM_RS_ENTERROOM_FAIL: {
                        DebugLog.i(TAG, "rev WM_RS_ENTERROOM_FAIL");
                        break;
                    }
                    case ChatGlobalDef.WM_RS_OTHERPLACE_LOGIN: {
                        DebugLog.i(TAG, "rev WM_RS_OTHERPLACE_LOGIN");
                        needReLoginGame = true;// 需要重新登录游戏
                        break;
                    }
                    case ChatGlobalDef.WM_RS_UPDATE_FORTUNE: {
                        DebugLog.i(TAG, "rev WM_RS_UPDATE_FORTUNE");
                        break;
                    }
                    default: {
                        DebugLog.i(TAG, "rev Unknown Msg");
                        break;
                    }
                }
            }catch (Exception e) {
                DebugLog.e(TAG, e.toString());
            }
        }
    };


    //重新连接房间服务器定时器
    private void startConRsTimer(int delaysec){

        DebugLog.i(TAG,"startConRsTimer!");

        if (mTimer_R != null) {
            mTimer_R.cancel();
            mTimer_R = null;
        }

        if (mTimerTask_R != null) {
            mTimerTask_R.cancel();
            mTimerTask_R = null;
        }

        mTimer_R = new Timer();
        mTimerTask_R = new TimerTask() {
            @Override
            public void run() {
                DebugLog.i(TAG, "ConRsTime come,connectRoomSvr.. ");
                goRoomLogin();
            }
        };

        if(delaysec>0)
        {
            DebugLog.i(TAG, "重启时间1:"+delaysec);
            mTimer_R.schedule(mTimerTask_R, delaysec);
        }
        else
        {
            mTimer_R.schedule(mTimerTask_R, CRS_Delay);
        }
    }

    /**
     * 检测w网络是否可用
     */
    public static boolean checkNet(Context context) {

        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {

                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {

                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public void loginOutChatSDK(){
        if(null != mChatRoomSocket) {
            mChatRoomSocket.iscloseByClient = true;
            mChatRoomSocket.closeByClient();
        }
    }

    public static ChatService getInstance() {
        return mService;
    }

    public static ChatApplication getApplicationInstance() {
        return (ChatApplication) mContext.getApplicationContext();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //stopNetWorkReceiver();

        if(null != mChatRoomSocket) {
            mChatRoomSocket.iscloseByClient = true;
            mChatRoomSocket.closeByClient();
        }
        m_RoomHandler.removeCallbacksAndMessages(null);
        m_RoomHandler = null;
        mChatRoomSocket = null;
    }
}
