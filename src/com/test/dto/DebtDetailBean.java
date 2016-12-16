package com.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DebtDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer debtDetailId;//   主键
    private String importBatchId;//   导入批次id
    private String debtType;//   产品编码
    private BigDecimal originalTotalAmount;//   原始总可投金额
    private BigDecimal currentTotalAmount;//   当前可投金额
    private String lockStartTime;//   债权生效开始时间
    private String lockEndTime;//   债权生效结束时间
    private BigDecimal currentOriginalAmount;//   当前债权原始可用额
    private BigDecimal debtRate;//   年利率
    private String debtDetailDesc;//   债权信息描述
    private String createdDate;//   创建时间
    private String updatedDate;//   修改时间
    private String createdBy;//   创建人
    private String updatedBy;//   更新人
    private Integer debterId;//   借款人id
    
    public Integer getDebtDetailId() {
        return this.debtDetailId;
    }
    public void setDebtDetailId(Integer debtDetailId) {
        this.debtDetailId=debtDetailId;
    }
    
    public String getImportBatchId() {
        return this.importBatchId;
    }
    public void setImportBatchId(String importBatchId) {
        this.importBatchId=importBatchId;
    }
    
    public String getDebtType() {
        return this.debtType;
    }
    public void setDebtType(String debtType) {
        this.debtType=debtType;
    }
    
    public BigDecimal getOriginalTotalAmount() {
        return this.originalTotalAmount;
    }
    public void setOriginalTotalAmount(BigDecimal originalTotalAmount) {
        this.originalTotalAmount=originalTotalAmount;
    }
    
    public BigDecimal getCurrentTotalAmount() {
        return this.currentTotalAmount;
    }
    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount=currentTotalAmount;
    }
    
    public String getLockStartTime() {
        return this.lockStartTime;
    }
    public void setLockStartTime(String lockStartTime) {
        this.lockStartTime=lockStartTime;
    }
    
    public String getLockEndTime() {
        return this.lockEndTime;
    }
    public void setLockEndTime(String lockEndTime) {
        this.lockEndTime=lockEndTime;
    }
    
    public BigDecimal getCurrentOriginalAmount() {
        return this.currentOriginalAmount;
    }
    public void setCurrentOriginalAmount(BigDecimal currentOriginalAmount) {
        this.currentOriginalAmount=currentOriginalAmount;
    }
    
    public BigDecimal getDebtRate() {
        return this.debtRate;
    }
    public void setDebtRate(BigDecimal debtRate) {
        this.debtRate=debtRate;
    }
    
    public String getDebtDetailDesc() {
        return this.debtDetailDesc;
    }
    public void setDebtDetailDesc(String debtDetailDesc) {
        this.debtDetailDesc=debtDetailDesc;
    }
    
    public String getCreatedDate() {
        return this.createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate=createdDate;
    }
    
    public String getUpdatedDate() {
        return this.updatedDate;
    }
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate=updatedDate;
    }
    
    public String getCreatedBy() {
        return this.createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy=createdBy;
    }
    
    public String getUpdatedBy() {
        return this.updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy=updatedBy;
    }
    
    public Integer getDebterId() {
        return this.debterId;
    }
    public void setDebterId(Integer debterId) {
        this.debterId=debterId;
    }
    
}
