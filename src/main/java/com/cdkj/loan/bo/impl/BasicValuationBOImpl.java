package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBasicValuationBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IBasicValuationDAO;
import com.cdkj.loan.domain.BasicValuation;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class BasicValuationBOImpl extends PaginableBOImpl<BasicValuation>
        implements IBasicValuationBO {

    @Autowired
    private IBasicValuationDAO basicValuationDAO;

    public void saveBasicValuation(BasicValuation data) {
        basicValuationDAO.insert(data);
    }

    @Override
    public List<BasicValuation> queryBasicValuationList(
            BasicValuation condition) {
        return basicValuationDAO.selectList(condition);
    }

    @Override
    public BasicValuation getBasicValuation(int id) {
        BasicValuation data = null;
        if (id != 0) {
            BasicValuation condition = new BasicValuation();
            condition.setId(id);
            data = basicValuationDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "估值编号不存在！");
            }
        }
        return data;
    }
}
