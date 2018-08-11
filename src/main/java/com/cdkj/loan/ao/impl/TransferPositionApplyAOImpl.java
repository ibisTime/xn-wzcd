package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ITransferPositionApplyAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ITransferPositionApplyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.TransferPositionApply;
import com.cdkj.loan.dto.req.XN632880Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.ETransferPositionApplyStatus;

@Service
public class TransferPositionApplyAOImpl implements ITransferPositionApplyAO {

    @Autowired
    private ITransferPositionApplyBO transferPositionApplyBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addTransferPositionApply(XN632880Req req) {
        TransferPositionApply data = new TransferPositionApply();
        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        data.setNewDepartment(req.getNewDepartment());
        data.setNewPosition(req.getNewPosition());
        data.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setReason(req.getReason());
        data.setStatus(ETransferPositionApplyStatus.STAY_AUDIT.getCode());
        return transferPositionApplyBO.saveTransferPositionApply(data);
    }

    @Override
    public void approveTransferPositionApply(String code, String approveResult,
            String updater, String remark) {
        TransferPositionApply transferPositionApply = transferPositionApplyBO
            .getTransferPositionApply(code);
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            transferPositionApply
                .setStatus(ETransferPositionApplyStatus.AUDIT_PASS.getCode());
        } else {
            transferPositionApply.setStatus(
                ETransferPositionApplyStatus.AUDIT_NOT_PASS.getCode());
        }
        transferPositionApply.setUpdater(updater);
        transferPositionApply.setUpdateDatetime(new Date());
        transferPositionApply.setRemark(remark);
        transferPositionApplyBO
            .updateTransferPositionApplyStatus(transferPositionApply);
    }

    @Override
    public Paginable<TransferPositionApply> queryTransferPositionApplyPage(
            int start, int limit, TransferPositionApply condition) {
        Paginable<TransferPositionApply> paginable = transferPositionApplyBO
            .getPaginable(start, limit, condition);
        if (paginable != null) {
            for (TransferPositionApply transferPositionApply : paginable
                .getList()) {
                initTransferPositionApply(transferPositionApply);
            }
        }
        return paginable;
    }

    @Override
    public List<TransferPositionApply> queryTransferPositionApplyList(
            TransferPositionApply condition) {
        List<TransferPositionApply> transferPositionApplyList = transferPositionApplyBO
            .queryTransferPositionApplyList(condition);
        for (TransferPositionApply transferPositionApply : transferPositionApplyList) {
            initTransferPositionApply(transferPositionApply);
        }
        return transferPositionApplyList;
    }

    @Override
    public TransferPositionApply getTransferPositionApply(String code) {
        TransferPositionApply transferPositionApply = transferPositionApplyBO
            .getTransferPositionApply(code);
        initTransferPositionApply(transferPositionApply);
        return transferPositionApply;
    }

    private void initTransferPositionApply(
            TransferPositionApply transferPositionApply) {
        SYSUser user = sysUserBO.getUser(transferPositionApply.getApplyUser());
        transferPositionApply.setUser(user);
        Archive archive = archiveBO
            .getArchiveByUserid(transferPositionApply.getApplyUser());
        transferPositionApply.setArchice(archive);
        if (StringUtils.isNotBlank(transferPositionApply.getNewDepartment())) {
            Department department = departmentBO
                .getDepartment(transferPositionApply.getNewDepartment());
            transferPositionApply.setNewDepartmentName(department.getName());
        }
        if (StringUtils.isNotBlank(transferPositionApply.getNewPosition())) {
            Department department = departmentBO
                .getDepartment(transferPositionApply.getNewPosition());
            transferPositionApply.setNewPositionName(department.getName());
        }
    }
}
