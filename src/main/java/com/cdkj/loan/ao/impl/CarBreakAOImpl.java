package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarBreakAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.ICarBreakBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarBreak;
import com.cdkj.loan.dto.req.XN632630Req;
import com.cdkj.loan.dto.req.XN632631Req;
import com.cdkj.loan.enums.ECarBreakStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 违章处理
 * @author: silver 
 * @since: 2018年6月6日 下午4:39:49 
 * @history:
 */
@Service
public class CarBreakAOImpl implements ICarBreakAO {

    @Autowired
    private ICarBreakBO carBreakBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Override
    public String addCarBreak(XN632630Req req) {
        CarBreak data = new CarBreak();
        data.setUserId(req.getUserId());
        data.setCarNo(req.getCarNo());
        data.setHappenDatetime(DateUtil.strToDate(req.getHappenDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setHandleNote(req.getHandleNote());
        data.setAddress(req.getAddress());

        data.setAction(req.getAction());
        data.setScore(StringValidater.toInteger(req.getScore()));
        data.setPunishAmount(StringValidater.toLong(req.getPunishAmount()));
        data.setStatus(ECarBreakStatus.TO_APPROVE.getCode());
        return carBreakBO.saveCarBreak(data);
    }

    @Override
    public void approveCarBreak(XN632631Req req) {
        if (!carBreakBO.isCarBreakExist(req.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CarBreak carBreak = carBreakBO.getCarBreak(req.getCode());
        if (!ECarBreakStatus.TO_APPROVE.getCode()
            .equals(carBreak.getStatus())) {
            throw new BizException("xn0000", "申请单不在待审核状态!");
        }

        CarBreak data = new CarBreak();
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
        carBreakBO.approveCarBreak(data);
    }

    @Override
    public Paginable<CarBreak> queryCarBreakPage(int start, int limit,
            CarBreak condition) {
        Paginable<CarBreak> page = carBreakBO.getPaginable(start, limit,
            condition);
        List<CarBreak> carBreakList = page.getList();
        for (CarBreak carBreak : carBreakList) {
            carBreak.setApplyUserArchive(
                archiveBO.getArchiveByUserid(carBreak.getUserId()));
        }
        return page;

    }

    @Override
    public List<CarBreak> queryCarBreakList(CarBreak condition) {
        return carBreakBO.queryCarBreakList(condition);
    }

    @Override
    public CarBreak getCarBreak(String code) {
        CarBreak carBreak = carBreakBO.getCarBreak(code);
        carBreak.setApplyUserArchive(
            archiveBO.getArchiveByUserid(carBreak.getUserId()));
        return carBreak;
    }
}
