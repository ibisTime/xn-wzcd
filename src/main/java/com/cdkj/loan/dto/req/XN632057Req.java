package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 列表查询支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午11:26:10 
 * @history:
 */

public class XN632057Req {
    // 银行编号
    @NotBlank
    private String bankCode;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

}
