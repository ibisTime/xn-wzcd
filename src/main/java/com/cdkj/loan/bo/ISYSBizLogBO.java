package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSBizLog;

public interface ISYSBizLogBO extends IPaginableBO<SYSBizLog> {

    public int saveSYSBizLog(SYSBizLog data);

    public int refreshSYSBizLog(SYSBizLog data);

    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition);

    public SYSBizLog getSYSBizLog(int id);

    public SYSBizLog getSYSBizLogByTime(SYSBizLog data);

    public long getSYSBizLoglatest(SYSBizLog condition);

}
