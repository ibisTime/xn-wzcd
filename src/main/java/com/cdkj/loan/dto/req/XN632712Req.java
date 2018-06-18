package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * GPS公司审核
 * @author: silver 
 * @since: 2018年5月31日 上午12:33:49 
 * @history:
 */
public class XN632712Req {
    // 编号
    @NotBlank
    private String code;

    // 审核结果
    @NotBlank
    private String approveResult;

    // 审核人
    @NotBlank
    private String approveUser;

    // 审核说明
    private String approveNote;

    // GPS列表
    @NotEmpty
    private List<XN632712ReqGps> gpsList;

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
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

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public List<XN632712ReqGps> getGpsList() {
        return gpsList;
    }

    public void setGpsList(List<XN632712ReqGps> gpsList) {
        this.gpsList = gpsList;
    }
}
