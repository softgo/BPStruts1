package com.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class NonoUserProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer productId;//   债权主键
    private Integer userCode;//   用户编码
    private String nonoCode;//   诺诺用户在自己系统中的唯一标志
    private String orderId;//   订单号
    private Integer transCode;//   交易类型：1:充值 2:提现
    private String productCode;//   产品编码：NN0005,NN00011
    private BigDecimal investAmount;//   投资金额总金额,充值都是正值；提现都是负值
    private BigDecimal remainingPrincipal;//   剩余本金
    private String userType;//   用户类型：NNBK：诺诺绑卡,MXD:名校贷
    private String createDate;//   创建时间
    private String updateDate;//   更新时间
    
    public NonoUserProduct() {
        super();
    }
    
    public NonoUserProduct(Integer productId, BigDecimal remainingPrincipal,String updateDate) {
        super();
        this.productId = productId;
        this.remainingPrincipal = remainingPrincipal;
        this.updateDate = updateDate;
    }
    public NonoUserProduct(Integer userCode, String nonoCode,  Integer transCode,String productCode, String userType) {
        super();
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.transCode = transCode;
        this.productCode = productCode;
        this.userType = userType;
    }
    
    public NonoUserProduct(Integer userCode, String nonoCode, String orderId, Integer transCode,
            String productCode, BigDecimal investAmount, BigDecimal remainingPrincipal, String userType) {
        super();
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.orderId = orderId;
        this.transCode = transCode;
        this.productCode = productCode;
        this.investAmount = investAmount;
        this.remainingPrincipal = remainingPrincipal;
        this.userType = userType;
    }
    
    public NonoUserProduct(Integer productId, Integer userCode, String nonoCode, String orderId, Integer transCode,
            String productCode, BigDecimal investAmount, BigDecimal remainingPrincipal, String userType) {
        super();
        this.productId = productId;
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.orderId = orderId;
        this.transCode = transCode;
        this.productCode = productCode;
        this.investAmount = investAmount;
        this.remainingPrincipal = remainingPrincipal;
        this.userType = userType;
    }
    
    public NonoUserProduct(Integer productId, Integer userCode, String nonoCode, String orderId, Integer transCode,
            String productCode, BigDecimal investAmount, BigDecimal remainingPrincipal, String userType,
            String createDate, String updateDate) {
        super();
        this.productId = productId;
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.orderId = orderId;
        this.transCode = transCode;
        this.productCode = productCode;
        this.investAmount = investAmount;
        this.remainingPrincipal = remainingPrincipal;
        this.userType = userType;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
    public void setProductId(Integer productId) {
        this.productId=productId;
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
    
    public Integer getTransCode() {
        return this.transCode;
    }
    public void setTransCode(Integer transCode) {
        this.transCode=transCode;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode=productCode;
    }
    
    public BigDecimal getInvestAmount() {
        return this.investAmount;
    }
    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount=investAmount;
    }
    
    public BigDecimal getRemainingPrincipal() {
        return this.remainingPrincipal;
    }
    public void setRemainingPrincipal(BigDecimal remainingPrincipal) {
        this.remainingPrincipal=remainingPrincipal;
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
    
    public String getUpdateDate() {
        return this.updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate=updateDate;
    }
    

}
