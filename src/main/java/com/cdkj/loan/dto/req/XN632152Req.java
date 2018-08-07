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
    private List<String> codeList;

    // 补件原因
    private String supplementReason;

    // 补件原因
    private List<SupplementReason> supplementReasonList;

    // 补件说明
    private String supplementNote;

    // 备注
    private String remark;

    // 操作人
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
