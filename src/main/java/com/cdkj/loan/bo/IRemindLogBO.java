package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RemindLog;



public interface IRemindLogBO extends IPaginableBO<RemindLog> {


	public boolean isRemindLogExist(String code);


	public String saveRemindLog(RemindLog data);


	public int removeRemindLog(String code);


	public int refreshRemindLog(RemindLog data);


	public List<RemindLog> queryRemindLogList(RemindLog condition);


	public RemindLog getRemindLog(String code);


}