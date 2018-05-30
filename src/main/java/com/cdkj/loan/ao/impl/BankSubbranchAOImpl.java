package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankSubbranchAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BankSubbranch;
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

    @Override
    public long addBankSubbranch(XN632050Req req) {
        if (null == bankBO.getBank(req.getBankCode())) {
            throw new BizException("xn0000", "银行信息不存在。");
        }

        if (StringUtils.isNotBlank(req.getPhoneNumber())) {
            PhoneUtil.checkMobile(req.getPhoneNumber());
        }
        if (StringUtils.isNotBlank(req.getAutherPhone())) {
            PhoneUtil.checkMobile(req.getAutherPhone());
        }

        BankSubbranch data = new BankSubbranch();
        data.setBankCode(req.getBankCode());
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
        bankSubbranchBO.saveBankSubbranch(data);

        return bankSubbranchBO.getBankSubbranchMaxid(req.getBankCode());
    }

    @Override
    public int dropBankSubbranch(int id) {
        BankSubbranch condition = new BankSubbranch();
        condition.setId(id);
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
        data.setId(StringValidater.toInteger(req.getId()));
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
    public BankSubbranch getBankSubbranch(int id) {
        BankSubbranch condition = new BankSubbranch();
        condition.setId(id);
        return bankSubbranchBO.getBankSubbranch(condition);
    }

    @Override
    public Paginable<BankSubbranch> queryBankSubbranchPage(int start, int limit,
            BankSubbranch condition) {
        return bankSubbranchBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BankSubbranch> queryBankSubbranchList(BankSubbranch condition) {
        return bankSubbranchBO.queryBankSubbranchList(condition);
    }

}
