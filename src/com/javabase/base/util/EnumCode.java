package com.javabase.base.util;

/**
 * 返回状态码
 * 
 * @author bruce
 *
 */
public class EnumCode {

	public static String NO0 = "10000"; //"服务器处理客户端请求成功"
	public static String NO1 = "10001"; //"服务器接收到客户端请求"
	public static String NO2 = "10002"; //"服务器连接数据库失败"
	public static String NO3 = "10003"; //"服务器操作数据库失败"
	public static String NO4 = "10004"; //"服务器没有得到数据库数据"
	public static String NO5 = "10005"; //"服务器处理内部逻辑失败"
	public static String NO6 = "10006"; //"数据库返回为null"
	
	//判断是否是多方登录.
	public static String NO7 = "8888"; //"已经登录过服务端"
	public static String NO8 = "9999"; //"首次登录服务端"
	public static String NO9 = "10007"; //"输入参数有误,数据校验失败"

}
