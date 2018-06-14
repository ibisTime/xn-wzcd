package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 632111 录入银行征信结果
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:25:12 
 * @history:
 */
public class XN632111Req {

    // 操作人
    @NotBlank
    private String operator;

    // 征信单编号
    @NotBlank
    private String creditCode;

    // 银行征信结果集合
    @NotEmpty
    private List<XN632111ReqChild> bankCreditResultList;

    public List<XN632111ReqChild> getBankCreditResultList() {
        return bankCreditResultList;
    }

    public void setBankCreditResultList(
            List<XN632111ReqChild> bankCreditResultList) {
        this.bankCreditResultList = bankCreditResultList;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

}
