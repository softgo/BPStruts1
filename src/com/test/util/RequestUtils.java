package com.test.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * request util
 * 
 * @author admin
 *
 */
public class RequestUtils {
	
    /**
     * 获取IP地址
     * @param request
     * @return
     */
    public static String getRemoteIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
    
	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		//String ip = request.getHeader("X-REAL-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 登录名.
	 * @param request
	 * @return
	 */
	public static String getUserName(HttpServletRequest request){
		return request.getParameter("userName");
	}
	
	
	/**
	 * 密码.
	 * @param request
	 * @return
	 */
	public static String getUserPass(HttpServletRequest request){
		return request.getParameter("password");
	}
	
	/**
	 * uuid.
	 * @param request
	 * @return
	 */
	public static String getUserUUid(HttpServletRequest request){
		String requestUuid = request.getParameter("uuid");
		if (StringUtils.isEmpty(requestUuid)) {
			requestUuid = request.getAttribute("uuid")+"";
		}
		return requestUuid;
	}
	
	/**
	 * userCode.
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserCode(HttpServletRequest request){
		String requestUserCode = request.getParameter("userCode");
		if (StringUtils.isEmpty(requestUserCode)) {
			requestUserCode = request.getAttribute("userCode")+"";
		}
		return requestUserCode;
	}
}
