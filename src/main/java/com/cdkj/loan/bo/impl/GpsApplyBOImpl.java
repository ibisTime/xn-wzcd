package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IGpsApplyDAO;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:13:32 
 * @history:
 */
@Component
public class GpsApplyBOImpl extends PaginableBOImpl<GpsApply>
        implements IGpsApplyBO {

    @Autowired
    private IGpsApplyDAO gpsApplyDAO;

    @Override
    public boolean isGpsApplyExist(String code) {
        GpsApply condition = new GpsApply();
        condition.setCode(code);
        if (gpsApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveGpsApply(GpsApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.GPS_APPLY.getCode());
            data.setCode(code);
            gpsApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void approveGpsApply(GpsApply data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            gpsApplyDAO.updateGpsApplyApprove(data);
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
                throw new BizException("xn0000", "GPS申领记录不存在");
            }
        }
        return data;
    }
}
