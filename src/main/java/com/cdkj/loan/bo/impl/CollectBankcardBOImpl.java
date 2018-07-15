package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IChannelBankBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.ICollectBankcardDAO;
import com.cdkj.loan.domain.ChannelBank;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.dto.req.XN632060ReqCollectBankcard;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class CollectBankcardBOImpl extends PaginableBOImpl<CollectBankcard>
        implements ICollectBankcardBO {

    @Autowired
    private ICollectBankcardDAO collectBankcardDAO;

    @Autowired
    private IChannelBankBO channelBankBO;

    @Override
    public void saveCollectBankcardList(
            List<XN632060ReqCollectBankcard> collectBankcardList, String type,
            String code) {
        if (CollectionUtils.isNotEmpty(collectBankcardList)) {
            for (XN632060ReqCollectBankcard collectBankcard : collectBankcardList) {
                String cbCode = OrderNoGenerater
                    .generate(EGeneratePrefix.COLLECTBANKCARD.getCode());
                CollectBankcard data = new CollectBankcard();
                data.setCode(cbCode);
                data.setType(type);
                data.setCompanyCode(code);
                data.setRealName(collectBankcard.getRealName());
                data.setBankCode(collectBankcard.getBankCode());
                ChannelBank channelBank = channelBankBO
                    .getChannelBank(collectBankcard.getBankCode());
                data.setBankName(channelBank.getBankName());
                data.setSubbranch(collectBankcard.getSubbranch());
                data.setBankcardNumber(collectBankcard.getBankcardNumber());
                data.setRemark(collectBankcard.getRemark());
                data.setRemark(collectBankcard.getRemark());
                collectBankcardDAO.insert(data);
            }
        }
    }

    @Override
    public void saveCollectBankcardList(
            List<XN632060ReqCollectBankcard> collectBankcardList, String type,
            String belongBank, String code) {
        if (CollectionUtils.isNotEmpty(collectBankcardList)) {
            for (XN632060ReqCollectBankcard collectBankcard : collectBankcardList) {
                String cbCode = OrderNoGenerater
                    .generate(EGeneratePrefix.COLLECTBANKCARD.getCode());
                CollectBankcard data = new CollectBankcard();
                data.setCode(cbCode);
                data.setType(type);
                data.setBelongBank(belongBank);
                data.setCompanyCode(code);
                data.setRealName(collectBankcard.getRealName());
                data.setBankCode(collectBankcard.getBankCode());
                ChannelBank channelBank = channelBankBO
                    .getChannelBank(collectBankcard.getBankCode());
                data.setBankName(channelBank.getBankName());
                data.setSubbranch(collectBankcard.getSubbranch());
                data.setBankcardNumber(collectBankcard.getBankcardNumber());
                data.setPointRate(
                    StringValidater.toDouble(collectBankcard.getPointRate()));
                data.setRemark(collectBankcard.getRemark());
                collectBankcardDAO.insert(data);
            }
        }
    }

    @Override
    public String saveCollectBankcard(CollectBankcard data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.COLLECTBANKCARD.getCode());
            data.setCode(code);
            collectBankcardDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCollectBankcard(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CollectBankcard data = new CollectBankcard();
            data.setCode(code);
            count = collectBankcardDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCollectBankcard(CollectBankcard data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = collectBankcardDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CollectBankcard> queryCollectBankcardList(
            CollectBankcard condition) {
        return collectBankcardDAO.selectList(condition);
    }

    @Override
    public CollectBankcard getCollectBankcard(String code) {
        CollectBankcard data = null;
        if (StringUtils.isNotBlank(code)) {
            CollectBankcard condition = new CollectBankcard();
            condition.setCode(code);
            data = collectBankcardDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "收款账号不存在");
            }
        }
        return data;
    }

    @Override
    public void removeCollectBankcardByCompanyCode(String companyCode) {
        CollectBankcard condition = new CollectBankcard();
        condition.setCompanyCode(companyCode);
        List<CollectBankcard> collectBankcardList = queryCollectBankcardList(
            condition);
        if (CollectionUtils.isNotEmpty(collectBankcardList)) {
            for (CollectBankcard collectBankcard : collectBankcardList) {
                collectBankcardDAO.delete(collectBankcard);
            }
        }
    }

    @Override
    public List<CollectBankcard> queryCollectBankcardByCompanyCodeAndType(
            CollectBankcard condition) {
        List<CollectBankcard> list = null;
        if (StringUtils.isNotBlank(condition.getCompanyCode())
                && StringUtils.isNotBlank(condition.getType())) {
            list = collectBankcardDAO
                .selectCollectBankcardByCompanyCodeAndTypeList(condition);
            if (CollectionUtils.isEmpty(list)) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "收款账号不存在");
            }
        }

        return list;
    }

}
