package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IOverdueRepayBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IOverdueRepayDAO;
import com.cdkj.loan.domain.OverdueRepay;
import com.cdkj.loan.exception.BizException;

@Component
public class OverdueRepayBOImpl extends PaginableBOImpl<OverdueRepay> implements
        IOverdueRepayBO {

    @Autowired
    private IOverdueRepayDAO overdueRepayDAO;

    @Override
    public void saveOverdueRepay(String overdueCode, String repayBizCode) {
        OverdueRepay data = new OverdueRepay();
        data.setOverdueCode(overdueCode);
        data.setRepayBizCode(repayBizCode);
        overdueRepayDAO.insert(data);
    }

    @Override
    public List<OverdueRepay> queryOverdueRepayList(OverdueRepay condition) {
        return overdueRepayDAO.selectList(condition);
    }

    @Override
    public OverdueRepay getOverdueRepay(String id) {
        OverdueRepay data = null;
        if (StringUtils.isNotBlank(id)) {
            OverdueRepay condition = new OverdueRepay();
            condition.setId(id);
            data = overdueRepayDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "逾期还款业务关联不存在");
            }
        }
        return data;
    }
}
