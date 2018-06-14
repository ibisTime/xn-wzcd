package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 我司贷款成数
* @author: silver
* @since: 2018-06-14 19:23:24
* @history:
*/
public class LoanCs extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型(1 新车 2 二手车)
    private String type;

    // 最低成数
    private Long minCs;

    // 最高成数
    private Long maxCs;

    // 备注
    private String remark;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMinCs(Long minCs) {
        this.minCs = minCs;
    }

    public Long getMinCs() {
        return minCs;
    }

    public void setMaxCs(Long maxCs) {
        this.maxCs = maxCs;
    }

    public Long getMaxCs() {
        return maxCs;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
