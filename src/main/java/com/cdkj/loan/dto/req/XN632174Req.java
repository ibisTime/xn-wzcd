package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 分公司制单（批量）
 * @author: jiafr 
 * @since: 2018年6月17日 上午11:08:47 
 * @history:
 */
public class XN632174Req {

    // 业务公司编号
    private String companyCode;

    // 垫资总金额
    private String totalAdvanceFund;

    // 付款金额
    private String payAmount;

    // 制单意见说明
    private String makeBillNote;

    // 更新人
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

    public String getTotalAdvanceFund() {
        return totalAdvanceFund;
    }

    public void setTotalAdvanceFund(String totalAdvanceFund) {
        this.totalAdvanceFund = totalAdvanceFund;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
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
