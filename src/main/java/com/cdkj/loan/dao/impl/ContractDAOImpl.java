package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IContractDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Contract;

/**
 * 合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午8:34:26 
 * @history:
 */
@Repository("contractDAOImpl")
public class ContractDAOImpl extends AMybatisTemplate implements IContractDAO {

    @Override
    public int insert(Contract data) {
        return super.insert(NAMESPACE.concat("insert_contract"), data);
    }

    @Override
    public int delete(Contract data) {
        return super.delete(NAMESPACE.concat("delete_contract"), data);
    }

    @Override
    public Contract select(Contract condition) {
        return super.select(NAMESPACE.concat("select_contract"), condition,
            Contract.class);
    }

    @Override
    public long selectTotalCount(Contract condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_contract_count"), condition);
    }

    @Override
    public List<Contract> selectList(Contract condition) {
        return super.selectList(NAMESPACE.concat("select_contract"), condition,
            Contract.class);
    }

    @Override
    public List<Contract> selectList(Contract condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_contract"), start,
            count, condition, Contract.class);
    }

    @Override
    public int update(Contract data) {

        return 0;
    }

}
