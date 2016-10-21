package com.hp.tcp.application;

import android.app.Application;

import com.hp.tcp.entity.ChatInitConfig;

/**
 * Created by tgkj on 2016/10/10.
 */
public class ChatApplication extends Application {

    public static String TAG = "aaaaaaaabbbbbbbbbbbb";
    public ChatInitConfig chat_initParam 	= null;//房间初始化信息
    public ChatInitConfig chat_loginParam   = null;//登录后信息
    private static boolean chat_Logined 	= false; // 登陆状态 true:已登录; false:未登录


    //获取登录状态
    public boolean isChatLogined(){
        synchronized (this){
            return chat_Logined;
        }
    }
    //设置登录状态
    public void setChatLogined(boolean logined){
        synchronized (this){
            chat_Logined = logined;
        }
    }

}
