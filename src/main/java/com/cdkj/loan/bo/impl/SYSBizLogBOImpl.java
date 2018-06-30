package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
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

    @Override
    public void saveSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String dealNote, String operator) {
        SYSUser sysUser = sysUserBO.getUser(operator);
        SYSBizLog data = new SYSBizLog();
        data.setParentOrder(parentOrder);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setDealNote(dealNote);

        data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());
        data.setOperateRole(sysUser.getRoleCode());
        data.setOperator(sysUser.getUserId());
        data.setOperatorName(sysUser.getLoginName());
        data.setOperatorMobile(sysUser.getMobile());

        data.setStartDatetime(new Date());
        sysBizLogDAO.insert(data);
    }

    // 系统用户记录日志
    @Override
    public void saveNewAndPreEndSYSBizLog(String parentOrder,
            EBizLogType refType, String refOrder, String preDealNode,
            String nowDealNode, String nowDealNote, String operator) {
        // 保存新节点
        saveSYSBizLog(parentOrder, refType, refOrder, nowDealNode, nowDealNote,
            operator);
        // 处理之前节点
        refreshPreSYSBizLog(refType, refOrder, preDealNode);
    }

    // 最后操作记录日志
    @Override
    public void refreshPreSYSBizLog(EBizLogType refType, String refOrder,
            String dealNode) {
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

            sysBizLogDAO.updateSpeedtime(data);
        }
    }

    private SYSBizLog getSYSBizLoglatest(String refType, String refOrder,
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
}
