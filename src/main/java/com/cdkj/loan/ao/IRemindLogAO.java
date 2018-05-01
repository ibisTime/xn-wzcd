package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RemindLog;



public interface IRemindLogAO {
	static final String DEFAULT_ORDER_COLUMN = "code";


	public String addRemindLog(RemindLog data);

	public int dropRemindLog(String code);

	public int editRemindLog(RemindLog data);

	public Paginable<RemindLog> queryRemindLogPage(int start, int limit, RemindLog condition);

	public List<RemindLog> queryRemindLogList(RemindLog condition);

	public RemindLog getRemindLog(String code);

}