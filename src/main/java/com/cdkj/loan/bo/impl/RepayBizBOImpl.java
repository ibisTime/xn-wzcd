package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepayBizDAO;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.exception.BizException;

@Component
public class RepayBizBOImpl extends PaginableBOImpl<RepayBiz>
        implements IRepayBizBO {

    @Autowired
    private IRepayBizDAO repayBizDAO;

    @Override
    public boolean isRepayBizExist(String code) {
        RepayBiz condition = new RepayBiz();
        condition.setCode(code);
        if (repayBizDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRepayBiz(RepayBiz data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate("RB");
            data.setCode(code);
            repayBizDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRepayBiz(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            RepayBiz data = new RepayBiz();
            data.setCode(code);
            count = repayBizDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRepayBiz(RepayBiz data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = repayBizDAO.update(data);
        }
        return count;
    }

    @Override
    public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
        return repayBizDAO.selectList(condition);
    }

    @Override
    public RepayBiz getRepayBiz(String code) {
        RepayBiz data = null;
        if (StringUtils.isNotBlank(code)) {
            RepayBiz condition = new RepayBiz();
            condition.setCode(code);
            data = repayBizDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }
}
