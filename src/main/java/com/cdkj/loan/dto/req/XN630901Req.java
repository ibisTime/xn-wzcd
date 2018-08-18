package com.cdkj.loan.dto.req;

/**
 * 车贷分期业务统计
 * @author: jiafr 
 * @since: 2018年8月3日 下午7:15:13 
 * @history:
 */
public class XN630901Req {

    // 日期 yyyy-MM-dd（不传默认查当天）
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
