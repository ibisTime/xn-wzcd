package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSBizLog;

public interface ISYSBizLogBO extends IPaginableBO<SYSBizLog> {

    public void saveSYSBizLog(SYSBizLog data);

    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition);

    public SYSBizLog getSYSBizLog(Long id);

}
