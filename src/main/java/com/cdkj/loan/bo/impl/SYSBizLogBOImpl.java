package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ISYSBizLogDAO;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ESYSBizLogStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class SYSBizLogBOImpl extends PaginableBOImpl<SYSBizLog> implements
        ISYSBizLogBO {

    @Autowired
    private ISYSBizLogDAO sysBizLogDAO;

    @Autowired
    private ISYSUserBO sysUserBO;

    // 流程第一步操作日志
    @Override
    public void recordCurrentSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String dealNote, String operator) {
        SYSBizLog data = new SYSBizLog();
        data.setParentOrder(parentOrder);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setDealNote(dealNote);
        data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());// 已处理
        SYSUser sysUser = sysUserBO.getUser(operator);
        data.setOperateRole(sysUser.getRoleCode());
        data.setOperator(sysUser.getUserId());
        data.setOperatorName(sysUser.getRealName());
        data.setOperatorMobile(sysUser.getMobile());
        data.setStartDatetime(new Date());
        data.setEndDatetime(new Date());
        data.setSpeedTime("0天0时0分0秒");
        sysBizLogDAO.insert(data);
    }

    // 流程下一步待操作的日志
    @Override
    public void saveSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode) {
        SYSBizLog data = new SYSBizLog();
        data.setParentOrder(parentOrder);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setStatus(ESYSBizLogStatus.WAIT_HANDLE.getCode());// 待处理
        data.setStartDatetime(new Date());
        sysBizLogDAO.insert(data);
    }

    // 流程中间日志（1记录当前操作 2生成下一步操作）
    @Override
    public void saveNewAndPreEndSYSBizLog(String parentOrder,
            EBizLogType refType, String refOrder, String preDealNode,
            String nowDealNode, String nowDealNote, String operator) {
        // 处理之前节点
        refreshPreSYSBizLog(refType, refOrder, preDealNode, nowDealNote,
            operator);
        // 保存新节点（为下一个节点生成的 有开始时间 待填入操作人和结束时间）
        saveSYSBizLog(parentOrder, refType, refOrder, nowDealNode);
    }

    // 流程最后操作记录日志
    @Override
    public void refreshPreSYSBizLog(EBizLogType refType, String refOrder,
            String dealNode, String dealNote, String operator) {
        SYSBizLog data = getSYSBizLoglatest(refType.getCode(), refOrder,
            dealNode);
        if (data != null) {
            data.setEndDatetime(new Date());
            // 计算花费时间
            Long start = data.getStartDatetime().getTime();
            Long end = data.getEndDatetime().getTime();
            Long diff = end - start;
            Long day = diff / (24 * 60 * 60 * 1000);
            Long hour = (diff / (60 * 60 * 1000) - day * 24);
            Long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            Long sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            data.setSpeedTime(day + "天" + hour + "时" + min + "分" + sec + "秒");
            data.setDealNote(dealNote);
            data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());// 已处理
            SYSUser sysUser = sysUserBO.getUser(operator);
            data.setOperateRole(sysUser.getRoleCode());
            data.setOperator(sysUser.getUserId());
            data.setOperatorName(sysUser.getRealName());
            data.setOperatorMobile(sysUser.getMobile());
            sysBizLogDAO.updateSysBizLog(data);
        }
    }

    @Override
    public SYSBizLog getSYSBizLoglatest(String refType, String refOrder,
            String dealNode) {
        SYSBizLog condition = new SYSBizLog();
        condition.setRefOrder(refOrder);
        condition.setRefType(refType);
        condition.setDealNode(dealNode);
        return sysBizLogDAO.selectSysBizLogLatest(condition);
    }

    @Override
    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition) {
        return sysBizLogDAO.selectList(condition);
    }

    @Override
    public SYSBizLog getSYSBizLog(int id) {
        SYSBizLog data = null;
        if (id != 0) {
            SYSBizLog condition = new SYSBizLog();
            condition.setId(id);
            data = sysBizLogDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "日志不存在！");
            }
        }
        return data;
    }

    @Override
    public List<SYSBizLog> querySYSBizLogListByRoleCode(SYSBizLog condition) {
        return sysBizLogDAO.selectListByRoleCode(condition);
    }

    @Override
    public Paginable<SYSBizLog> getPaginableByRoleCode(int start, int limit,
            SYSBizLog condition) {
        prepare(condition);
        long totalCount = sysBizLogDAO.selectTotalCountByRoleCode(condition);
        Paginable<SYSBizLog> page = new Page<SYSBizLog>(start, limit,
            totalCount);
        List<SYSBizLog> dataList = sysBizLogDAO.selectListByRoleCode(condition,
            page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

}
