package com.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class NonoLimitProduct implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer productId;//   期号的设置,自增长
    private String productCode;//   产品编号:NN0005;NN00011
    private Integer issue;//   期号设置
    private BigDecimal initStock;//   初始化库存
    private BigDecimal balance;//   余额
    private BigDecimal financeIn;//   当日入账资金
    private BigDecimal financeOut;//   当日出账资金
    private String startTime;//   开始时间
    private String endTime;//   结束时间（备用）
    private String createDate;//   创建时间
    private String updateDate;//   更新时间
    private Integer status;//   产品状态:1可用；0:不可用
    
    public NonoLimitProduct() {
        super();
    }
    
    public NonoLimitProduct(Integer productId,String productCode,BigDecimal balance,BigDecimal financeIn,String updateDate) {
        super();
        this.productId = productId;
        this.productCode = productCode;
        this.balance = balance;
        this.financeIn = financeIn;
        this.updateDate = updateDate;
    }
    
    public NonoLimitProduct(String productCode, Integer issue, BigDecimal initStock, BigDecimal balance,
            BigDecimal financeIn, BigDecimal financeOut,String createDate) {
        super();
        this.productCode = productCode;
        this.issue = issue;
        this.initStock = initStock;
        this.balance = balance;
        this.financeIn = financeIn;
        this.financeOut = financeOut;
        this.createDate = createDate;
    }
    
    public NonoLimitProduct(String productCode, Integer issue, BigDecimal initStock, BigDecimal balance,
            BigDecimal financeIn, BigDecimal financeOut, String startTime, String endTime, String createDate) {
        super();
        this.productCode = productCode;
        this.issue = issue;
        this.initStock = initStock;
        this.balance = balance;
        this.financeIn = financeIn;
        this.financeOut = financeOut;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createDate = createDate;
    }
    
    public NonoLimitProduct(Integer productId, String productCode, Integer issue, BigDecimal initStock,
            BigDecimal balance, BigDecimal financeIn, BigDecimal financeOut, String startTime, String endTime,
            String createDate, String updateDate, Integer status) {
        super();
        this.productId = productId;
        this.productCode = productCode;
        this.issue = issue;
        this.initStock = initStock;
        this.balance = balance;
        this.financeIn = financeIn;
        this.financeOut = financeOut;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
    public void setProductId(Integer productId) {
        this.productId=productId;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode=productCode;
    }
    
    public Integer getIssue() {
        return this.issue;
    }
    public void setIssue(Integer issue) {
        this.issue=issue;
    }
    
    public BigDecimal getInitStock() {
        return this.initStock;
    }
    public void setInitStock(BigDecimal initStock) {
        this.initStock=initStock;
    }
    
    public BigDecimal getBalance() {
        return this.balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance=balance;
    }
    public BigDecimal getFinanceIn() {
        return financeIn;
    }
    public void setFinanceIn(BigDecimal financeIn) {
        this.financeIn = financeIn;
    }
    public BigDecimal getFinanceOut() {
        return financeOut;
    }
    public void setFinanceOut(BigDecimal financeOut) {
        this.financeOut = financeOut;
    }
    public String getStartTime() {
        return this.startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime=startTime;
    }
    
    public String getEndTime() {
        return this.endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime=endTime;
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
    
    public Integer getStatus() {
        return this.status;
    }
    public void setStatus(Integer status) {
        this.status=status;
    }
    

}
