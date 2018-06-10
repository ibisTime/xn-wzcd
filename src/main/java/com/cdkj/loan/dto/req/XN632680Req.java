package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 休息日记录
 * @author: silver 
 * @since: 2018年6月8日 下午2:58:41 
 * @history:
 */
public class XN632680Req {
    // 更新人
    @NotBlank
    private String updater;

    // 日期年月
    @NotBlank
    private String operateDate;

    // 日期列表
    @NotEmpty
    private List<XN632680ReqDate> dateList;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public List<XN632680ReqDate> getDateList() {
        return dateList;
    }

    public void setDateList(List<XN632680ReqDate> dateList) {
        this.dateList = dateList;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

}
