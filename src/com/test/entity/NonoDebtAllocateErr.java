package com.test.entity;

import java.io.Serializable;

public class NonoDebtAllocateErr implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer debtErrId;//   主键
    private String param;//   参数:NN0005:3000
    private String message;//   错误信息
    private String orderId;//   订单号
    private Integer userCode;//   用户编码
    private String nonoCode;//   诺诺用户在自己系统中的唯一标志
    private Integer type;//   1:预分配 2:确认 3：失败处理
    private String userType;//   用户类型：NNBK：诺诺绑卡,MXD:名校贷
    private String createDate;//   创建时间
    
    public NonoDebtAllocateErr() {
        super();
    }
    public NonoDebtAllocateErr(String param, String message, String orderId, Integer userCode, String nonoCode,
            Integer type, String userType) {
        super();
        this.param = param;
        this.message = message;
        this.orderId = orderId;
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.type = type;
        this.userType = userType;
    }
    public NonoDebtAllocateErr(Integer debtErrId, String param, String message, String orderId, Integer userCode,
            String nonoCode, Integer type, String userType, String createDate) {
        super();
        this.debtErrId = debtErrId;
        this.param = param;
        this.message = message;
        this.orderId = orderId;
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.type = type;
        this.userType = userType;
        this.createDate = createDate;
    }
    public Integer getDebtErrId() {
        return this.debtErrId;
    }
    public void setDebtErrId(Integer debtErrId) {
        this.debtErrId=debtErrId;
    }
    
    public String getParam() {
        return this.param;
    }
    public void setParam(String param) {
        this.param=param;
    }
    
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message=message;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId=orderId;
    }
    
    public Integer getUserCode() {
        return this.userCode;
    }
    public void setUserCode(Integer userCode) {
        this.userCode=userCode;
    }
    
    public String getNonoCode() {
        return this.nonoCode;
    }
    public void setNonoCode(String nonoCode) {
        this.nonoCode=nonoCode;
    }
    
    public Integer getType() {
        return this.type;
    }
    public void setType(Integer type) {
        this.type=type;
    }
    
    public String getUserType() {
        return this.userType;
    }
    public void setUserType(String userType) {
        this.userType=userType;
    }
    
    public String getCreateDate() {
        return this.createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate=createDate;
    }
    

}
