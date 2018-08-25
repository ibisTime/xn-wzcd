package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICompanyClearanceBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ICompanyClearanceDAO;
import com.cdkj.loan.domain.CompanyClearance;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class CompanyClearanceBOImpl extends PaginableBOImpl<CompanyClearance>
        implements ICompanyClearanceBO {

    @Autowired
    private ICompanyClearanceDAO companyClearanceDAO;

    public void saveCompanyClearance(CompanyClearance data) {
        companyClearanceDAO.insert(data);
    }

    @Override
    public List<CompanyClearance> queryCompanyClearanceList(
            CompanyClearance condition) {
        return companyClearanceDAO.selectList(condition);
    }

    @Override
    public CompanyClearance getCompanyClearance(int id) {
        CompanyClearance data = null;
        if (id != 0) {
            CompanyClearance condition = new CompanyClearance();
            condition.setId(id);
            data = companyClearanceDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "公司结清记录编号不存在！");
            }
        }
        return data;
    }
}
