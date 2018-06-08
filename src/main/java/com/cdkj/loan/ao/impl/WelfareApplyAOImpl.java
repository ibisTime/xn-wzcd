package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IWelfareApplyAO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IWelfareApplyBO;
import com.cdkj.loan.bo.IWelfareUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.WelfareApply;
import com.cdkj.loan.domain.WelfareUser;
import com.cdkj.loan.dto.req.XN632660Req;
import com.cdkj.loan.dto.req.XN632660ReqDetail;
import com.cdkj.loan.dto.req.XN632661Req;
import com.cdkj.loan.enums.ECarBreakStatus;
import com.cdkj.loan.enums.EWelfareApplyStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午7:19:03 
 * @history:
 */
@Service
public class WelfareApplyAOImpl implements IWelfareApplyAO {
    @Autowired
    private IWelfareApplyBO welfareApplyBO;

    @Autowired
    private IWelfareUserBO welfareUserBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addWelfareApply(XN632660Req req) {
        if (req.getUserList() == null) {
            throw new BizException("xn0000", "请填写发放人员！");
        }

        WelfareApply data = new WelfareApply();
        data.setApplyUser(req.getApplyUser());
        data.setApplyNote(req.getApplyNote());
        data.setRemark(req.getRemark());
        data.setApplyDatetime(new Date());
        data.setStatus(EWelfareApplyStatus.TO_APPROVE.getCode());

        String welfareApplyCpde = welfareApplyBO.saveWelfareApply(data);
        for (XN632660ReqDetail user : req.getUserList()) {
            welfareUserBO.saveWelfareUser(welfareApplyCpde, user.getUserId(),
                user.getRemark());
        }

        return welfareApplyCpde;
    }

    @Override
    public void approveWelfareApply(XN632661Req req) {
        if (!welfareApplyBO.isWelfareApplyExist(req.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        WelfareApply welfareApply = welfareApplyBO
            .getWelfareApply(req.getCode());
        if (!EWelfareApplyStatus.TO_APPROVE.getCode()
            .equals(welfareApply.getStatus())) {
            throw new BizException("xn0000", "申请单不在待审核状态!");
        }

        WelfareApply data = new WelfareApply();
        data.setCode(req.getCode());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        data.setUpdateDatetime(new Date());

        if (req.getApproveResult()
            .equals(ECarBreakStatus.APPROVE_PASS.getCode())) {
            data.setStatus(ECarBreakStatus.APPROVE_PASS.getCode());
        } else if (req.getApproveResult()
            .equals(ECarBreakStatus.APPROVE_FAIL.getCode())) {
            data.setStatus(ECarBreakStatus.APPROVE_FAIL.getCode());
        }
        welfareApplyBO.refreshWelfareApply(data);
    }

    @Override
    public Paginable<WelfareApply> queryWelfareApplyPage(int start, int limit,
            WelfareApply condition) {
        Paginable<WelfareApply> page = welfareApplyBO.getPaginable(start, limit,
            condition);
        List<WelfareApply> welfareApplyList = page.getList();
        for (WelfareApply welfareApply : welfareApplyList) {
            init(welfareApply);
        }
        return page;
    }

    @Override
    public List<WelfareApply> queryWelfareApplyList(WelfareApply condition) {
        List<WelfareApply> welfareApplyList = welfareApplyBO
            .queryWelfareApplyList(condition);
        for (WelfareApply welfareApply : welfareApplyList) {
            init(welfareApply);
        }
        return welfareApplyList;
    }

    @Override
    public WelfareApply getWelfareApply(String code) {
        WelfareApply welfareApply = welfareApplyBO.getWelfareApply(code);

        // 初始化
        init(welfareApply);
        WelfareUser welfareUserCondition = new WelfareUser();
        welfareUserCondition.setWelfareCode(code);
        welfareApply.setWelfareUserList(
            welfareUserBO.queryWelfareUserList(welfareUserCondition));
        return welfareApply;
    }

    private void init(WelfareApply welfareApply) {
        welfareApply.setApplyUserArchive(
            sysUserBO.getUser(welfareApply.getApplyUser()));
    }
}
