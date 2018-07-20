package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSBizLog;

@Service
public class SYSBizLogAOImpl implements ISYSBizLogAO {

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Override
    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition) {
        ArrayList<SYSBizLog> returnList = new ArrayList<SYSBizLog>();
        // 征信和预算单日志（编号是同一个）
        List<SYSBizLog> bizLogList = sysBizLogBO.querySYSBizLogList(condition);
        for (SYSBizLog sysBizLog : bizLogList) {
            returnList.add(sysBizLog);
        }
        // 还款业务日志
        RepayBiz repayBiz = repayBizBO.getRepayBizByRefCode(condition
            .getRefOrder());
        if (null != repayBiz) {
            SYSBizLog queryCondition = new SYSBizLog();
            queryCondition.setRefOrder(repayBiz.getCode());
            List<SYSBizLog> repayLogList = sysBizLogBO
                .querySYSBizLogList(queryCondition);
            for (SYSBizLog sysBizLog : repayLogList) {
                returnList.add(sysBizLog);
            }
        }
        return returnList;
    }

    @Override
    public SYSBizLog getSYSBizLog(int id) {
        return sysBizLogBO.getSYSBizLog(id);
    }

    @Override
    public Paginable<SYSBizLog> querySYSBizLogPage(int start, int limit,
            SYSBizLog condition) {
        return sysBizLogBO.getPaginable(start, limit, condition);
    }
}
