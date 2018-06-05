package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IContractBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IContractDAO;
import com.cdkj.loan.domain.Contract;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 合同管理
 * @author: jiafr 
 * @since: 2018年6月5日 下午8:33:07 
 * @history:
 */
@Component
public class ContractBOImpl extends PaginableBOImpl<Contract> implements
        IContractBO {

    @Autowired
    private IContractDAO contractDAO;

    @Override
    public boolean isContractExist(String code) {
        Contract condition = new Contract();
        condition.setCode(code);
        if (contractDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveContract(Contract data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.CONTRACT.getCode());
            data.setCode(code);
            contractDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeContract(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Contract data = new Contract();
            data.setCode(code);
            count = contractDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshContract(Contract data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = contractDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Contract> queryContractList(Contract condition) {
        return contractDAO.selectList(condition);
    }

    @Override
    public Contract getContract(String code) {
        Contract data = null;
        if (StringUtils.isNotBlank(code)) {
            Contract condition = new Contract();
            condition.setCode(code);
            data = contractDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
