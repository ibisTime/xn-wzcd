package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ITotalAdvanceFundBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ITotalAdvanceFundDAO;
import com.cdkj.loan.domain.TotalAdvanceFund;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月17日 下午2:39:38 
 * @history:
 */
@Component
public class TotalAdvanceFundBOImpl extends PaginableBOImpl<TotalAdvanceFund>
        implements ITotalAdvanceFundBO {

    @Autowired
    private ITotalAdvanceFundDAO totalAdvanceFundDAO;

    @Override
    public boolean isTotalAdvanceFundExist(String code) {
        TotalAdvanceFund condition = new TotalAdvanceFund();
        condition.setCode(code);
        if (totalAdvanceFundDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveTotalAdvanceFund(TotalAdvanceFund data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.TOTAL_ADVANCE_FUND
                .getCode());
            data.setCode(code);
            totalAdvanceFundDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeTotalAdvanceFund(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            TotalAdvanceFund data = new TotalAdvanceFund();
            data.setCode(code);
            count = totalAdvanceFundDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshTotalAdvanceFund(TotalAdvanceFund data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = totalAdvanceFundDAO.update(data);
        }
        return count;
    }

    @Override
    public List<TotalAdvanceFund> queryTotalAdvanceFundList(
            TotalAdvanceFund condition) {
        return totalAdvanceFundDAO.selectList(condition);
    }

    @Override
    public TotalAdvanceFund getTotalAdvanceFund(String code) {
        TotalAdvanceFund data = null;
        if (StringUtils.isNotBlank(code)) {
            TotalAdvanceFund condition = new TotalAdvanceFund();
            condition.setCode(code);
            data = totalAdvanceFundDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "垫资汇总数据不存在");
            }
        }
        return data;
    }

}
