package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IWelfareApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IWelfareApplyDAO;
import com.cdkj.loan.domain.WelfareApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午6:58:20 
 * @history:
 */
@Component
public class WelfareApplyBOImpl extends PaginableBOImpl<WelfareApply>
        implements IWelfareApplyBO {

    @Autowired
    private IWelfareApplyDAO WelfareApplyDAO;

    @Override
    public boolean isWelfareApplyExist(String code) {
        WelfareApply condition = new WelfareApply();
        condition.setCode(code);
        if (WelfareApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveWelfareApply(WelfareApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.WELFARE_APPLY.getCode());
            data.setCode(code);
            WelfareApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshWelfareApply(WelfareApply data) {
        if (null != data) {
            WelfareApplyDAO.update(data);
        }
    }

    @Override
    public List<WelfareApply> queryWelfareApplyList(WelfareApply condition) {
        return WelfareApplyDAO.selectList(condition);
    }

    @Override
    public WelfareApply getWelfareApply(String code) {
        WelfareApply data = null;
        if (StringUtils.isNotBlank(code)) {
            WelfareApply condition = new WelfareApply();
            condition.setCode(code);
            data = WelfareApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }
        }
        return data;
    }
}
