package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 补件原因
* @author: CYunlai 
* @since: 2018-07-14 16:29:48
* @history:
*/
public class SupplementReason extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // id
    private Long id;

    // 物流单编号
    private String logisticsCode;

    // 类型
    private String type;

    // 原因
    private String reason;

    // 是否已补件（0未补件1已补件）
    private String isPartSupt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsPartSupt() {
        return isPartSupt;
    }

    public void setIsPartSupt(String isPartSupt) {
        this.isPartSupt = isPartSupt;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

}
