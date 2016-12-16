package com.test.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javabase.base.BaseController;
import com.javabase.base.app.LOG4jUtils;
import com.javabase.base.redis.RedisUtil;
import com.javabase.base.util.ContainerUtils;
import com.javabase.base.util.EnumCode;
import com.test.dto.UserAssetsBean;
import com.test.entity.NonoTransDetail;
import com.test.entity.NonoUser;
import com.test.service.NonoTransDetailService;
import com.test.service.NonoUserProductService;
import com.test.service.NonoUserService;
import com.test.util.RequestParamUtils;
import com.test.util.RequestParamUtils.RequestParams;
import com.test.util.RequestUtils;
import com.test.util.ValidUtils;

@Controller
@RequestMapping("/nonoWallet")
public class NonoWalletController extends BaseController {
    
    @Autowired
    private  RedisUtil redisUtil; 
    @Autowired
    private NonoUserService nonoUserService;
    @Autowired
    private NonoTransDetailService nonoTransDetailService;
    @Autowired
    private NonoUserProductService nonoUserProductService;
    
    String  keyHead = "ip-store:";
    
    String errorHead = "诺诺钱包的日志信息:";
    
    /**
     * 检测诺诺会员接口.
     * @param request
     * @return map
     */
    @RequestMapping("/checkNonoUser")
    @ResponseBody
    public Map<String, Object> checkNonoUser(HttpServletRequest request){
        LOG4jUtils.tracer(errorHead+"checkNonoUser 接收到的请求参数是："+RequestParamUtils.getRequestParams(request));
        Map<String, Object>  resultMap = new HashMap<String, Object>();
        boolean statusFlag = checkNonoStatus();
        if (!statusFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台已经关闭提供给诺诺相应服务", EnumCode.NO0);
        }
        String requestIp = RequestUtils.getIpAddress(request);
        LOG4jUtils.audit(errorHead+"checkNonoUser requestIp ="+requestIp);
        //String requestIp = RequestUtils.getRemoteIP(request);
        if (StringUtils.isEmpty(requestIp)) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有接收到访问的IP地址", EnumCode.NO0);
        }
        boolean ipFlag = ifBelieveIPs(requestIp);
        if (!ipFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台接收到非授信的IP地址", EnumCode.NO0);
        }
        //业务逻辑处理
        try {
            RequestParams params = RequestParamUtils.getRequestParams(request);
            String userName = params.userName;
            String mobileNumber = params.mobileNumber;
            String nonoCode = params.nonoCode ;
            String certificateNumber = params.certificateNumber;
            NonoUser tmpUser = null;
            boolean flag = false;
            if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(mobileNumber) && StringUtils.isNotEmpty(nonoCode) && StringUtils.isNotEmpty(certificateNumber)) {
                if (!ValidUtils.isMobile(mobileNumber)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的手机号", EnumCode.NO3);
                }else if (!ValidUtils.isNO(certificateNumber)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的身份证号", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(nonoCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的nonoCode", EnumCode.NO3);
                }
                
                tmpUser = new NonoUser(nonoCode,certificateNumber);
                NonoUser nonoUser = nonoUserService.findByProps(tmpUser);
                if (nonoUser!=null) {
                    resultMap.put("userCode", nonoUser.getUserCode()+"");
                    flag = true;
                }else {
                    //添加新用户
                    tmpUser = new NonoUser(userName, mobileNumber, nonoCode, certificateNumber);
                    int count = nonoUserService.addOne(tmpUser);
                    if (count >0) {
                        resultMap.put("userCode", tmpUser.getUserCode()+"");
                        flag = true;
                    }else{
                        resultMap.put("userCode", "0");
                    }
                }
                if (flag) {
                    resultMap.put("status", "1");
                    return ContainerUtils.buildResMap(resultMap, 1, "服务器处理诺诺会员检测信息成功", EnumCode.NO0);
                }else{
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器处理诺诺会员检测信息失败", EnumCode.NO3);
                }
            }else{
                return ContainerUtils.buildHeadMap(resultMap, 0, "请输入该接口所需的全部参数", EnumCode.NO0);
            }
        }
        catch (Exception e) {
            LOG4jUtils.error(errorHead+"检测诺诺会员接口——>服务器处理请求逻辑失败", e);
            return ContainerUtils.buildHeadMap(resultMap, 0,"服务器处理请求逻辑失败",EnumCode.NO5);
        }
    }
    
    /**
     * 诺诺会员购买接口.
     * @param request
     * @return map
     */
    @RequestMapping("/buyCSProduct")
    @ResponseBody
    public Map<String, Object> buyCSProduct(HttpServletRequest request){
        LOG4jUtils.tracer(errorHead+"buyCSProduct 接收到的请求参数是："+RequestParamUtils.getRequestParams(request));
        Map<String, Object>  resultMap = new HashMap<String, Object>();
        boolean statusFlag = checkNonoStatus();
        if (!statusFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台已经关闭提供给诺诺相应服务", EnumCode.NO0);
        }
        String requestIp = RequestUtils.getIpAddress(request);
        LOG4jUtils.audit(errorHead+"buyCSProduct requestIp ="+requestIp);
        if (StringUtils.isEmpty(requestIp)) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有接收到访问的IP地址", EnumCode.NO0);
        }
        boolean ipFlag = ifBelieveIPs(requestIp);
        if (!ipFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台接收到非授信的IP地址", EnumCode.NO0);
        }
        String limitNum  = "1000000";
        if (StringUtils.isEmpty(limitNum)) {
            limitNum = "2000000";
        }
        BigDecimal limitAmount = new BigDecimal(limitNum);
        //参数
        RequestParams params = RequestParamUtils.getRequestParams(request);
        String orderId = params.orderId;
        String amount = params.amount;
        String nonoCode = params.nonoCode ;
        String userCode = params.userCode;
        String certificateNumber = params.certificateNumber;
        String userType = params.userType;
        String productCode = params.productCode;
        
        try {
            String dataCode = null;
            NonoUser tmpUser = null;
            if (StringUtils.isNotEmpty(orderId) && StringUtils.isNotEmpty(amount) && StringUtils.isNotEmpty(nonoCode) && StringUtils.isNotEmpty(certificateNumber) && StringUtils.isNotEmpty(userType)) {
                if (!ValidUtils.isNO(certificateNumber)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的身份证号", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(nonoCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的nonoCode", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(userCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的userCode", EnumCode.NO3);
                }else if (!ValidUtils.isDouble(amount)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的金额", EnumCode.NO3);
                }
                
                BigDecimal buyAmount = new BigDecimal(amount);
                if (buyAmount.compareTo(BigDecimal.ZERO) <= 0) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请检查输入的购买金额大于零", EnumCode.NO0);
                }
                NonoTransDetail tmpDetail = new NonoTransDetail();
                tmpDetail.setOrderId(orderId);
                NonoTransDetail transDetail = nonoTransDetailService.findByProps(tmpDetail); 
                if (transDetail!=null && transDetail.getAmount().compareTo(BigDecimal.ZERO)>0) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器接收到该订单号已经存在,请勿重复操作", EnumCode.NO0);
                }
                BigDecimal dataAmount  = new BigDecimal("20000");
                if (dataAmount!=null && dataAmount.compareTo(limitAmount) >= 0) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "已经超过当日限额,请明日再来购买", EnumCode.NO0);
                }
                if (StringUtils.isEmpty(productCode)) {
                    productCode = "NN0005";
                }
                if (StringUtils.isNotEmpty(userType)) {
                    userType = userType.toUpperCase();
                }
                tmpUser = new NonoUser(nonoCode,certificateNumber);
                NonoUser nonoUser = nonoUserService.findByProps(tmpUser);
                if (nonoUser==null) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有找到对应用户的信息", EnumCode.NO0);
                }
                if (nonoUser.getUserCode() != null && nonoUser.getUserCode() >0 ) {
                    dataCode = nonoUser.getUserCode()+"";
                }else {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器接收到用户的验证信息异常", EnumCode.NO0);
                }
                if (!dataCode.equals(userCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "用户的信息在服务器中不存在", EnumCode.NO0);
                }
                //直接操作充值业务.
                return nonoUserProductService.allocateDebts(orderId, buyAmount, nonoCode, Integer.valueOf(userCode),productCode, userType);
            }else{
                return ContainerUtils.buildHeadMap(resultMap, 0, "服务器没有接到诺诺调用所需要的全部参数", EnumCode.NO0);
            }
        }
        catch (Exception e) {
            LOG4jUtils.error(errorHead+"诺诺会员购买接口——>服务器处理诺诺会员购买操作失败", e);
            return ContainerUtils.buildHeadMap(resultMap, 0,"服务器处理诺诺会员购买操作失败",EnumCode.NO5);
        }
    }
    
    /**
     * 诺诺会员提现接口.
     * @param request
     * @return map
     */
    @RequestMapping("/withdrawCSProduct")
    @ResponseBody
    public Map<String, Object> withdrawCSProduct(HttpServletRequest request){
    	
    	return new HashMap<>();
    	
    	/*
        LOG4jUtils.tracer(errorHead+"withdrawCSProduct 接收到的请求参数是："+RequestParamUtils.getRequestParams(request));
        Map<String, Object>  resultMap = new HashMap<String, Object>();
        boolean statusFlag = checkNonoStatus();
        if (!statusFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台已经关闭提供给诺诺相应服务", EnumCode.NO0);
        }
        String requestIp = RequestUtils.getIpAddress(request);
        LOG4jUtils.audit("withdrawCSProduct requestIp ="+requestIp);
        if (StringUtils.isEmpty(requestIp)) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有接收到访问的IP地址", EnumCode.NO0);
        }
        boolean ipFlag = ifBelieveIPs(requestIp);
        if (!ipFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台接收到非授信的IP地址", EnumCode.NO0);
        }
        //业务逻辑处理
        try {
            RequestParams params = RequestParamUtils.getRequestParams(request);
            String orderId = params.orderId;
            String amount = params.amount;
            String userCode = params.userCode ;
            String nonoCode = params.nonoCode ;
            String certificateNumber = params.certificateNumber;
            String productCode = params.productCode;
            String userType = params.userType ;
            String dataCode = null;
            NonoUser tmpUser = null;
            if (StringUtils.isNotEmpty(orderId) && StringUtils.isNotEmpty(amount) && StringUtils.isNotEmpty(nonoCode) && StringUtils.isNotEmpty(certificateNumber) && StringUtils.isNotEmpty(userType)) {
                if (!ValidUtils.isNO(certificateNumber)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的身份证号", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(nonoCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的nonoCode", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(userCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的userCode", EnumCode.NO3);
                }else if (!ValidUtils.isDouble(amount)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的金额", EnumCode.NO3);
                }
                NonoTransDetail tmpDetail = new NonoTransDetail();
                tmpDetail.setOrderId(orderId);
                NonoTransDetail transDetail = nonoTransDetailService.findByProps(tmpDetail); 
                if (transDetail!=null && transDetail.getAmount().compareTo(BigDecimal.ZERO)>0) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器接收到该订单号已经存在,请勿重复操作", EnumCode.NO0);
                }
                
                BigDecimal withdrawAmount = new BigDecimal(amount);
                if (withdrawAmount.compareTo(BigDecimal.ZERO) <= 0) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请检查输入的购买金额是否合理", EnumCode.NO0);
                }
                if (StringUtils.isEmpty(productCode)) {
                    productCode = "NN0005";
                }
                if (StringUtils.isNotEmpty(userType)) {
                    userType = userType.toUpperCase();
                }
                tmpUser = new NonoUser(nonoCode,certificateNumber);
                NonoUser nonoUser = nonoUserService.findByProps(tmpUser);
                if (nonoUser==null) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有找到对应用户的信息", EnumCode.NO0);
                }
                if (nonoUser.getUserCode() != null && nonoUser.getUserCode() >0 ) {
                    dataCode = nonoUser.getUserCode()+"";
                }else {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器接收到用户的验证信息异常", EnumCode.NO0);
                }
                if (!dataCode.equals(userCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "用户的信息在服务器中不存在", EnumCode.NO0);
                }
                UserAssetsBean userAssetsBean = new UserAssetsBean(userCode, nonoCode, userType);
                Double totalTypeAmount = nonoUserProductService.getNonoUserTotalAssets(userAssetsBean);
                if (totalTypeAmount==null || totalTypeAmount.doubleValue() == 0) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有通过用户找到对应提现记录", EnumCode.NO0);
                }
                BigDecimal dataAmount = new BigDecimal(totalTypeAmount);
                BigDecimal inputAmount = new BigDecimal(amount);
                if (dataAmount.compareTo(inputAmount) < 0) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "您的提现金额大于您的账户资产,不能完成此提现操作", EnumCode.NO0);
                }
                //提现的主要逻辑.
                return nonoUserProductService.releaseDebts(orderId, withdrawAmount, nonoCode, Integer.valueOf(userCode),productCode, userType);
            }else{
                return ContainerUtils.buildHeadMap(resultMap, 0, "服务器没有接到诺诺调用所需要的全部参数", EnumCode.NO0);
            }
        }
        catch (Exception e) {
            LOG4jUtils.error(errorHead+"诺诺会员提现接口——>服务器处理诺诺会员提现操作失败", e);
            return ContainerUtils.buildHeadMap(resultMap, 0,"服务器处理诺诺会员提现操作失败",EnumCode.NO5);
        }
        */
    }
    
    /**
     * 诺诺会员债权人列表接口.
     * @param request
     * @return map
     */
    @RequestMapping("/listCSProductDebters")
    @ResponseBody
    public Map<String, Object> listCSProductDebters(HttpServletRequest request){
    	Map<String, Object>  resultMap = new HashMap<String, Object>();
    	return resultMap;
    	
    	/*
    	LOG4jUtils.tracer(errorHead+"listCSProductDebters 接收到的请求参数是："+RequestParamUtils.getRequestParams(request));
        boolean statusFlag = checkNonoStatus();
        if (!statusFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台已经关闭提供给诺诺相应服务", EnumCode.NO0);
        }
        String requestIp = RequestUtils.getIpAddress(request);
        LOG4jUtils.audit("listCSProductDebters requestIp ="+requestIp);
        if (StringUtils.isEmpty(requestIp)) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有接收到访问的IP地址", EnumCode.NO0);
        }
        boolean ipFlag = ifBelieveIPs(requestIp);
        if (!ipFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台接收到非授信的IP地址", EnumCode.NO0);
        }
        //业务逻辑处理
        try {
            RequestParams params = RequestParamUtils.getRequestParams(request);
            String pageIndex = params.pageIndex;
            String pageSize = params.pageSize;
            String nonoCode = params.nonoCode ;
            String userCode = params.userCode ;
            String certificateNumber = params.certificateNumber;
            String userType = params.userType ;
            String productCode = params.productCode ;
            String startDate = params.startDate;
            String endDate = params.endDate;
            String dataCode = null;
            NonoUser tmpUser = null;
            if (StringUtils.isNotEmpty(pageSize) && StringUtils.isNotEmpty(nonoCode) && StringUtils.isNotEmpty(certificateNumber) && StringUtils.isNotEmpty(userType)) {
                if (!ValidUtils.isNO(certificateNumber)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的身份证号", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(nonoCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的nonoCode", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(userCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的userCode", EnumCode.NO3);
                }
                tmpUser = new NonoUser(nonoCode,certificateNumber);
                NonoUser nonoUser = nonoUserService.findByProps(tmpUser);
                if (nonoUser==null) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有找到对应用户的信息", EnumCode.NO0);
                }
                if (nonoUser.getUserCode() != null && nonoUser.getUserCode() >0 ) {
                    dataCode = nonoUser.getUserCode()+"";
                }else {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器接收到用户的验证信息异常", EnumCode.NO0);
                }
                if (!dataCode.equals(userCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "用户的信息在服务器中不存在", EnumCode.NO0);
                }
                if (StringUtils.isEmpty(productCode)) {
                    productCode = "NN0005";
                }
                if (StringUtils.isEmpty(pageIndex)) {
                    pageIndex = "1";
                }else{
                    if (!ValidUtils.isNumber(pageIndex)) {
                        return ContainerUtils.buildHeadMap(resultMap, 0, "请输入正确的索引页", EnumCode.NO0);
                    }
                }
                if (StringUtils.isEmpty(pageSize)) {
                    pageSize = "10";
                }else{
                    if (!ValidUtils.isNumber(pageSize)) {
                        return ContainerUtils.buildHeadMap(resultMap, 0, "请输入正确的条数", EnumCode.NO0);
                    }
                }
                if (StringUtils.isNotEmpty(userType)) {
                    userType = userType.toUpperCase();
                }
                Map<String, Object> inparams = new HashMap<String, Object>();
                inparams.put("userCode", userCode);
                inparams.put("nonoCode", nonoCode);
                inparams.put("userType", userType);
                inparams.put("productCode", productCode);
                if (StringUtils.isNotEmpty(startDate)) {
                    inparams.put("startDate", startDate);
                }
                if(StringUtils.isNotEmpty(endDate)){
                    inparams.put("endDate", endDate);
                }
                if (pageIndex.equals("1")) {
                    inparams.put("pageIndex", 0);
                }else{
                    inparams.put("pageIndex", Integer.valueOf(pageIndex) * Integer.valueOf(pageSize));
                }
                inparams.put("pageSize", Integer.valueOf(pageSize));
                List<DebterBean> debterList = nonoUserProductService.getNonoDebterList(inparams);
                if (debterList==null || debterList.size()==0) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器没有找到对应债权人信息", EnumCode.NO0);
                }else{
                    resultMap.put("list", debterList);
                    resultMap.put("status", "1");
                    resultMap.put("totalNum", debterList.size());
                    return ContainerUtils.buildResMap(resultMap, 1, "服务器处理诺诺会员债权人列表操作成功", EnumCode.NO0);
                }
            }else{
                return ContainerUtils.buildHeadMap(resultMap, 0, "服务器没有接到诺诺调用所需要的全部参数", EnumCode.NO0);
            }
        }
        catch (Exception e) {
            LOG4jUtils.error(errorHead+"诺诺会员债权人列表接口——>服务器处理诺诺会员债权人列表操作失败", e);
            return ContainerUtils.buildHeadMap(resultMap, 0,"服务器处理诺诺会员债权人列表操作失败",EnumCode.NO5);
        }
        */
    }
    
    /**
     * 诺诺订单状态检测接口.
     * @param request
     * @return map
     */
    @RequestMapping("/checkOrderStatus")
    @ResponseBody
    public Map<String, Object> checkOrderStatus(HttpServletRequest request){
        LOG4jUtils.tracer(errorHead+"checkOrderStatus 接收到的请求参数是："+RequestParamUtils.getRequestParams(request));
        Map<String, Object>  resultMap = new HashMap<String, Object>();
        boolean statusFlag = checkNonoStatus();
        if (!statusFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台已经关闭提供给诺诺相应服务", EnumCode.NO0);
        }
        String requestIp = RequestUtils.getIpAddress(request);
        LOG4jUtils.audit("checkOrderStatus requestIp ="+requestIp);
        if (StringUtils.isEmpty(requestIp)) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有接收到访问的IP地址", EnumCode.NO0);
        }
        boolean ipFlag = ifBelieveIPs(requestIp);
        if (!ipFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台接收到非授信的IP地址", EnumCode.NO0);
        }
        //业务逻辑处理
        try {
            RequestParams params = RequestParamUtils.getRequestParams(request);
            String orderId = params.orderId;
            String nonoCode = params.nonoCode ;
            String certificateNumber = params.certificateNumber;
            String productCode = params.productCode;
            String userType = params.userType ;
            if (StringUtils.isNotEmpty(orderId) && StringUtils.isNotEmpty(nonoCode) && StringUtils.isNotEmpty(certificateNumber) && StringUtils.isNotEmpty(userType)) {
                if (!ValidUtils.isNO(certificateNumber)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的身份证号", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(nonoCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的nonoCode", EnumCode.NO3);
                }
                if (StringUtils.isEmpty(productCode)) {
                    productCode = "NN0005";
                }
                NonoTransDetail tmpTransDetail = new NonoTransDetail(nonoCode,orderId,productCode,userType);
                NonoTransDetail nonoTransDetail = nonoTransDetailService.findByProps(tmpTransDetail);
                if (nonoTransDetail==null) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器没有检测到传入的订单号", EnumCode.NO0);
                }else {
                    resultMap.put("userCode", nonoTransDetail.getUserCode()+"");
                    resultMap.put("nonoCode", nonoCode);
                    int flag = 0;
                    String msg = "";
                    if (nonoTransDetail.getStatus()==1) {
                        resultMap.put("status", "1"); //成功流水。
                        flag = 1;
                        msg = "服务器处理诺诺订单状态为成功";
                    }else if (nonoTransDetail.getStatus()==2) {
                        resultMap.put("status", "2"); //失败流水。
                        msg = "服务器处理诺诺订单状态为失败";
                    }else {
                        resultMap.put("status", "3"); //重复流水。
                        msg = "服务器处理诺诺订单状态为重复订单";
                    }
                    return ContainerUtils.buildResMap(resultMap, flag, msg, EnumCode.NO0);
                }
            }else{
                return ContainerUtils.buildHeadMap(resultMap, 0, "服务器没有接到诺诺调用所需要的全部参数", EnumCode.NO0);
            }
        }
        catch (Exception e) {
            LOG4jUtils.error(errorHead+"诺诺订单状态检测接口——>服务器处理诺诺订单状态检测操作失败", e);
            return ContainerUtils.buildHeadMap(resultMap, 0,"服务器处理诺诺订单状态检测操作失败",EnumCode.NO5);
        }
    }
    
    /**
     * 诺诺会员总资产接口.
     * @param request
     * @return map
     */
    @RequestMapping("/getNonoUserAmount")
    @ResponseBody
    public Map<String, Object> getNonoUserAmount(HttpServletRequest request){
    	return new HashMap<>();
    	/*
        LOG4jUtils.tracer(errorHead+"getNonoUserAmount 接收到的请求参数是："+RequestParamUtils.getRequestParams(request));
        Map<String, Object>  resultMap = new HashMap<String, Object>();
        boolean statusFlag = checkNonoStatus();
        if (!statusFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台已经关闭提供给诺诺相应服务", EnumCode.NO0);
        }
        String requestIp = RequestUtils.getIpAddress(request);
        LOG4jUtils.audit("getNonoUserAmount requestIp ="+requestIp);
        if (StringUtils.isEmpty(requestIp)) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有接收到访问的IP地址", EnumCode.NO0);
        }
        boolean ipFlag = ifBelieveIPs(requestIp);
        if (!ipFlag) {
            return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台接收到非授信的IP地址", EnumCode.NO0);
        }
        //业务逻辑处理
        try {
            RequestParams params = RequestParamUtils.getRequestParams(request);
            String nonoCode = params.nonoCode ;
            String certificateNumber = params.certificateNumber;
            String userType = params.userType ;
            String userCode = params.userCode ;
            String dataCode = null;
            NonoUser tmpUser = null;
            if ( StringUtils.isNotEmpty(nonoCode) && StringUtils.isNotEmpty(certificateNumber)) {
                if (!ValidUtils.isNO(certificateNumber)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的身份证号", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(nonoCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的nonoCode", EnumCode.NO3);
                }else if (!ValidUtils.isNumber(userCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "请输入合法的userCode", EnumCode.NO3);
                }
                tmpUser = new NonoUser(nonoCode,certificateNumber);
                NonoUser nonoUser = nonoUserService.findByProps(tmpUser);
                if (nonoUser==null) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务后台没有找到对应用户的信息", EnumCode.NO0);
                }
                if (nonoUser.getUserCode() != null && nonoUser.getUserCode() >0 ) {
                    dataCode = nonoUser.getUserCode()+"";
                }else {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器接收到用户的验证信息异常", EnumCode.NO0);
                }
                if (!dataCode.equals(userCode)) {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "用户的信息在服务器中不存在", EnumCode.NO0);
                }
                
                UserAssetsBean tmpAssetsBean = new UserAssetsBean(userCode, nonoCode);
                if (StringUtils.isNotEmpty(userType)) {
                    userType = userType.toUpperCase();
                }
                UserAssetsBean userAssetsBean = nonoUserProductService.getNonoUserAssetsByUserCode(tmpAssetsBean);
                Map<String, Object> nnbkMap = new HashMap<String, Object>();
                Map<String, Object> mxdMap = new HashMap<String, Object>();

                if (userAssetsBean != null ) {
                    nnbkMap.put("status", "1");
                    nnbkMap.put("userCode", userCode);
                    nnbkMap.put("nonoCode", nonoCode);
                    if (userAssetsBean.getNNBKAmount()!=null && (new BigDecimal(userAssetsBean.getNNBKAmount())).compareTo(BigDecimal.ZERO) >= 0) {
                        nnbkMap.put("totalAmount", userAssetsBean.getNNBKAmount()+"");
                    }else{
                        nnbkMap.put("totalAmount", "0.00");
                    }
                    mxdMap.put("status", "1");
                    mxdMap.put("userCode", userCode);
                    mxdMap.put("nonoCode", nonoCode);
                    if (userAssetsBean.getMXDAmount()!=null && (new BigDecimal(userAssetsBean.getMXDAmount())).compareTo(BigDecimal.ZERO) >= 0) {
                        mxdMap.put("totalAmount", userAssetsBean.getMXDAmount()+"");
                    }else{
                        mxdMap.put("totalAmount", "0.00");
                    }
                    resultMap.put("NNBK", nnbkMap);
                    resultMap.put("MXD", mxdMap);
                    return ContainerUtils.buildResMap(resultMap, 1, "服务器处理诺诺会员总资产操作成功", EnumCode.NO0);
                }else {
                    return ContainerUtils.buildHeadMap(resultMap, 0, "服务器没有接到诺诺调用所需要的全部参数", EnumCode.NO0);
                }
            }else{
                return ContainerUtils.buildHeadMap(resultMap, 0, "服务器没有接到诺诺调用所需要的全部参数", EnumCode.NO0);
            }
        }
        catch (Exception e) {
            LOG4jUtils.error(errorHead+"诺诺会员总资产接口——>服务器处理诺诺会员总资产操作失败", e);
            return ContainerUtils.buildHeadMap(resultMap, 0,"服务器处理诺诺会员总资产操作失败",EnumCode.NO5);
        }
        */
    }
    
    /**
     * 是否关闭诺诺调用
     * @return
     */
    private boolean checkNonoStatus() {
        try {
             return false;
        }
        catch (Exception e) {
            LOG4jUtils.error("查询活动状态失败"+e);
            return false;
        }
    }
    
    /**
     * 是否是授信用的IP调用
     * @return
     */
    private boolean ifBelieveIPs(String requestIP) {
        try {
            String storeIP = redisUtil.get(keyHead+requestIP);
            if (StringUtils.isNotEmpty(storeIP)) {
                return true;
            }
            String ipSwitch = "0";
            if (StringUtils.isNotEmpty(ipSwitch) && ipSwitch.equals("0")) {
                return true;
            }
            String storeIPs = "";
            LOG4jUtils.audit("ifBelieveIPs storeIPs ="+storeIPs);
            if (StringUtils.isEmpty(storeIPs)) {
                return false;
            }
            String[] ips = storeIPs.split("@");
            List<String> ipList = Arrays.asList(ips);
            if (ipList.contains(requestIP)) {
                redisUtil.set(keyHead+requestIP, requestIP); //放到redis缓存中去.
                return true;
            }else{
                return false;
            }
        }
        catch (Exception e) {
            LOG4jUtils.error("查询活动状态失败"+e);
            return false;
        }
    }

}
