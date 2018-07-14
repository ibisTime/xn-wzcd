package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.cdkj.loan.domain.SupplementReason;

/**
 * 资料传递收件并补发
 * @author: silver 
 * @since: 2018年5月29日 下午11:02:18 
 * @history:
 */
public class XN632152Req {
    // 编号
    @NotBlank
    private String code;

    // 补件原因
    private String supplementReason;

    // 补件原因
    private List<SupplementReason> supplementReasonList;

    // 补件说明
    private String supplementNote;

    // 备注
    private String remark;

    // 操作人
    private String operater;

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public List<SupplementReason> getSupplementReasonList() {
        return supplementReasonList;
    }

    public void setSupplementReasonList(
            List<SupplementReason> supplementReasonList) {
        this.supplementReasonList = supplementReasonList;
    }

    public String getSupplementReason() {
        return supplementReason;
    }

    public void setSupplementReason(String supplementReason) {
        this.supplementReason = supplementReason;
    }

    public String getSupplementNote() {
        return supplementNote;
    }

    public void setSupplementNote(String supplementNote) {
        this.supplementNote = supplementNote;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
