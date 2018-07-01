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
public class IdOcr {

    // {
    // "address":"江西省抚州市东乡县孝岗镇市场街德政街349号1栋3单元401室",
    // "birth":"19951120",
    // "config_str":"{"side":"face"}",
    // "face_rect":{
    // "angle":0,
    // "center":{
    // "x":1039.5,
    // "y":444.4998779296875
    // },
    // "size":{
    // "height":222.99996948242188,
    // "width":244.99996948242188
    // }
    // },
    // "name":"严志峰",
    // "nationality":"汉",
    // "num":"362531199511200028",
    // "request_id":"20180701133725_3469a036f199e39caea566cb78afd1d6",
    // "sex":"女",
    // "success":true
    // }

    private String address;// 户籍地址

    private String birth;// 出生日期

    private String config_str;// 配置信息，同输入configure

    private FaceRect face_rect;// #人脸位置，center表示人脸矩形中心坐标，size表示人脸矩形长宽，angle表示矩形顺时针旋转的度数

    private String name; // 姓名

    private String nationality; // 民族

    private String num;// 身份证号

    private String request_id;

    private String sex;// 性别

    private String start_date;// 有效期起始时间

    private String end_date;// 有效期结束时间

    private String issue;// 签发机关

    private String success;// #识别结果，true表示成功，false表示失败

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getConfig_str() {
        return config_str;
    }

    public void setConfig_str(String config_str) {
        this.config_str = config_str;
    }

    public FaceRect getFace_rect() {
        return face_rect;
    }

    public void setFace_rect(FaceRect face_rect) {
        this.face_rect = face_rect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
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
}
