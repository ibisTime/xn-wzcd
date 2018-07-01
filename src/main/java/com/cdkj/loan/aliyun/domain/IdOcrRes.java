/**
 * @Title IdOcr.java 
 * @Package com.cdkj.loan.aliyun.domain 
 * @Description 
 * @author xieyj  
 * @date 2018年7月1日 下午2:26:02 
 * @version V1.0   
 */
package com.cdkj.loan.aliyun.domain;

/** 
 * @author: xieyj 
 * @since: 2018年7月1日 下午2:26:02 
 * @history:
 */
public class IdOcrRes {

    private String residenceAddress;// 户籍地址

    private String birth;// 出生日期

    // private String configStr;// 配置信息，同输入configure
    //
    // private FaceRect faceRect; //
    // #人脸位置，center表示人脸矩形中心坐标，size表示人脸矩形长宽，angle表示矩形顺时针旋转的度数

    private String realName; // 姓名

    private String nationality; // 民族

    private String idNo;// 身份证号

    private String requestId;

    private String gender;// 性别

    private String startDate;// 有效期起始时间

    private String endDate;// 有效期结束时间

    private String issue;// 签发机关

    private String success;// #识别结果，true表示成功，false表示失败

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public IdOcrRes() {
    }

    public IdOcrRes(IdOcr idOcr) {
        this.residenceAddress = idOcr.getAddress();
        this.birth = idOcr.getBirth();
        this.realName = idOcr.getName();
        this.nationality = idOcr.getNationality();
        this.idNo = idOcr.getNum();
        this.gender = idOcr.getSex();
        this.startDate = idOcr.getStart_date();
        this.endDate = idOcr.getEnd_date();
        this.issue = idOcr.getIssue();
        this.success = idOcr.getSuccess();
    };
}
