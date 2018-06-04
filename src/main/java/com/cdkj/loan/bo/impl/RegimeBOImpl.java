package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRegimeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRegimeDAO;
import com.cdkj.loan.domain.Regime;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:34:55 
 * @history:
 */
@Component
public class RegimeBOImpl extends PaginableBOImpl<Regime> implements IRegimeBO {

    @Autowired
    private IRegimeDAO regimeDAO;

    @Override
    public boolean isRegimeExist(String code) {
        Regime condition = new Regime();
        condition.setCode(code);
        if (regimeDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRegime(Regime data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.REGIME.getCode());
            data.setCode(code);
            regimeDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<Regime> queryRegimeList(Regime condition) {
        return regimeDAO.selectList(condition);
    }

    @Override
    public Regime getRegime(String code) {
        Regime data = null;
        if (StringUtils.isNotBlank(code)) {
            Regime condition = new Regime();
            condition.setCode(code);
            data = regimeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "公司制度不存在！");
            }
        }
        return data;
    }
}
