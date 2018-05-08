package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630514Req {

    @NotBlank
    private String code;// 还款业务编号

    @NotBlank
    private String blackHandleNote;// 黑名单处理结果

    @NotBlank
    private String updater;// 操作人

    private String remark;// 备注

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBlackHandleNote() {
        return blackHandleNote;
    }

    public void setBlackHandleNote(String blackHandleNote) {
        this.blackHandleNote = blackHandleNote;
    }

}
