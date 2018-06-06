package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISuppleSignApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ISuppleSignApplyDAO;
import com.cdkj.loan.domain.SuppleSignApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 补签
 * @author: silver 
 * @since: 2018年6月5日 下午10:56:15 
 * @history:
 */
@Component
public class SuppleSignApplyBOImpl extends PaginableBOImpl<SuppleSignApply>
        implements ISuppleSignApplyBO {

    @Autowired
    private ISuppleSignApplyDAO suppleSignApplyDAO;

    @Override
    public boolean isSuppleSignApplyExist(String code) {
        SuppleSignApply condition = new SuppleSignApply();
        condition.setCode(code);
        if (suppleSignApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveSuppleSignApply(SuppleSignApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.SUPPLE_SIGN_APPLY.getCode());
            data.setCode(code);
            suppleSignApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshSuppleSignApply(SuppleSignApply data) {
        if (null != data) {
            suppleSignApplyDAO.update(data);
        }
    }

    @Override
    public List<SuppleSignApply> querySuppleSignApplyList(
            SuppleSignApply condition) {
        return suppleSignApplyDAO.selectList(condition);
    }

    @Override
    public SuppleSignApply getSuppleSignApply(String code) {
        SuppleSignApply data = null;
        if (StringUtils.isNotBlank(code)) {
            SuppleSignApply condition = new SuppleSignApply();
            condition.setCode(code);
            data = suppleSignApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "补签记录不存在！");
            }
        }
        return data;
    }
}
