package com.test.entity;

import java.io.Serializable;

public class NonoUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userCode;//   用户编码
    private String userName;//   用户真实姓名
    private String mobileNumber;//   用户手机号
    private String nonoCode;//   诺诺用户在自己系统中的唯一标志
    private String certificateNumber;//   身份证号码
    private String userType;//   用户类型：NNBK：诺诺绑卡,MXD:名校贷,但是很多情况下是都存在的
    private Integer isDelete;//   是否使用状态,1:弃用,0:使用
    private String createDate;//   创建时间
    private String updateDate;//   更新时间
    
    public NonoUser() {
        super();
    }
    public NonoUser(String nonoCode, String certificateNumber) {
        super();
        this.nonoCode = nonoCode;
        this.certificateNumber = certificateNumber;
    }
    public NonoUser(Integer userCode, String nonoCode, String certificateNumber) {
        super();
        this.userCode = userCode;
        this.nonoCode = nonoCode;
        this.certificateNumber = certificateNumber;
    }
    public NonoUser(String userName, String mobileNumber, String nonoCode, String certificateNumber) {
        super();
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.nonoCode = nonoCode;
        this.certificateNumber = certificateNumber;
    }
    public NonoUser(Integer userCode, String userName, String mobileNumber, String nonoCode, String certificateNumber,
            String userType, Integer isDelete, String createDate, String updateDate) {
        super();
        this.userCode = userCode;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.nonoCode = nonoCode;
        this.certificateNumber = certificateNumber;
        this.userType = userType;
        this.isDelete = isDelete;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public Integer getUserCode() {
        return userCode;
    }
    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getNonoCode() {
        return nonoCode;
    }
    public void setNonoCode(String nonoCode) {
        this.nonoCode = nonoCode;
    }
    public String getCertificateNumber() {
        return certificateNumber;
    }
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public Integer getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

}
