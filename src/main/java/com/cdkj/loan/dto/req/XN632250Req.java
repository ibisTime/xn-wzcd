package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 银行合同导入
 * @author: CYL 
 * @since: 2018年7月24日 下午7:50:35 
 * @history:
 */
public class XN632250Req {

    @NotBlank
    private String loanBankCode;// 贷款银行编号

    @NotEmpty
    private List<XN632250ReqContract> contractList;// 合同

    // 操作人
    private String operator;

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public List<XN632250ReqContract> getContractList() {
        return contractList;
    }

    public void setContractList(List<XN632250ReqContract> contractList) {
        this.contractList = contractList;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
