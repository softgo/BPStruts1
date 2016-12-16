package com.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class NonoTransDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer transId;//   流水的自增长id
    private Integer userCode;//   用户编码
    private String nonoCode;//   诺诺用户在自己系统中的唯一标志
    private String orderId;//   订单号
    private String productCode;//   产品编码
    private Integer transCode;//   交易编码:1充值 ;2 提现 
    private BigDecimal amount;//   交易发生额
    private String userType;//   用户类型：NNBK：诺诺绑卡,MXD:名校贷
    private Integer status;//   状态标识: 1:成功流水; 2:失败流水; 3:重复流水
    private String createDate;//   创建时间
    private String updateDate;//   更新时间
    
    public NonoTransDetail() {
        super();
    }
    
    public NonoTransDetail(String nonoCode, String orderId, String productCode,String userType) {
        super();
        this.nonoCode = nonoCode;
        this.orderId = orderId;
        this.productCode = productCode;
        this.userType = userType;
    }
    
    public NonoTransDetail(Integer userCode, String nonoCode, String orderId, String productCode, Integer transCode,
            BigDecimal amount, String userType, Integer status) {
        super();
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.orderId = orderId;
        this.productCode = productCode;
        this.transCode = transCode;
        this.amount = amount;
        this.userType = userType;
        this.status = status;
    }
    
    public NonoTransDetail(Integer transId, Integer userCode, String nonoCode, String orderId, String productCode,
            Integer transCode, BigDecimal amount, String userType, Integer status, String createDate,
            String updateDate) {
        super();
        this.transId = transId;
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.orderId = orderId;
        this.productCode = productCode;
        this.transCode = transCode;
        this.amount = amount;
        this.userType = userType;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public Integer getTransId() {
        return this.transId;
    }
    public void setTransId(Integer transId) {
        this.transId=transId;
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
    
    public String getOrderId() {
        return this.orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId=orderId;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode=productCode;
    }
    
    public Integer getTransCode() {
        return this.transCode;
    }
    public void setTransCode(Integer transCode) {
        this.transCode=transCode;
    }
    
    public BigDecimal getAmount() {
        return this.amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount=amount;
    }
    
    public String getUserType() {
        return this.userType;
    }
    public void setUserType(String userType) {
        this.userType=userType;
    }
    
    public Integer getStatus() {
        return this.status;
    }
    public void setStatus(Integer status) {
        this.status=status;
    }
    
    public String getCreateDate() {
        return this.createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate=createDate;
    }
    
    public String getUpdateDate() {
        return this.updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate=updateDate;
    }

}
