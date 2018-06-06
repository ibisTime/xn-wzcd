package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISuppleSignApplyAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.ISuppleSignApplyBO;
import com.cdkj.loan.bo.ISuppleSignApplyDetailBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.SuppleSignApply;
import com.cdkj.loan.domain.SuppleSignApplyDetail;
import com.cdkj.loan.dto.req.XN632600Req;
import com.cdkj.loan.dto.req.XN632600ReqDetail;
import com.cdkj.loan.dto.req.XN632601Req;
import com.cdkj.loan.enums.ELeaveApplyStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 补签
 * @author: silver 
 * @since: 2018年6月5日 下午10:58:30 
 * @history:
 */
@Service
public class SuppleSignApplyAOImpl implements ISuppleSignApplyAO {

    @Autowired
    private ISuppleSignApplyBO suppleSignApplyBO;

    @Autowired
    private ISuppleSignApplyDetailBO suppleSignApplyDetailBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Override
    public String addSuppleSignApply(XN632600Req req) {
        if (null == req.getDetailList()) {
            throw new BizException("xn0000", "请填写漏签明细！");
        }

        SuppleSignApply data = new SuppleSignApply();
        data.setApplyUser(req.getApplyUser());
        data.setReason(req.getReason());
        data.setUpdater(req.getUpdater());
        data.setStatus(ELeaveApplyStatus.TO_APPROVE.getCode());
        data.setApplyDatetime(new Date());
        String suppleSignApplyCode = suppleSignApplyBO
            .saveSuppleSignApply(data);

        // 添加补签明细
        for (XN632600ReqDetail detail : req.getDetailList()) {
            suppleSignApplyDetailBO.saveSuppleSignApplyDetail(
                suppleSignApplyCode, detail.getSuppleDatetime(),
                detail.getRemark());
        }

        return suppleSignApplyCode;
    }

    @Override
    public void approveSuppleSignApply(XN632601Req req) {
        if (!suppleSignApplyBO.isSuppleSignApplyExist(req.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        SuppleSignApply suppleSignApply = suppleSignApplyBO
            .getSuppleSignApply(req.getCode());
        if (!ELeaveApplyStatus.TO_APPROVE.getCode()
            .equals(suppleSignApply.getStatus())) {
            throw new BizException("xn0000", "申请单不在待审核状态!");
        }

        SuppleSignApply data = new SuppleSignApply();
        data.setCode(req.getCode());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        data.setUpdateDatetime(new Date());
        if (req.getResult().equals(ELeaveApplyStatus.APPROVE_PASS.getCode())) {
            data.setStatus(ELeaveApplyStatus.APPROVE_PASS.getCode());
        } else if (req.getResult()
            .equals(ELeaveApplyStatus.APPROVE_FAIL.getCode())) {
            data.setStatus(ELeaveApplyStatus.APPROVE_FAIL.getCode());
        }

        suppleSignApplyBO.refreshSuppleSignApply(data);
    }

    @Override
    public Paginable<SuppleSignApply> querySuppleSignApplyPage(int start,
            int limit, SuppleSignApply condition) {
        Paginable<SuppleSignApply> page = suppleSignApplyBO.getPaginable(start,
            limit, condition);
        List<SuppleSignApply> suppleSignApplyList = page.getList();
        for (SuppleSignApply suppleSignApply : suppleSignApplyList) {
            Archive archive = new Archive();
            archive.setUserId(suppleSignApply.getApplyUser());
            suppleSignApply
                .setApplyUserArchive(archiveBO.queryArchiveList(archive));
        }
        return page;
    }

    @Override
    public List<SuppleSignApply> querySuppleSignApplyList(
            SuppleSignApply condition) {
        return suppleSignApplyBO.querySuppleSignApplyList(condition);
    }

    @Override
    public SuppleSignApply getSuppleSignApply(String code) {
        SuppleSignApply suppleSignApply = suppleSignApplyBO
            .getSuppleSignApply(code);

        // 组装档案信息
        Archive archive = new Archive();
        archive.setUserId(suppleSignApply.getApplyUser());
        suppleSignApply
            .setApplyUserArchive(archiveBO.queryArchiveList(archive));

        // 组装补签明细
        SuppleSignApplyDetail detailCondition = new SuppleSignApplyDetail();
        detailCondition.setSupplySignApplyCode(code);
        suppleSignApply.setDetailList(suppleSignApplyDetailBO
            .querySuppleSignApplyDetailList(detailCondition));

        return suppleSignApply;
    }
}
