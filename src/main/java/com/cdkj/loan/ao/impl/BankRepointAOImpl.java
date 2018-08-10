package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankRepointAO;
import com.cdkj.loan.bo.IBankRepointBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankRepoint;
import com.cdkj.loan.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class BankRepointAOImpl implements IBankRepointAO {

	@Autowired
	private IBankRepointBO bankRepointBO;

	@Override
	public String addBankRepoint(BankRepoint data) {
		return bankRepointBO.saveBankRepoint(data);
	}

	@Override
	public int editBankRepoint(BankRepoint data) {
		if (!bankRepointBO.isBankRepointExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return bankRepointBO.refreshBankRepoint(data);
	}

	@Override
	public int dropBankRepoint(String code) {
		if (!bankRepointBO.isBankRepointExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return bankRepointBO.removeBankRepoint(code);
	}

	@Override
	public Paginable<BankRepoint> queryBankRepointPage(int start, int limit,
			BankRepoint condition) {
		return bankRepointBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<BankRepoint> queryBankRepointList(BankRepoint condition) {
		return bankRepointBO.queryBankRepointList(condition);
	}

	@Override
	public BankRepoint getBankRepoint(String code) {
		return bankRepointBO.getBankRepoint(code);
	}
}