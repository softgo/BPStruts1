package com.test.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;


/**
 * 获取公共参数
 * @author admin
 */
public class RequestParamUtils {
    
    /**
     * 获得参数的供用类.
     * @param request
     * @return
     */
    public static final RequestParams getRequestParams(HttpServletRequest request){
        synchronized (request) {
            RequestParams params = new RequestParams();
            params.userName = request.getParameter("userName");
            params.mobileNumber = request.getParameter("mobileNumber");
            params.nonoCode = request.getParameter("nonoCode");
            params.userCode = request.getParameter("userCode");
            params.productCode = request.getParameter("productCode");
            params.certificateNumber = request.getParameter("certificateNumber");
            params.userType = request.getParameter("userType");
            params.orderId = request.getParameter("orderId");
            params.amount = request.getParameter("amount");
            params.pageIndex = request.getParameter("pageIndex");
            params.pageSize = request.getParameter("pageSize");
            params.startDate = request.getParameter("startDate");
            params.endDate = request.getParameter("endDate");
            
            if (StringUtils.isNotEmpty(params.userName)) {
                params.userName = params.userName.trim();
            }else{
                params.userName = "";
            }
            if (StringUtils.isNotEmpty(params.mobileNumber)) {
                params.mobileNumber = params.mobileNumber.trim();
            }else{
                params.mobileNumber = "";
            }
            if (StringUtils.isNotEmpty(params.nonoCode)) {
                params.nonoCode = params.nonoCode.trim();
            }else{
                params.nonoCode = "";
            }
            if (StringUtils.isNotEmpty(params.userCode)) {
                params.userCode = params.userCode.trim();
            }else{
                params.userCode = "";
            }
            if (StringUtils.isNotEmpty(params.productCode)) {
                params.productCode = params.productCode.trim();
            }else{
                params.productCode = "";
            }
            if (StringUtils.isNotEmpty(params.certificateNumber)) {
                params.certificateNumber = params.certificateNumber.trim();
            }else{
                params.certificateNumber = "";
            }
            if (StringUtils.isNotEmpty(params.userType)) {
                params.userType = params.userType.trim();
            }else{
                params.userType = "";
            }
            if (StringUtils.isNotEmpty(params.orderId)) {
                params.orderId = params.orderId.trim();
            }else{
                params.orderId = "";
            }
            if (StringUtils.isNotEmpty(params.amount)) {
                params.amount = params.amount.trim();
            }else{
                params.amount = "";
            }
            if (StringUtils.isNotEmpty(params.pageIndex)) {
                params.pageIndex = params.pageIndex.trim();
            }else{
                params.pageIndex = "";
            }
            if (StringUtils.isNotEmpty(params.pageSize)) {
                params.pageSize = params.pageSize.trim();
            }else{
                params.pageSize = "";
            }
            if (StringUtils.isNotEmpty(params.startDate)) {
                params.startDate = params.startDate.trim();
            }else{
                params.startDate = "";
            }
            if (StringUtils.isNotEmpty(params.endDate)) {
                params.endDate = params.endDate.trim();
            }else{
                params.endDate = "";
            }
            return params;
        }
    }
    
    /**
     * 公共请求对象.
     * @author admin
     */
    public static class RequestParams{
        public String userName; //用户的真实名字
        public String mobileNumber; //手机号
        public String nonoCode; //诺诺对应的id号
        public String userCode; //财神对应的id号
        public String certificateNumber; //身份证号
        public String productCode; //财神对应的id号
        public String userType; //用户投资的类型：nnbk:mxd
        
        public String orderId; //订单id号
        public String amount; //传入的金额
        public String pageIndex; //起始也索引
        public String pageSize; //每页的数据大小
        public String startDate; //开始时间
        public String endDate; //结束时间
        
        @Override
        public String toString() {
            return "RequestParams{" +
                    "userName='" + userName + '\'' +
                    ", mobileNumber='" + mobileNumber + '\'' +
                    ", nonoCode='" + nonoCode + '\'' +
                    ", userCode='" + userCode + '\'' +
                    ", certificateNumber='" + certificateNumber + '\'' +
                    ", productCode='" + productCode + '\'' +
                    ", userType='" + userType + '\'' +
                    ", orderId='" + orderId + '\'' +
                    ", amount='" + amount + '\'' +
                    ", pageIndex='" + pageIndex + '\''+
                    ", pageSize='" + pageSize + '\''+
                    ", startDate='" + startDate + '\''+
                    ", endDate='" + endDate + '\''+
                    '}';
        }
    }
}
