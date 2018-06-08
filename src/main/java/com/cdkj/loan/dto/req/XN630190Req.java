package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 上午11:53:07 
 * @history:
 */
public class XN630190Req {

    @NotBlank
    private String name;

    @NotBlank
    private String captain;

    @NotBlank
    private String accountCode;

    @NotBlank
    private String updater;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
