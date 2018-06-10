package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630513Req {

    @NotBlank
    private String code;// 还款业务编号

    @NotBlank
    private String cutLyDeposit;// 应扣除的履约保证金

    @NotBlank
    private String settleAttach;// 结清证明

    private String settleDatetime;// 结清时间

    @NotBlank
    private String updater;// 操作人

    private String remark;// 备注

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCutLyDeposit() {
        return cutLyDeposit;
    }

    public void setCutLyDeposit(String cutLyDeposit) {
        this.cutLyDeposit = cutLyDeposit;
    }

    public String getSettleAttach() {
        return settleAttach;
    }

    public void setSettleAttach(String settleAttach) {
        this.settleAttach = settleAttach;
    }

    public String getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(String settleDatetime) {
        this.settleDatetime = settleDatetime;
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

}
