package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarBreakBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarBreakDAO;
import com.cdkj.loan.domain.CarBreak;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 违章处理
 * @author: silver 
 * @since: 2018年6月6日 下午4:37:14 
 * @history:
 */
@Component
public class CarBreakBOImpl extends PaginableBOImpl<CarBreak>
        implements ICarBreakBO {

    @Autowired
    private ICarBreakDAO CarBreakDAO;

    @Override
    public boolean isCarBreakExist(String code) {
        CarBreak condition = new CarBreak();
        condition.setCode(code);
        if (CarBreakDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCarBreak(CarBreak data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.CAR_BREAK.getCode());
            data.setCode(code);
            CarBreakDAO.insert(data);
        }
        return code;
    }

    @Override
    public void approveCarBreak(CarBreak data) {
        if (null != data) {
            CarBreakDAO.update(data);
        }
    }

    @Override
    public List<CarBreak> queryCarBreakList(CarBreak condition) {
        return CarBreakDAO.selectList(condition);
    }

    @Override
    public CarBreak getCarBreak(String code) {
        CarBreak data = null;
        if (StringUtils.isNotBlank(code)) {
            CarBreak condition = new CarBreak();
            condition.setCode(code);
            data = CarBreakDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }
        }
        return data;
    }
}
