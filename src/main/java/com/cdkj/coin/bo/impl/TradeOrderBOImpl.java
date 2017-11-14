package com.cdkj.coin.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.ITradeOrderDAO;
import com.cdkj.coin.domain.TradeOrder;
import com.cdkj.coin.enums.EGeneratePrefix;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;

@Component
public class TradeOrderBOImpl extends PaginableBOImpl<TradeOrder> implements
        ITradeOrderBO {

    @Autowired
    private ITradeOrderDAO tradeOrderDAO;

    @Override
    public String saveTradeOrder(TradeOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.TRADE_ORDER
                .getCode());
            data.setCode(code);
            tradeOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<TradeOrder> queryTradeOrderList(TradeOrder condition) {
        return tradeOrderDAO.selectList(condition);
    }

    @Override
    public TradeOrder getTradeOrder(String code) {
        TradeOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            TradeOrder condition = new TradeOrder();
            condition.setCode(code);
            data = tradeOrderDAO.select(condition);
            if (data == null) {
                throw new BizException(
                    EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "编号为"
                            + code + "的交易订单不存在");
            }
        }
        return data;
    }
}
