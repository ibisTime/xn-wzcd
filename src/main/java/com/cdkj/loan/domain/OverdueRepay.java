package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 逾期还款表
* @author: jiafr 
* @since: 2018-06-11 19:26:42
* @history:
*/
public class OverdueRepay extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private String id;

    // 逾期名单编号
    private String overdueCode;

    // 还款业务编号
    private String repayBizCode;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOverdueCode(String overdueCode) {
        this.overdueCode = overdueCode;
    }

    public String getOverdueCode() {
        return overdueCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

}
