package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 办公用户列表
* @author: jiafr 
* @since: 2018-06-06 19:40:54
* @history:
*/
public class AssertUser extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 办公用品编号
    private String assertCode;

    // 用户编号
    private String userId;

    // 印刷数量
    private String printQuantity;

    /*****************db properties**********************/

    private Archive archive;

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setAssertCode(String assertCode) {
        this.assertCode = assertCode;
    }

    public String getAssertCode() {
        return assertCode;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPrintQuantity(String printQuantity) {
        this.printQuantity = printQuantity;
    }

    public String getPrintQuantity() {
        return printQuantity;
    }

}
