package com.hp.tcp;

public class ChatGlobalDef {
		//网络
		public static final int NET_NONE	= 0;
		public static final int NET_WIFI	= 1;
		public static final int NET_MOBILE	= 2;
		
		public static final String INTENT_BROADCASTER_IDX = "broadcasterid";
		public static final int PG_MSG_TOAST=0;//提示消息
		public static final int PG_MSG_ROOM_NOTIC=1;//房间公告
		public static final int PG_MSG_SYS_NOTIC=2;//系统公告
		
		
		//显示喇叭
		public static final int IM_SPEAKER_SHOW=10000;
		//隐藏喇叭
		public static final int IM_SPEAKER_HIDE=10001;
		//隐藏喇叭
		public static final int IM_SPEAKER_HIDE_ENTERROOM=10002;
		public static final int IM_SPEAKER_SHOW_LEAVEROOM=10003;
		//退出应用销毁喇叭
		public static final int IM_SPEAKER_CLOSE=10004;
		//退出应用销毁喇叭
		public static final int IM_SPEAKER_OUTTOWINDOWS=10005;
		//退出应用销毁喇叭
		public static final int IM_SPEAKER_BACKTOAPP=10006;
		//进入充值界面
		public static final int IM_ENTER_PAYVIEW=10007;
		
		//////消息
		public static final int WM_USER					 			= 0x0400;
		public static final int WM_CHAT				 			= 0x123;
		
		//登录
		public static final int WM_NET_LOST							= WM_USER + 1; 
		public static final int WM_NET_LINK							= WM_USER + 2;
		public static final int WM_ALL_SERVER_FAIL					= WM_USER + 4; 
		public static final int WM_ON_LOGIN							= WM_USER + 5; 
		public static final int WM_LOGIN_SUCCESS 					= WM_USER + 6;    
		public static final int WM_LOGIN_FAILED 					= WM_USER + 7;
		
		//房间
		public static final int WM_RCONNECT_SUCCESS                 = WM_USER + 100;    //房间断线重连成功
		public static final int WM_RCONNECTION_LOST					= WM_USER + 101;    
		public static final int WM_START_RECONNECT_LS_TIMER         = WM_USER + 102;
		public static final int WM_STOP_RECONNECT_LS_TIMER          = WM_USER + 103;
		public static final int WM_START_RECONNECT_RS_TIMER         = WM_USER + 104;
		public static final int WM_CLOSE_SOCKET				        = WM_USER + 105;
		public static final int WM_LOGIN_FAIL_AND_CALL_BACK    		= WM_USER + 106;
		public static final int WM_LOGINING_RS             			= WM_USER + 107;
		public static final int WM_CLOSE_AND_RECONNECT_SOCKET  		= WM_USER + 108;
		
		public static final int WM_CON_ROOMSERVER_FAIL			    = WM_USER + 200;
		public static final int WM_SHOW_SYSMSG					    = WM_USER + 201;
		public static final int WM_RS_ENTERROOM_SUCCESS             = WM_USER + 202;
		public static final int WM_RS_ENTERROOM_FAIL                = WM_USER + 203;
		public static final int WM_RS_OTHERPLACE_LOGIN              = WM_USER + 204;
		
		public static final int WM_RS_UPDATE_FORTUNE                = WM_USER + 207;
		public static final int WM_RS_UPDATE_GAMEMONEY              = WM_USER + 213;
		public static final int WM_RS_READ_PEOINFO                  = WM_USER + 214;
		public static final int WM_RS_UPDATE_REFER					= WM_USER + 215;
		public static final int WM_RS_USER_FLASHMONEY			    = WM_USER + 216;
		public static final int WM_RS_USER_CHAT			    		= WM_USER + 217;
		public static final int WM_RS_CHAT_REP                      = WM_USER + 218;
		public static final int WM_RS_COUNTRY_PEOINFO               = WM_USER + 220;
		public static final int WM_RS_FAMILY_PEOINFO				= WM_USER + 221;
		public static final int WM_RS_SYS_NOTICE					= WM_USER + 222;
		public static final int WM_RS_USER_GIFT						= WM_USER + 223;
		public static final int WM_RS_GIFT_FAIL						= WM_USER + 224;
		public static final int WM_RS_USER_LUCKWIN					= WM_USER + 225;
		public static final int WM_RS_PICK_YH						= WM_USER + 226;
		public static final int WM_RS_SEND_HB						= WM_USER + 227;
		public static final int WM_RS_USER_GET_HBLIST				= WM_USER + 228;
		public static final int WM_RS_ROB_HB						= WM_USER + 229;
		public static final int WM_RS_USER_GAMELH					= WM_USER + 230;
		public static final int WM_RS_GAMELH_FAIL					= WM_USER + 231;
		public static final int WM_RS_SET_MEDIA						= WM_USER + 240;
		public static final int WM_RS_SET_MEDIA_FAIL				= WM_USER + 241;
		public static final int WM_RS_USER_SEND_TL					= WM_USER + 242;
		public static final int WM_RS_USER_REV_TL					= WM_USER + 243;
		public static final int WM_RS_RETURN_TL                     = WM_USER + 244;
		//add 2014/11/20
		public static final int WM_RS_LAST_CHATLIST                 = WM_USER + 245;
		public static final int WM_RS_USR_SHBL_DETAIL               = WM_USER + 246;
		public static final int WM_RS_SET_DETAIL                    = WM_USER + 247;
		public static final int WM_RS_GET_TJFRDLIST                 = WM_USER + 248;
		
		
		public static final int WM_RS_WITI_CHATLIST                 = WM_USER + 248;//检测网络
		public static final int WM_RS_ROOM_LIST                 = WM_USER + 249;	//房间回复消息
		public static final int WM_RS_CHTAT_LIST                 = WM_USER + 250;	//房间回复消息
		public static final int WM_RS_ROOM_MSG                 = WM_USER + 251;		//重新发送消息
		public static final int WM_RS_ROOM_SEND                 = WM_USER + 252;	//发送超时
		public static final int WM_RS_ROOM_TIMER               = WM_USER + 253;		//定时器
		public static final int WM_RS_ROOM_SEND_1                 = WM_USER + 254;	//发送超时
		public static final int WM_RS_ROOM_HISTORY                 = WM_USER + 255;	//查询历史记录
		public static final int WM_RS_ROOM_NO_HISTORY                 = WM_USER + 256;	//没有历史记录
		public static final int WM_RS_LIST_STOP              = WM_USER + 257;	//当页面停止的时候再刷新
}
