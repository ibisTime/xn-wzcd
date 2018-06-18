package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IGpsApplyDAO;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EGpsApplyStatus;
import com.cdkj.loan.exception.BizException;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:13:32 
 * @history:
 */
@Component
public class GpsApplyBOImpl extends PaginableBOImpl<GpsApply> implements
        IGpsApplyBO {

    @Autowired
    private IGpsApplyDAO gpsApplyDAO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String saveGpsApply(GpsApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.GPS_APPLY
                .getCode());
            data.setCode(code);
            gpsApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void approveCompanyGpsApply(GpsApply gpsApply, String approveResult,
            String approveUser, String approveNote) {
        if (null != gpsApply) {
            if (EBoolean.YES.getCode().equals(approveResult)) {
                gpsApply.setStatus(EGpsApplyStatus.APPROVE_YES.getCode());
            } else {
                gpsApply.setStatus(EGpsApplyStatus.APPROVE_NO.getCode());
            }
            gpsApply.setApproveUser(approveUser);
            gpsApply.setApproveNote(approveNote);
            gpsApplyDAO.updateGpsApplyApprove(gpsApply);
        }
    }

    @Override
    public void approveUserGpsApply(GpsApply gpsApply, String approveResult,
            String approveUser, String approveNote) {
        if (null != gpsApply) {
            if (EBoolean.YES.getCode().equals(approveResult)) {
                gpsApply.setStatus(EGpsApplyStatus.RECEIVED.getCode());
            } else {
                gpsApply.setStatus(EGpsApplyStatus.APPROVE_NO.getCode());
            }
            gpsApply.setApproveUser(approveUser);
            gpsApply.setApproveNote(approveNote);
            gpsApplyDAO.updateGpsApplyApprove(gpsApply);
        }
    }

    @Override
    public void sendGps(String code, Date sendDatetime) {
        GpsApply data = new GpsApply();
        data.setCode(code);
        data.setStatus(EGpsApplyStatus.TO_RECEIVE.getCode());
        data.setSendDatetime(sendDatetime);
        gpsApplyDAO.updateGpsApplySend(data);
    }

    @Override
    public void receiveGps(String code) {
        // 更新申请单，状态更新已收件
        GpsApply data = getGpsApply(code);
        data.setStatus(EGpsApplyStatus.RECEIVED.getCode());
        data.setReceiveDatetime(new Date());
        gpsApplyDAO.updateGpsApplyReceive(data);

        // gps领用状态更改
        Gps condition = new Gps();
        condition.setApplyCode(code);
        List<Gps> gpsList = gpsBO.queryGpsList(condition);
        for (Gps gps : gpsList) {
            gpsBO.receiveCompanyGps(gps.getCode());
        }
    }

    @Override
    public List<GpsApply> queryGpsApplyList(GpsApply condition) {
        return gpsApplyDAO.selectList(condition);
    }

    @Override
    public GpsApply getGpsApply(String code) {
        GpsApply data = null;
        if (StringUtils.isNotBlank(code)) {
            GpsApply condition = new GpsApply();
            condition.setCode(code);
            data = gpsApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "GPS申领不存在");
            }
        }
        return data;
    }
}
