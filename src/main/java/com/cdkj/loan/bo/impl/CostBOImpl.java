package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICostBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICostDAO;
import com.cdkj.loan.domain.Cost;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.exception.BizException;

@Component
public class CostBOImpl extends PaginableBOImpl<Cost> implements ICostBO {

    @Autowired
    private ICostDAO costDAO;

    @Override
    public boolean isCostExist(String code) {
        Cost condition = new Cost();
        condition.setCode(code);
        if (costDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCost(Cost data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate("COST");
            data.setCode(code);
            costDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCost(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Cost data = new Cost();
            data.setCode(code);
            count = costDAO.delete(data);
        }
        return count;
    }

    @Override
    public void refreshRepay(Cost data, String repayWay) {
        data.setStatus(EBoolean.YES.getCode());
        data.setRepayWay(repayWay);
        data.setRepayDatetime(new Date());
        costDAO.updateRepay(data);
    }

    @Override
    public List<Cost> queryCostList(Cost condition) {
        return costDAO.selectList(condition);
    }

    @Override
    public Cost getCost(String code) {
        Cost data = null;
        if (StringUtils.isNotBlank(code)) {
            Cost condition = new Cost();
            condition.setCode(code);
            data = costDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }
}
