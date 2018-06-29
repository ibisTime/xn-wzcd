package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankSubbranchAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632050Req;
import com.cdkj.loan.dto.req.XN632052Req;
import com.cdkj.loan.exception.BizException;

/**
 * 支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:42:28 
 * @history:
 */
@Service
public class BankSubbranchAOImpl implements IBankSubbranchAO {
    @Autowired
    private IBankSubbranchBO bankSubbranchBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addBankSubbranch(XN632050Req req) {
        if (null == bankBO.getBank(req.getBankCode())) {
            throw new BizException("xn0000", "银行信息不存在。");
        }

        if (StringUtils.isNotBlank(req.getPhoneNumber())) {
            PhoneUtil.checkMobile(req.getPhoneNumber());
        }
        if (StringUtils.isNotBlank(req.getAutherPhoneNumber())) {
            PhoneUtil.checkMobile(req.getAutherPhoneNumber());
        }

        BankSubbranch data = new BankSubbranch();
        data.setBankCode(req.getBankCode());
        Bank bank = bankBO.getBank(req.getBankCode());
        data.setBankType(bank.getBankCode());
        data.setAbbrName(req.getAbbrName());
        data.setFullName(req.getFullName());
        data.setOpenBank(req.getOpenBank());
        data.setAddress(req.getAddress());

        data.setPhoneNumber(req.getPhoneNumber());
        data.setPostCode(req.getPostCode());
        data.setBankClient(req.getBankClient());
        data.setClientValidDate(DateUtil.strToDate(req.getClientValidDate(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setAutherName(req.getAutherName());

        data.setAutherPhoneNumber(req.getAutherPhoneNumber());
        data.setAutherIdNo(req.getAutherIdNo());
        data.setAutherAddress(req.getAutherAddress());
        data.setCreditCardType(req.getCreditCardType());
        data.setCreditCardName(req.getCreditCardName());

        data.setBelongArea(req.getBelongArea());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());

        return bankSubbranchBO.saveBankSubbranch(data);
    }

    @Override
    public int dropBankSubbranch(String code) {
        BankSubbranch condition = new BankSubbranch();
        condition.setCode(code);
        return bankSubbranchBO.dropBankSubbranch(condition);
    }

    @Override
    public int editBankSubbranch(XN632052Req req) {
        if (StringUtils.isNotBlank(req.getPhoneNumber())) {
            PhoneUtil.checkMobile(req.getPhoneNumber());
        }
        if (StringUtils.isNotBlank(req.getAutherPhone())) {
            PhoneUtil.checkMobile(req.getAutherPhone());
        }

        BankSubbranch data = new BankSubbranch();
        data.setCode(req.getCode());
        data.setAbbrName(req.getAbbrName());
        data.setFullName(req.getFullName());
        data.setOpenBank(req.getOpenBank());

        data.setAddress(req.getAddress());
        data.setPhoneNumber(req.getPhoneNumber());
        data.setPostCode(req.getPostCode());
        data.setBankClient(req.getBankClient());
        data.setClientValidDate(DateUtil.strToDate(req.getClientValidDate(),
            DateUtil.DATA_TIME_PATTERN_1));

        data.setAutherName(req.getAutherName());
        data.setAutherPhoneNumber(req.getAutherPhone());
        data.setAutherIdNo(req.getAutherIdNo());
        data.setAutherAddress(req.getAutherAddress());
        data.setCreditCardType(req.getCreditCardType());

        data.setCreditCardName(req.getCreditCardName());
        data.setBelongArea(req.getBelongArea());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return bankSubbranchBO.editBankSubbranch(data);
    }

    @Override
    public BankSubbranch getBankSubbranch(String code) {
        BankSubbranch bankSubbranch = bankSubbranchBO.getBankSubbranch(code);
        initBankSubbranch(bankSubbranch);
        return bankSubbranch;
    }

    @Override
    public Paginable<BankSubbranch> queryBankSubbranchPage(int start, int limit,
            BankSubbranch condition) {
        Paginable<BankSubbranch> paginable = bankSubbranchBO.getPaginable(start,
            limit, condition);
        for (BankSubbranch bankSubbranch : paginable.getList()) {
            initBankSubbranch(bankSubbranch);
        }
        return paginable;
    }

    @Override
    public List<BankSubbranch> queryBankSubbranchList(BankSubbranch condition) {
        List<BankSubbranch> bankSubbranchList = bankSubbranchBO
            .queryBankSubbranchList(condition);
        for (BankSubbranch bankSubbranch : bankSubbranchList) {
            initBankSubbranch(bankSubbranch);
        }
        return bankSubbranchList;
    }

    private void initBankSubbranch(BankSubbranch bankSubbranch) {
        if (bankSubbranch != null) {
            Bank bank = bankBO.getBankBySubbranch(bankSubbranch.getCode());
            bankSubbranch.setBank(bank);
            String bankName = bank.getBankName();
            bankSubbranch.setBankName(bankName);
            SYSUser user = sysUserBO.getUser(bankSubbranch.getUpdater());
            bankSubbranch.setUpdaterName(user.getRealName());
        }
    }

}
