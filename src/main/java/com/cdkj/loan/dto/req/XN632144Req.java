package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 银行驻点推送已放款名单
 * @author: jiafr 
 * @since: 2018年7月20日 下午7:32:15 
 * @history:
 */
public class XN632144Req {

    // 预算单编号
    @NotEmpty
    private List<String> codeList;

    // // 银行还款日
    // @NotBlank
    // private String repayBankDate;
    //
    // // 对账单日
    // @NotBlank
    // private String billDatetime;

    // 操作人
    @NotBlank
    private String operator;

    // 已放款名单图片
    @NotBlank
    private String hasLoanListPic;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    // public String getRepayBankDate() {
    // return repayBankDate;
    // }
    //
    // public void setRepayBankDate(String repayBankDate) {
    // this.repayBankDate = repayBankDate;
    // }
    //
    // public String getBillDatetime() {
    // return billDatetime;
    // }
    //
    // public void setBillDatetime(String billDatetime) {
    // this.billDatetime = billDatetime;
    // }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getHasLoanListPic() {
        return hasLoanListPic;
    }

    public void setHasLoanListPic(String hasLoanListPic) {
        this.hasLoanListPic = hasLoanListPic;
    }

}
