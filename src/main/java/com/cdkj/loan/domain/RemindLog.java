package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 催收记录
* @author: haiqingzheng
* @since: 2018年05月01日 19:07:50
* @history:
*/
public class RemindLog extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 还款计划编号
	private String repayPlanCode;

	// 催收方式
	private String way;

	// 催收对象姓名
	private String toUser;

	// 催收文本
	private String content;

	// 催收时间
	private String createDatetime;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setRepayPlanCode(String repayPlanCode) {
		this.repayPlanCode = repayPlanCode;
	}

	public String getRepayPlanCode() {
		return repayPlanCode;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getWay() {
		return way;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

}