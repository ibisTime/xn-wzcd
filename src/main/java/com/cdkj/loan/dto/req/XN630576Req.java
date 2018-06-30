package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 解除抵押-合同制作
 * @author: xieyj 
 * @since: 2018年6月30日 下午5:47:45 
 * @history:
 */
public class XN630576Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 解除抵押时间
    @NotBlank
    private String releaseDatetime;

    // 解除抵押模板
    @NotBlank
    private String releaseTemplateId;

    // 解除抵押回录说明
    private String releaseNote;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReleaseDatetime() {
        return releaseDatetime;
    }

    public void setReleaseDatetime(String releaseDatetime) {
        this.releaseDatetime = releaseDatetime;
    }

    public String getReleaseTemplateId() {
        return releaseTemplateId;
    }

    public void setReleaseTemplateId(String releaseTemplateId) {
        this.releaseTemplateId = releaseTemplateId;
    }

    public String getReleaseNote() {
        return releaseNote;
    }

    public void setReleaseNote(String releaseNote) {
        this.releaseNote = releaseNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
