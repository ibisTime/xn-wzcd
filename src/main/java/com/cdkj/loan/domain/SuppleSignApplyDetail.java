package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 补签细节
 * @author: silver 
 * @since: 2018年6月6日 下午1:56:06 
 * @history:
 */
public class SuppleSignApplyDetail extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private String id;

    // 补签申请编号
    private String supplySignApplyCode;

    // 漏签日期
    private Date suppleDatetime;

    // 备注
    private String remark;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setSupplySignApplyCode(String supplySignApplyCode) {
        this.supplySignApplyCode = supplySignApplyCode;
    }

    public String getSupplySignApplyCode() {
        return supplySignApplyCode;
    }

    public Date getSuppleDatetime() {
        return suppleDatetime;
    }

    public void setSuppleDatetime(Date suppleDatetime) {
        this.suppleDatetime = suppleDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
