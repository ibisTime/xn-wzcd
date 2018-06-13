package com.cdkj.loan.dto.req;

/**
 * 休息日记录
 * @author: silver 
 * @since: 2018年6月8日 下午3:01:49 
 * @history:
 */
public class XN632680ReqDate {
    // 日期
    private String date;

    // 是否休息
    private String isRest;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsRest() {
        return isRest;
    }

    public void setIsRest(String isRest) {
        this.isRest = isRest;
    }

}
