package com.test.dto;

import java.io.Serializable;

/**
 * 债权人信息
 * 
 * @author admin
 */
public class UserAssetsBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String userCode; //用户的code
    private String nonoCode; //用户的nonoId
    private String userType; //用户的类型.
    private String NNBKAmount; //诺诺镑客资产
    private String MXDAmount; //名校贷资产
    
    public UserAssetsBean() {
        super();
    }
    
    public UserAssetsBean(String userCode, String nonoCode) {
        super();
        this.userCode = userCode;
        this.nonoCode = nonoCode;
    }
    
    public UserAssetsBean(String userCode, String nonoCode, String userType) {
        super();
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.userType = userType;
    }

    public UserAssetsBean(String userCode, String nonoCode, String NNBKAmount, String MXDAmount) {
        super();
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.NNBKAmount = NNBKAmount;
        this.MXDAmount = MXDAmount;
    }
    
    public String getUserCode() {
        return userCode;
    }
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public String getNonoCode() {
        return nonoCode;
    }
    public void setNonoCode(String nonoCode) {
        this.nonoCode = nonoCode;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getNNBKAmount() {
        return NNBKAmount;
    }
    public void setNNBKAmount(String nNBKAmount) {
        NNBKAmount = nNBKAmount;
    }
    public String getMXDAmount() {
        return MXDAmount;
    }
    public void setMXDAmount(String mXDAmount) {
        MXDAmount = mXDAmount;
    }
    
}
