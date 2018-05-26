package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 632111 录入银行征信结果
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:25:12 
 * @history:
 */
public class XN632111Req {

    // 操作人
    private String oprerator;

    // 征信单编号
    private String creditCode;

    // 银行征信结果集合
    private List<XN632111ReqChild> bankCreditResultList;

    public List<XN632111ReqChild> getBankCreditResultList() {
        return bankCreditResultList;
    }

    public void setBankCreditResultList(
            List<XN632111ReqChild> bankCreditResultList) {
        this.bankCreditResultList = bankCreditResultList;
    }

    public String getOprerator() {
        return oprerator;
    }

    public void setOprerator(String oprerator) {
        this.oprerator = oprerator;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

}
