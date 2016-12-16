package com.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class NonoUserProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer detailId;//   产品详情主键
    private Integer userProductId;//   用户产品主键
    private Integer debtDetailId;//   投资产品明细id
    private BigDecimal investAmount;//   投资金额
    private Integer changeResource;//   1:用户操作 2：系统操作
    private String userType;//   用户类型：NNBK：诺诺绑卡,MXD:名校贷
    private String createDate;//   创建时间
    private String updateDate;//   更新时间

    public NonoUserProductDetail() {
        super();
    }
    public NonoUserProductDetail(Integer userProductId,String userType) {
        super();
        this.userProductId = userProductId;
        this.userType = userType;
    }
    public NonoUserProductDetail(Integer userProductId, Integer debtDetailId, BigDecimal investAmount,
            Integer changeResource, String userType) {
        super();
        this.userProductId = userProductId;
        this.debtDetailId = debtDetailId;
        this.investAmount = investAmount;
        this.changeResource = changeResource;
        this.userType = userType;
    }

    public NonoUserProductDetail(Integer detailId, Integer userProductId, Integer debtDetailId, BigDecimal investAmount,
            Integer changeResource, String userType) {
        super();
        this.detailId = detailId;
        this.userProductId = userProductId;
        this.debtDetailId = debtDetailId;
        this.investAmount = investAmount;
        this.changeResource = changeResource;
        this.userType = userType;
    }

    public NonoUserProductDetail(Integer detailId, Integer userProductId, Integer debtDetailId, BigDecimal investAmount,
            Integer changeResource, String userType, String createDate, String updateDate) {
        super();
        this.detailId = detailId;
        this.userProductId = userProductId;
        this.debtDetailId = debtDetailId;
        this.investAmount = investAmount;
        this.changeResource = changeResource;
        this.userType = userType;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getDetailId() {
        return this.detailId;
    }
    public void setDetailId(Integer detailId) {
        this.detailId=detailId;
    }
    
    public Integer getUserProductId() {
        return this.userProductId;
    }
    public void setUserProductId(Integer userProductId) {
        this.userProductId=userProductId;
    }
    
    public Integer getDebtDetailId() {
        return this.debtDetailId;
    }
    public void setDebtDetailId(Integer debtDetailId) {
        this.debtDetailId=debtDetailId;
    }
    
    public BigDecimal getInvestAmount() {
        return this.investAmount;
    }
    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount=investAmount;
    }
    
    public Integer getChangeResource() {
        return this.changeResource;
    }
    public void setChangeResource(Integer changeResource) {
        this.changeResource=changeResource;
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
