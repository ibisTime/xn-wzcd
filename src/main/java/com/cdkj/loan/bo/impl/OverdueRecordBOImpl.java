package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IOverdueRecordBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IOverdueRecordDAO;
import com.cdkj.loan.domain.OverdueRecord;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class OverdueRecordBOImpl extends PaginableBOImpl<OverdueRecord>
        implements IOverdueRecordBO {

    @Autowired
    private IOverdueRecordDAO overdueRecordDAO;

    public int saveOverdueRecord(OverdueRecord data) {
        return overdueRecordDAO.insert(data);
    }

    @Override
    public List<OverdueRecord> queryOverdueRecordList(OverdueRecord condition) {
        return overdueRecordDAO.selectList(condition);
    }

    @Override
    public OverdueRecord getOverdueRecord(int id) {
        OverdueRecord data = null;
        if (id != 0) {
            OverdueRecord condition = new OverdueRecord();
            condition.setId(id);
            data = overdueRecordDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "逾期记录编号不存在！");
            }
        }
        return data;
    }
}
