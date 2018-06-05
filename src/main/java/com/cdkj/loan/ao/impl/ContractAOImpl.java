package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IContractAO;
import com.cdkj.loan.bo.IContractBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Contract;
import com.cdkj.loan.exception.BizException;

/**
 * 合同管理
 * @author: jiafr 
 * @since: 2018年6月5日 下午8:30:15 
 * @history:
 */
@Service
public class ContractAOImpl implements IContractAO {

    @Autowired
    private IContractBO contractBO;

    @Override
    public String addContract(Contract data) {
        return contractBO.saveContract(data);
    }

    @Override
    public int editContract(Contract data) {
        if (!contractBO.isContractExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return contractBO.refreshContract(data);
    }

    @Override
    public int dropContract(String code) {
        if (!contractBO.isContractExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return contractBO.removeContract(code);
    }

    @Override
    public Paginable<Contract> queryContractPage(int start, int limit,
            Contract condition) {
        return contractBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Contract> queryContractList(Contract condition) {
        return contractBO.queryContractList(condition);
    }

    @Override
    public Contract getContract(String code) {
        return contractBO.getContract(code);
    }
}
