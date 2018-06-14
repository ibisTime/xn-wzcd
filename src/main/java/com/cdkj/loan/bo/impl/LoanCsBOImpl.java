package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ILoanCsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ILoanCsDAO;
import com.cdkj.loan.domain.LoanCs;
import com.cdkj.loan.exception.BizException;

/**
 * 贷款成数
 * @author: silver 
 * @since: 2018年6月14日 下午7:28:51 
 * @history:
 */
@Component
public class LoanCsBOImpl extends PaginableBOImpl<LoanCs> implements ILoanCsBO {

    @Autowired
    private ILoanCsDAO loanCsDAO;

    @Override
    public void refreshLoanCs(LoanCs data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            loanCsDAO.update(data);
        }
    }

    @Override
    public List<LoanCs> queryLoanCsList(LoanCs condition) {
        return loanCsDAO.selectList(condition);
    }

    @Override
    public LoanCs getLoanCs(String code) {
        LoanCs data = null;
        if (StringUtils.isNotBlank(code)) {
            LoanCs condition = new LoanCs();
            condition.setCode(code);
            data = loanCsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }
        }
        return data;
    }
}
