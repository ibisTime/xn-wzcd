package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSBizLog;

@Component
public interface ISYSBizLogAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void addSYSBizLog(SYSBizLog data);

    public Paginable<SYSBizLog> querySYSBizLogPage(int start, int limit,
            SYSBizLog condition);

    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition);

    public SYSBizLog getSYSBizLog(Long id);

}
