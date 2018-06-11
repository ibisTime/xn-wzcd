package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepointDAO;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午10:09:17 
 * @history:
 */
@Component
public class RepointBOImpl extends PaginableBOImpl<Repoint> implements
        IRepointBO {

    @Autowired
    private IRepointDAO repointDAO;

    @Override
    public String saveRepoint(Repoint data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.REPOINT.getCode());
            data.setCode(code);
            repointDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshRepoint(Repoint data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = repointDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Repoint> queryRepointList(Repoint condition) {
        return repointDAO.selectList(condition);
    }

    @Override
    public Repoint getRepoint(String code) {
        Repoint data = null;
        if (StringUtils.isNotBlank(code)) {
            Repoint condition = new Repoint();
            condition.setCode(code);
            data = repointDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "返点支付数据不存在");
            }
        }
        return data;
    }
}
