package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISysBonusesBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ISysBonusesDAO;
import com.cdkj.loan.domain.SysBonuses;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class SysBonusesBOImpl extends PaginableBOImpl<SysBonuses>
        implements ISysBonusesBO {

    @Autowired
    private ISysBonusesDAO sysBonusesDAO;

    public void saveSysBonuses(SysBonuses data) {
        sysBonusesDAO.insert(data);
    }

    @Override
    public int removeSysBonuses(int id) {
        int count = 0;
        if (id != 0) {
            SysBonuses data = new SysBonuses();
            data.setId(id);
            count = sysBonusesDAO.delete(data);
        }
        return count;
    }

    @Override
    public void refreshSysBonuses(SysBonuses data) {
        sysBonusesDAO.update(data);
    }

    @Override
    public List<SysBonuses> querySysBonusesList(SysBonuses condition) {
        return sysBonusesDAO.selectList(condition);
    }

    @Override
    public SysBonuses getSysBonuses(int id) {
        SysBonuses data = null;
        if (id != 0) {
            SysBonuses condition = new SysBonuses();
            condition.setId(id);
            data = sysBonusesDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "奖金提成配置不存在！");
            }
        }
        return data;
    }
}
