package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IContractAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IContractBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.Contract;
import com.cdkj.loan.dto.res.XN632833Res;
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

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addContract(Contract data) {
        return contractBO.saveContract(data);
    }

    @Override
    public int editContract(Contract data) {
        if (!contractBO.isContractExist(data.getCode())) {
            throw new BizException("xn0000", "合同不存在");
        }
        return contractBO.refreshContract(data);
    }

    @Override
    public int dropContract(String code) {
        if (!contractBO.isContractExist(code)) {
            throw new BizException("xn0000", "合同不存在");
        }
        return contractBO.removeContract(code);
    }

    @Override
    public Paginable<Contract> queryContractPage(int start, int limit,
            Contract condition) {
        Paginable<Contract> paginable = contractBO.getPaginable(start, limit,
            condition);
        for (Contract contract : paginable.getList()) {
            Archive archive = archiveBO.getArchive(contract.getArchiveCode());
            contract.setArchive(archive);
        }
        return paginable;
    }

    @Override
    public List<Contract> queryContractList(Contract condition) {
        List<Contract> queryContractList = contractBO
            .queryContractList(condition);
        for (Contract contract : queryContractList) {
            Archive archive = archiveBO.getArchive(contract.getArchiveCode());
            contract.setArchive(archive);
        }
        return queryContractList;
    }

    @Override
    public Contract getContract(String code) {
        Contract contract = contractBO.getContract(code);
        Archive archive = archiveBO.getArchive(contract.getArchiveCode());
        contract.setArchive(archive);
        return contract;
    }

    @Override
    public List<XN632833Res> getEarlyWarning(String year, String month) {
        ArrayList<XN632833Res> list = new ArrayList<XN632833Res>();
        Contract condition = new Contract();
        condition.setWarnDatetimeStart(DateUtil.getBeginTime(
            StringValidater.toInteger(year), StringValidater.toInteger(month)));
        condition.setWarnDatetimeEnd(DateUtil.getEndTime(
            StringValidater.toInteger(year), StringValidater.toInteger(month)));
        List<Contract> contractList = contractBO.queryContractList(condition);
        for (Contract contract : contractList) {
            XN632833Res res = new XN632833Res();
            Archive archive = archiveBO.getArchive(contract.getArchiveCode());
            res.setArchiveCode(contract.getArchiveCode());
            res.setRealName(archive.getRealName());
            String name = departmentBO.getDepartment(
                archive.getDepartmentCode()).getName();
            res.setDepartmentName(name);
            res.setEndDatetime(contract.getEndDatetime());
            list.add(res);
        }
        return list;
    }
}
