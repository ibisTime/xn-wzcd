package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.cdkj.loan.domain.CreditUser;

/**
 * 征信初审
 * @author: jiafr 
 * @since: 2018年5月26日 下午9:14:21 
 * @history:
 */
public class XN632113Req {

    // 征信单编号
    @NotBlank
    private String code;

    // 征信人员
    private List<CreditUser> creditUserList;

    // 审核结果
    @NotBlank
    private String approveResult;

    // 操作人
    @NotBlank
    private String operator;

    // 附件
    private String accessory;

    // 审核说明
    @NotBlank
    private String approveNote;

    public List<CreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<CreditUser> creditUserList) {
        this.creditUserList = creditUserList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

}
