package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBizDayStatisticBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IBizDayStatisticDAO;
import com.cdkj.loan.domain.BizDayStatistic;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月6日 下午5:45:02 
 * @history:
 */
@Component
public class BizDayStatisticBOImpl extends PaginableBOImpl<BizDayStatistic>
        implements IBizDayStatisticBO {

    @Autowired
    private IBizDayStatisticDAO bizDayStatisticDAO;

    @Override
    public boolean isBizDayStatisticExist(String id) {
        BizDayStatistic condition = new BizDayStatistic();
        condition.setId(id);
        if (bizDayStatisticDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBizDayStatistic(BizDayStatistic data) {
        String id = null;
        if (data != null) {
            bizDayStatisticDAO.insert(data);
        }
        return id;
    }

    @Override
    public int removeBizDayStatistic(String id) {
        int count = 0;
        if (StringUtils.isNotBlank(id)) {
            BizDayStatistic data = new BizDayStatistic();
            data.setId(id);
            count = bizDayStatisticDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBizDayStatistic(BizDayStatistic data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getId())) {
            count = bizDayStatisticDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BizDayStatistic> queryBizDayStatisticList(
            BizDayStatistic condition) {
        return bizDayStatisticDAO.selectList(condition);
    }

    @Override
    public BizDayStatistic getBizDayStatistic(String id) {
        BizDayStatistic data = null;
        if (StringUtils.isNotBlank(id)) {
            BizDayStatistic condition = new BizDayStatistic();
            condition.setId(id);
            data = bizDayStatisticDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "数据不存在");
            }
        }
        return data;
    }

    @Override
    public BizDayStatistic getBizDayStatisticByDate(Date date,
            String companyCode) {
        BizDayStatistic data = null;
        if (date != null) {
            BizDayStatistic condition = new BizDayStatistic();
            condition.setDate(date);
            condition.setCompanyCode(companyCode);
            data = bizDayStatisticDAO.select(condition);
        }
        return data;
    }
}
