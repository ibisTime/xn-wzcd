package com.cdkj.coin.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IArbitrateAO;
import com.cdkj.coin.bo.IArbitrateBO;
import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.Arbitrate;
import com.cdkj.coin.domain.TradeOrder;
import com.cdkj.coin.enums.EArbitrateStatus;
import com.cdkj.coin.enums.EBoolean;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;

@Service
public class ArbitrateAOImpl implements IArbitrateAO {

    @Autowired
    private IArbitrateBO arbitrateBO;

    @Autowired
    private ITradeOrderBO tradeOrderBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public void handle(String code, String result, String updater, String remark) {
        Arbitrate arbitrate = arbitrateBO.getArbitrate(code);
        if (!EArbitrateStatus.TO_HANDLE.getCode().equals(arbitrate.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "仲裁工单不处于待处理状态");
        }
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(arbitrate
            .getTradeOrderCode());
        if (EBoolean.YES.getCode().equals(result)) {
            if (arbitrate.getYuangao().equals(tradeOrder.getBuyUser())) {
                tradeOrderBO.release(tradeOrder, updater, "仲裁后释放");
            } else {
                tradeOrderBO.revokePay(tradeOrder, updater, "仲裁后撤回打款");
            }
        }
        // 更新仲裁工单信息
        arbitrateBO.handle(arbitrate, result, updater, remark);
    }

    @Override
    public Paginable<Arbitrate> queryArbitratePage(int start, int limit,
            Arbitrate condition) {
        Paginable<Arbitrate> results = arbitrateBO.getPaginable(start, limit,
            condition);
        for (Arbitrate arbitrate : results.getList()) {
            arbitrate.setYuangaoInfo(userBO.getUser(arbitrate.getYuangao()));
            arbitrate.setBeigaoInfo(userBO.getUser(arbitrate.getBeigao()));
        }
        return results;
    }

    @Override
    public List<Arbitrate> queryArbitrateList(Arbitrate condition) {
        return arbitrateBO.queryArbitrateList(condition);
    }

    @Override
    public Arbitrate getArbitrate(String code) {
        Arbitrate arbitrate = arbitrateBO.getArbitrate(code);
        arbitrate.setYuangaoInfo(userBO.getUser(arbitrate.getYuangao()));
        arbitrate.setBeigaoInfo(userBO.getUser(arbitrate.getBeigao()));
        return arbitrate;
    }

}
