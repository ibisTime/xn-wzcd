package com.cdkj.coin.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.IArbitrateBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.IArbitrateDAO;
import com.cdkj.coin.domain.Arbitrate;
import com.cdkj.coin.enums.EArbitrateStatus;
import com.cdkj.coin.enums.EGeneratePrefix;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;

@Component
public class ArbitrateBOImpl extends PaginableBOImpl<Arbitrate> implements
        IArbitrateBO {

    @Autowired
    private IArbitrateDAO arbitrateDAO;

    @Override
    public String submit(String tradeOrderCode, String yuangao, String beigao,
            String reason, String attach) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.ARBITRATE
            .getCode());
        Arbitrate data = new Arbitrate();

        data.setCode(code);
        data.setTradeOrderCode(tradeOrderCode);
        data.setYuangao(yuangao);
        data.setBeigao(beigao);
        data.setReason(reason);
        data.setAttach(attach);
        data.setStatus(EArbitrateStatus.TO_HANDLE.getCode());
        data.setCreateDatetime(new Date());
        arbitrateDAO.insert(data);

        return code;
    }

    @Override
    public int handle(Arbitrate arbitrate, String result, String updater,
            String remark) {
        int count = 0;
        if (arbitrate != null) {
            arbitrate.setResult(result);
            arbitrate.setUpdater(updater);
            arbitrate.setUpdateDatetime(new Date());
            arbitrate.setRemark(remark);
            count = arbitrateDAO.updateHandle(arbitrate);
        }
        return count;
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
