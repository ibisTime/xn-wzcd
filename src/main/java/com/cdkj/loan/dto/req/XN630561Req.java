package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630561Req {

    @NotBlank
    private String code;// 编号

    @NotBlank
    private String guaName;// 担保人姓名

    @NotBlank
    private String guaMobile;// 担保人手机号

    @NotBlank
    private String guaIdNo;// 担保人身份证号

    @NotBlank
    private String guaNowAddress;// 担保人现居住地址

    @NotBlank
    private String housePdf;// 房产

    @NotBlank
    private String jourPdf;// 流水

    private String guaNote;// 赎回说明

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGuaName() {
        return guaName;
    }

    public void setGuaName(String guaName) {
        this.guaName = guaName;
    }

    public String getGuaMobile() {
        return guaMobile;
    }

    public void setGuaMobile(String guaMobile) {
        this.guaMobile = guaMobile;
    }

    public String getGuaIdNo() {
        return guaIdNo;
    }

    public void setGuaIdNo(String guaIdNo) {
        this.guaIdNo = guaIdNo;
    }

    public String getGuaNowAddress() {
        return guaNowAddress;
    }

    public void setGuaNowAddress(String guaNowAddress) {
        this.guaNowAddress = guaNowAddress;
    }

    public String getHousePdf() {
        return housePdf;
    }

    public void setHousePdf(String housePdf) {
        this.housePdf = housePdf;
    }

    public String getJourPdf() {
        return jourPdf;
    }

    public void setJourPdf(String jourPdf) {
        this.jourPdf = jourPdf;
    }

    public String getGuaNote() {
        return guaNote;
    }

    public void setGuaNote(String guaNote) {
        this.guaNote = guaNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
