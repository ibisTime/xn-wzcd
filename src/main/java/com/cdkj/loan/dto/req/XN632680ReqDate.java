package com.cdkj.loan.dto.req;

/**
 * 休息日记录
 * @author: silver 
 * @since: 2018年6月8日 下午3:01:49 
 * @history:
 */
public class XN632680ReqDate {
    // 日期
    private String restDate;

    // 是否休息
    private String isRest;

    public String getRestDate() {
        return restDate;
    }

    public void setRestDate(String restDate) {
        this.restDate = restDate;
    }

    public String getIsRest() {
        return isRest;
    }

    public void setIsRest(String isRest) {
        this.isRest = isRest;
    }

}
