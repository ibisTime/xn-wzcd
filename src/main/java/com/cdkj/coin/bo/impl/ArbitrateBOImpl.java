package com.cdkj.coin.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.IArbitrateBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.IArbitrateDAO;
import com.cdkj.coin.domain.Arbitrate;
import com.cdkj.coin.enums.EGeneratePrefix;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;

@Component
public class ArbitrateBOImpl extends PaginableBOImpl<Arbitrate> implements
        IArbitrateBO {

    @Autowired
    private IArbitrateDAO arbitrateDAO;

    @Override
    public String saveArbitrate(Arbitrate data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.ARBITRATE
                .getCode());
            data.setCode(code);
            arbitrateDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<Arbitrate> queryArbitrateList(Arbitrate condition) {
        return arbitrateDAO.selectList(condition);
    }

    @Override
    public Arbitrate getArbitrate(String code) {
        Arbitrate data = null;
        if (StringUtils.isNotBlank(code)) {
            Arbitrate condition = new Arbitrate();
            condition.setCode(code);
            data = arbitrateDAO.select(condition);
            if (data == null) {
                throw new BizException(
                    EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "编号为"
                            + code + "的仲裁工单不存在");
            }
        }
        return data;
    }
}
