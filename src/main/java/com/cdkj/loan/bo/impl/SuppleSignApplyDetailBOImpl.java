package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISuppleSignApplyDetailBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.dao.ISuppleSignApplyDetailDAO;
import com.cdkj.loan.domain.SuppleSignApplyDetail;
import com.cdkj.loan.exception.BizException;

/**
 * 补签细节
 * @author: silver 
 * @since: 2018年6月6日 下午1:59:58 
 * @history:
 */
@Component
public class SuppleSignApplyDetailBOImpl
        extends PaginableBOImpl<SuppleSignApplyDetail>
        implements ISuppleSignApplyDetailBO {

    @Autowired
    private ISuppleSignApplyDetailDAO suppleSignApplyDetailDAO;

    @Override
    public void saveSuppleSignApplyDetail(String suppleSignApplyCode,
            String suppleDatetime, String remark) {
        SuppleSignApplyDetail data = new SuppleSignApplyDetail();
        data.setSupplySignApplyCode(suppleSignApplyCode);
        data.setSuppleDatetime(
            DateUtil.strToDate(suppleDatetime, DateUtil.DATA_TIME_PATTERN_1));
        data.setRemark(remark);
        suppleSignApplyDetailDAO.insert(data);
    }

    @Override
    public List<SuppleSignApplyDetail> querySuppleSignApplyDetailList(
            SuppleSignApplyDetail condition) {
        return suppleSignApplyDetailDAO.selectList(condition);
    }

    @Override
    public SuppleSignApplyDetail getSuppleSignApplyDetail(
            String suppleSignApplyCode) {
        SuppleSignApplyDetail data = null;
        if (StringUtils.isNotBlank(suppleSignApplyCode)) {
            SuppleSignApplyDetail condition = new SuppleSignApplyDetail();
            condition.setSupplySignApplyCode(suppleSignApplyCode);
            data = suppleSignApplyDetailDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "明细不存在！");
            }
        }
        return data;
    }
}
