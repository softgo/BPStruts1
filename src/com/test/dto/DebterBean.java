package com.test.dto;

import java.io.Serializable;

/**
 * 债权人信息
 * 
 * @author admin
 */
public class DebterBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String debterName; //债权人名字
    private String debterAmount; //债权人金额
    private String debterDesc; //债权人介绍
    private String debtDate; //匹配时间
    private String debtType; //债权类型
    private String debterId; //债权人信息Id
    
    public DebterBean() {
        super();
    }
    
    public DebterBean(String debterName, String debterAmount, String debterDesc, String debtDate) {
        super();
        this.debterName = debterName;
        this.debterAmount = debterAmount;
        this.debterDesc = debterDesc;
        this.debtDate = debtDate;
    }
    
    public DebterBean(String debterName, String debterAmount, String debterDesc, String debtDate, String debtType,
            String debterId) {
        super();
        this.debterName = debterName;
        this.debterAmount = debterAmount;
        this.debterDesc = debterDesc;
        this.debtDate = debtDate;
        this.debtType = debtType;
        this.debterId = debterId;
    }

    public String getDebterName() {
        return debterName;
    }

    public void setDebterName(String debterName) {
        this.debterName = debterName;
    }

    public String getDebterAmount() {
        return debterAmount;
    }

    public void setDebterAmount(String debterAmount) {
        this.debterAmount = debterAmount;
    }

    public String getDebterDesc() {
        return debterDesc;
    }

    public void setDebterDesc(String debterDesc) {
        this.debterDesc = debterDesc;
    }

    public String getDebtDate() {
        return debtDate;
    }

    public void setDebtDate(String debtDate) {
        this.debtDate = debtDate;
    }

    public String getDebtType() {
        return debtType;
    }

    public void setDebtType(String debtType) {
        this.debtType = debtType;
    }

    public String getDebterId() {
        return debterId;
    }

    public void setDebterId(String debterId) {
        this.debterId = debterId;
    }

}
