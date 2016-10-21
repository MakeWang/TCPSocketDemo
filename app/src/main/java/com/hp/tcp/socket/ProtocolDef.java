package com.hp.tcp.socket;

/**
 * @author zm
 * @version 创建时间：2014-9-15 上午11:26:26
 * 类说明
 */

public class ProtocolDef {

	public static final int RETURN_SUCC		 				= 0;

	public class MainCmdDef {
		public static final int  NTP_CLIENT_LOGINSVR   =1;
		public static final int  NTP_CLIENT_ROOMSVR    =2;
		public static final int  NTP_SERVER_STATUS     =255;

	}
	

	
	//客户端与房间服务器消息
	public class SubRsCmdDef
	{
		public static final int CMD_RS_WELCOME_GET 						=1;
	    
		public static final int CMD_RS_USER_LOGIN_SEND 					=10;	//登陆
		public static final int CMD_RS_USER_LOGIN_REP 					=11;	//登陆返回
		public static final int CMD_RS_OTHER_LOGIN_GET 					=12;	//用户在其他地方登陆
		
	    public static final int CMD_RS_USER_HELLO_SEND_AND_REP			=20;	//打招呼消息 
		
		public static final int CMD_RS_USER_CHAT_SEND_AND_GET 			=30;	//聊天消息
		public static final int CMD_RS_CHAT_REP							=31;	//发送聊天返回结果
		public static final int CMD_RS_NEW_PERSONALMSG_SEND_AND_REP 	=40;	//最新个人聊天列表
		public static final int CMD_RS_USER_CHAT_RECORD_SEND_AND_REP 	=41;	//请求历史聊天消息
		public static final int CMD_RS_USER_STATUS_SEND			 		=42;	//发送用户状态
		
		public static final int CMD_RS_CLIENT_HEART_SEND				=100;	//客户端发出的心跳包
		public static final int CMD_RS_HEART_REP						=101;	//服务器回复的心跳包
		
		
	}


}
