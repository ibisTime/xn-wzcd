package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 出差/公出申请明细
* @author: jiafr 
* @since: 2018-06-06 12:56:36
* @history:
*/
public class TravelApplyDetail extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 出差申请编号
	private String travelApplyCode;

	// 开始时间
	private String startDatetime;

	// 结束时间
	private String endDatetime;

	// 时长
	private String totalHour;

	// 备注
	private String remark;

	public void setTravelApplyCode(String travelApplyCode) {
		this.travelApplyCode = travelApplyCode;
	}

	public String getTravelApplyCode() {
		return travelApplyCode;
	}

	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}

	public String getStartDatetime() {
		return startDatetime;
	}

	public void setEndDatetime(String endDatetime) {
		this.endDatetime = endDatetime;
	}

	public String getEndDatetime() {
		return endDatetime;
	}

	public void setTotalHour(String totalHour) {
		this.totalHour = totalHour;
	}

	public String getTotalHour() {
		return totalHour;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}