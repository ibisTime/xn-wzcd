package com.cdkj.loan.dto.req;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 执行结果录入
 * @author: silver 
 * @since: 2018年6月16日 下午3:36:13 
 * @history:
 */
public class XN630562Req {
    // 编号
    @NotBlank
    private String code;

    // 执行案号
    @NotBlank
    private String exeCaseNumber;

    // 执行申请人
    @NotBlank
    private String exeApplyUser;

    // 执行日期
    @NotBlank
    private String exeDatetime;

    // 执行结果
    @NotBlank
    private String exeResult;

    // 拍卖日期
    private String saleDatetime;

    // 执行裁定书
    private String exePdf;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExeCaseNumber() {
        return exeCaseNumber;
    }

    public void setExeCaseNumber(String exeCaseNumber) {
        this.exeCaseNumber = exeCaseNumber;
    }

    public String getExeApplyUser() {
        return exeApplyUser;
    }

    public void setExeApplyUser(String exeApplyUser) {
        this.exeApplyUser = exeApplyUser;
    }

    public String getExeDatetime() {
        return exeDatetime;
    }

    public void setExeDatetime(String exeDatetime) {
        this.exeDatetime = exeDatetime;
    }

    public String getExeResult() {
        return exeResult;
    }

    public void setExeResult(String exeResult) {
        this.exeResult = exeResult;
    }

    public String getSaleDatetime() {
        return saleDatetime;
    }

    public void setSaleDatetime(String saleDatetime) {
        this.saleDatetime = saleDatetime;
    }

    public String getExePdf() {
        return exePdf;
    }

    public void setExePdf(String exePdf) {
        this.exePdf = exePdf;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
