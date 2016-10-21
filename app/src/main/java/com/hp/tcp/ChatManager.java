package com.hp.tcp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.telephony.TelephonyManager;

import com.hp.tcp.application.ChatApplication;
import com.hp.tcp.entity.ChatInitConfig;
import com.hp.tcp.service.ChatService;
import com.hp.tcp.util.DebugLog;

/**
 * Created by tgkj on 2016/10/10.
 */
public class ChatManager {

    //private final static String TAG = ChatManager.class.getSimpleName();
    private String TAG = "aaaaaaaabbbbbbbbbbbb";

    private static Context mContext;
    private ChatApplication mApplication;
    private ChatService mBindService;


    private static class ChatServiceManagerInstance {
        private static final ChatManager instance = new ChatManager();
    }

    public static ChatManager getInstance() {
        return ChatServiceManagerInstance.instance;
    }


    public void initialize(Context mContext, ChatInitConfig initInfo) {
        DebugLog.e(TAG, "initialize()");
        this.mContext = mContext;
        mApplication = getApplicationInstance();
        if (null == mApplication) {
            DebugLog.e(TAG, "null==ChatSDKApplication");
            return;
        }
        // 保存始化参数
        mApplication.chat_initParam = initInfo;
        DebugLog.e(TAG, "finish initialize()");
    }

    public void installChatSystem() {
        DebugLog.e(TAG, "installChatSystem()");
        Intent intent = new Intent(mContext, ChatService.class);
        if(mBindService == null){//防止用户注销后.二次绑定登录失败
            mContext.bindService(intent, conn, Context.BIND_AUTO_CREATE);
            DebugLog.e(TAG, "mBindService is null");
        }else {
            DebugLog.e(TAG, "mBindService login");
            mBindService.goRoomLogin();
        }
    }

    private ServiceConnection conn = new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DebugLog.i(TAG,"onServiceConnected()");
            ChatService.MyBinder binder = (ChatService.MyBinder) service;
            mBindService = binder.getChatService();
            if(mApplication.chat_initParam == null || mApplication.chat_loginParam == null || (mApplication.isChatLogined() && Long.valueOf(mApplication.chat_initParam.acccount)!= Long.valueOf(mApplication.chat_loginParam.acccount))){
                String str_imei=getIMEI(mContext);
                String m_deviceid="IMEI:"+(str_imei==null?"unknown":str_imei);

                Build bd = new Build();
                String model = bd.MODEL;
                String m_deviceSoftwareVersion=model+ "," + android.os.Build.VERSION.RELEASE;
                DebugLog.i(TAG,"OS environment:"+m_deviceid+","+m_deviceSoftwareVersion);
                mBindService.setDeviceInfo(m_deviceid,m_deviceSoftwareVersion);
                mBindService.initGGPPlus(mContext);

            }else {
                DebugLog.i(TAG,mApplication.chat_initParam.acccount+"has logined!");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            DebugLog.i(TAG, "onServiceDisconnected()");
        }
    };

    /**
     * 获取IMEI
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    public static ChatApplication getApplicationInstance() {
        return (ChatApplication) mContext.getApplicationContext();
    }
}
