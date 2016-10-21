package com.hp.tcp;

import android.app.Activity;
import android.os.Bundle;

import com.hp.tcp.application.ChatApplication;
import com.hp.tcp.entity.ChatInitConfig;
import com.hp.tcp.util.DebugLog;

/**
 * Created by tgkj on 2016/10/10.
 */
public class MainActivity extends Activity {

    private ChatManager mChatManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChatInitConfig info = new ChatInitConfig();
        info.appid = 1;//TestConfig.appid;
        info.appsvrid =0;// TestConfig.appsvrid;
        info.acccount = Long.parseLong("18867938484");//TestConfig.acccount;
        info.userToken = "7e0512609f683cf0699413deb15e2eec";//TestConfig.userToken;
        info.appToken = "91d9bc36-10c2-11e5-8635-00101818581b";//TestConfig.appToken;

        /*
        info.appid = 1;
        info.appsvrid =1;
        info.acccount = Long.parseLong("53257363");
        info.userToken = "e5716bcebefaffeeb899827caf7e6162";
        info.appToken = "b7c9d661-10c2-11e5-8635-00101818581b";*/
        DebugLog.i(ChatApplication.TAG,"来了");
        mChatManager = ChatManager.getInstance();
        mChatManager.initialize(this,info);
        mChatManager.installChatSystem();

    }

}
