package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 垫资流程分公司制单（批量）
 * @author: jiafr 
 * @since: 2018年6月17日 上午11:08:47 
 * @history:
 */
public class XN632174Req {

    // 业务公司编号
    @NotBlank
    private String companyCode;

    // 制单意见说明
    private String makeBillNote;

    // 操作人
    @NotBlank
    private String operator;

    // 垫资单编号列表
    private List<String> codeList;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getMakeBillNote() {
        return makeBillNote;
    }

    public void setMakeBillNote(String makeBillNote) {
        this.makeBillNote = makeBillNote;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

}
