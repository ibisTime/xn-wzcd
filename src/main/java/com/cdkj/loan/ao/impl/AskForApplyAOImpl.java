package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IAskForApplyAO;
import com.cdkj.loan.bo.IAskForApplyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.AskForApply;
import com.cdkj.loan.dto.req.XN632650Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EAskForApplyStatus;

@Service
public class AskForApplyAOImpl implements IAskForApplyAO {

    @Autowired
    private IAskForApplyBO askForApplyBO;

    @Override
    public String addAskForApply(XN632650Req req) {
        AskForApply data = new AskForApply();
        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        data.setLeadUserId(req.getLeadUserId());
        data.setContent(req.getContent());
        data.setStatus(EAskForApplyStatus.STAY_AUDIT.getCode());
        return askForApplyBO.saveAskForApply(data);
    }

    @Override
    public void approveAskForApply(String code, String approveResult,
            String updater, String remark) {
        AskForApply askForApply = askForApplyBO.getAskForApply(code);
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            askForApply.setStatus(EAskForApplyStatus.AUDIT_PASS.getCode());
        } else {
            askForApply.setStatus(EAskForApplyStatus.AUDIT_NOT_PASS.getCode());
        }
        askForApply.setUpdater(updater);
        askForApply.setUpdateDatetime(new Date());
        askForApply.setRemark(remark);
        askForApplyBO.updateAskForApplyStatus(askForApply);
    }

    @Override
    public Paginable<AskForApply> queryAskForApplyPage(int start, int limit,
            AskForApply condition) {
        return askForApplyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<AskForApply> queryAskForApplyList(AskForApply condition) {
        return askForApplyBO.queryAskForApplyList(condition);
    }

    @Override
    public AskForApply getAskForApply(String code) {
        return askForApplyBO.getAskForApply(code);
    }

}
