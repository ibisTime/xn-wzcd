package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

public class CUser extends ABaseDO {

    // 编号
    private Long userId;

    // 登录名
    private String loginName;

    // 手机号
    private String mobile;

    // 头像
    private String photo;

    // 昵称
    private String nickname;

    // 登录密码
    private String loginPwd;

    // 登录密码强度
    private String loginPwdStrengt;

    // 推荐人编号
    private String userReferee;

    // 推荐人手机号
    private String refereeMobile;

    // 支付密码
    private String tradePwd;

    // 支付密码强度
    private String tradePwdStrength;

    // 证件类型
    private String idKind;

    // 证件号
    private String idNo;

    // 真实姓名
    private String realName;

    // 积分余额
    private String jfAmount;

    // 账户余额
    private String amount;

    // 信用分
    private String creditscore;

    // 状态
    private String status;

    // 注册时间
    private String createDatetime;

    // 备注
    private String remark;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginPwdStrengt() {
        return loginPwdStrengt;
    }

    public void setLoginPwdStrengt(String loginPwdStrengt) {
        this.loginPwdStrengt = loginPwdStrengt;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }

    public String getRefereeMobile() {
        return refereeMobile;
    }

    public void setRefereeMobile(String refereeMobile) {
        this.refereeMobile = refereeMobile;
    }

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }

    public String getTradePwdStrength() {
        return tradePwdStrength;
    }

    public void setTradePwdStrength(String tradePwdStrength) {
        this.tradePwdStrength = tradePwdStrength;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getJfAmount() {
        return jfAmount;
    }

    public void setJfAmount(String jfAmount) {
        this.jfAmount = jfAmount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreditscore() {
        return creditscore;
    }

    public void setCreditscore(String creditscore) {
        this.creditscore = creditscore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
