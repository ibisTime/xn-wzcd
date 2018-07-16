package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankCardDAO;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.enums.EBankcard;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * @author: asus 
 * @since: 2016年12月22日 下午4:32:05 
 * @history:
 */
@Component
public class BankcardBOImpl extends PaginableBOImpl<Bankcard>
        implements IBankcardBO {

    @Autowired
    private IBankCardDAO bankcardDAO;

    @Autowired
    private IBankAO bankAO;

    @Override
    public String saveBankcard(Bankcard data) {
        String code = null;
        if (data != null) {
            bankcardDAO.insert(data);
        }
        return code;
    }

    @Override
    public String saveBankcardBiz(XN630510Req req) {
        // 判断卡号是否重复
        List<Bankcard> list = queryBankcardList(req.getBankName());
        if (CollectionUtils.isNotEmpty(list)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您已绑定银行卡,无需绑定多张");
        }

        Bankcard data = new Bankcard();
        String code = OrderNoGenerater.generate("BC");
        data.setCode(code);
        data.setBankcardNumber(req.getBankcardNumber());
        data.setBankCode(req.getBankCode());
        Bank bank = bankAO.getBank(req.getBankCode());
        data.setBankName(bank.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        bankcardDAO.insert(data);
        return code;
    }

    @Override
    public int removeBankcard(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Bankcard data = new Bankcard();
            data.setCode(code);
            count = bankcardDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBankcard(Bankcard data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bankcardDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Bankcard> queryBankcardList(Bankcard condition) {
        return bankcardDAO.selectList(condition);
    }

    @Override
    public Bankcard getBankcard(String code) {
        Bankcard data = null;
        if (StringUtils.isNotBlank(code)) {
            Bankcard condition = new Bankcard();
            condition.setCode(code);
            data = bankcardDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "银行卡不存在");
            }
        }
        return data;
    }

    @Override
    public Bankcard getBankcardInfo(String code) {
        Bankcard data = null;
        if (StringUtils.isNotBlank(code)) {
            Bankcard condition = new Bankcard();
            condition.setCode(code);
            data = bankcardDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.std.account.bo.IBankcardBO#getBankcardByBankcardNumber(java.lang.String)
     */
    @Override
    public Bankcard getBankcardByBankcardNumber(String bankcardNumber) {
        Bankcard data = null;
        if (StringUtils.isNotBlank(bankcardNumber)) {
            Bankcard condition = new Bankcard();
            condition.setBankcardNumber(bankcardNumber);
            List<Bankcard> list = bankcardDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                data = list.get(0);
            }
        }
        return data;
    }

    @Override
    public List<Bankcard> queryBankcardList(String userId) {
        Bankcard condition = new Bankcard();
        condition.setUserId(userId);
        return bankcardDAO.selectList(condition);
    }

    @Override
    public String bind(String userId, String realName, String bankcardNumber,
            String bankCode, String bankName) {

        Bankcard data = new Bankcard();

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.BANKCARD.getCode());

        data.setCode(code);
        data.setUserId(userId);
        data.setRealName(realName);
        data.setBankcardNumber(bankcardNumber);
        data.setBankCode(bankCode);

        Bank bank = bankAO.getBank(bankCode);
        data.setBankName(bank.getBankName());
        data.setCreateDatetime(new Date());
        data.setStatus(EBankcard.NORMAL.getCode());

        saveBankcard(data);

        return code;
    }

    @Override
    public void refreshBankcardNumber(Bankcard bankcard) {
        bankcardDAO.updateBankcardNumber(bankcard);
    }
}
