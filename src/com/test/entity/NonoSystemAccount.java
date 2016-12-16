package com.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class NonoSystemAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer accountId;//   系统账户ID
    private Integer userCode;//   用户编码
    private String nonoCode;//   诺诺用户在自己系统中的唯一标志
    private String userType;//   平台ID:NNBK:诺诺镑客;MXD：名校贷
    private String productCode;//   产品编码：NN0005;NN00011
    private String orderId; //诺诺那边传递过来的订单号
    private BigDecimal financeIn;//   入账资金
    private BigDecimal financeOut;//   出账资金
    private BigDecimal balance;//   账户资金
    private Integer status;//   启用标识：1:启用;0:未启用
    private String createDate;//   创建时间

    public NonoSystemAccount() {
        super();
    }

    public NonoSystemAccount(Integer userCode,String nonoCode, String userType, String productCode,String orderId, BigDecimal financeIn,
            BigDecimal financeOut, BigDecimal balance, Integer status) {
        super();
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.userType = userType;
        this.productCode = productCode;
        this.orderId = orderId;
        this.financeIn = financeIn;
        this.financeOut = financeOut;
        this.balance = balance;
        this.status = status;
    }

    public NonoSystemAccount(Integer accountId, Integer userCode,String nonoCode, String userType, String productCode,String orderId,
            BigDecimal financeIn, BigDecimal financeOut, BigDecimal balance, Integer status, String createDate) {
        super();
        this.accountId = accountId;
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.userType = userType;
        this.productCode = productCode;
        this.orderId = orderId;
        this.financeIn = financeIn;
        this.financeOut = financeOut;
        this.balance = balance;
        this.status = status;
        this.createDate = createDate;
    }
    
    public Integer getAccountId() {
        return this.accountId;
    }
    public void setAccountId(Integer accountId) {
        this.accountId=accountId;
    }
    
    public Integer getUserCode() {
        return this.userCode;
    }
    public void setUserCode(Integer userCode) {
        this.userCode=userCode;
    }
    
    public String getNonoCode() {
        return nonoCode;
    }
    public void setNonoCode(String nonoCode) {
        this.nonoCode = nonoCode;
    }
    public String getUserType() {
        return this.userType;
    }
    public void setUserType(String userType) {
        this.userType=userType;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode=productCode;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public BigDecimal getFinanceIn() {
        return this.financeIn;
    }
    public void setFinanceIn(BigDecimal financeIn) {
        this.financeIn=financeIn;
    }
    
    public BigDecimal getFinanceOut() {
        return this.financeOut;
    }
    public void setFinanceOut(BigDecimal financeOut) {
        this.financeOut=financeOut;
    }
    
    public BigDecimal getBalance() {
        return this.balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance=balance;
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
    
}
