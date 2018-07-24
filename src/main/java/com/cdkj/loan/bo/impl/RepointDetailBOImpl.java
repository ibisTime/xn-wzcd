package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepointDetailBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepointDetailDAO;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月16日 下午2:45:14 
 * @history:
 */
@Component
public class RepointDetailBOImpl extends PaginableBOImpl<RepointDetail>
        implements IRepointDetailBO {

    @Autowired
    private IRepointDetailDAO repointDetailDAO;

    @Override
    public boolean isRepointDetailExist(String code) {
        RepointDetail condition = new RepointDetail();
        condition.setCode(code);
        if (repointDetailDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRepointDetail(RepointDetail data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.REPOINT_DETAIL
                .getCode());
            data.setCode(code);
            repointDetailDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRepointDetail(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            RepointDetail data = new RepointDetail();
            data.setCode(code);
            count = repointDetailDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRepointDetail(RepointDetail data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = repointDetailDAO.update(data);
        }
        return count;
    }

    @Override
    public List<RepointDetail> queryRepointDetailList(RepointDetail condition) {
        return repointDetailDAO.selectList(condition);
    }

    @Override
    public List<RepointDetail> queryRepointDetailList(String budgetOrder,
            String useMoneyPurpose) {
        RepointDetail condition = new RepointDetail();
        condition.setBudgetCode(budgetOrder);
        condition.setUseMoneyPurpose(useMoneyPurpose);
        return repointDetailDAO.selectList(condition);
    }

    @Override
    public RepointDetail getRepointDetail(String code) {
        RepointDetail data = null;
        if (StringUtils.isNotBlank(code)) {
            RepointDetail condition = new RepointDetail();
            condition.setCode(code);
            data = repointDetailDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "返点明细数据不存在");
            }
        }
        return data;
    }

    @Override
    public void updateCurNodeCode(RepointDetail data) {
        if (null != data) {
            repointDetailDAO.updateCurNodeCode(data);
        }
    }

    @Override
    public void delete(String budgetOrderCode) {

        if (StringUtils.isNotBlank(budgetOrderCode)) {
            RepointDetail data = new RepointDetail();
            data.setBudgetCode(budgetOrderCode);
            repointDetailDAO.delete(data);
        }

    }

    @Override
    public void deletePreRepointDetail(String budgetOrderCode, String type) {
        if (StringUtils.isNotBlank(budgetOrderCode)
                && StringUtils.isNotBlank(type)) {
            RepointDetail data = new RepointDetail();
            data.setBudgetCode(budgetOrderCode);
            data.setType(type);
            repointDetailDAO.deletePreRepointDetail(data);
        }
    }

    @Override
    public void updateRepointDetailType(RepointDetail data) {
        if (null != data) {
            repointDetailDAO.updateRepointDetailType(data);
        }
    }

    @Override
    public List<RepointDetail> queryRepointDetailListByCarDealerCode(
            RepointDetail condition) {
        return repointDetailDAO.selectList(condition);
    }

    @Override
    public void deleteRepointDetailByBudgetOrderCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            RepointDetail data = new RepointDetail();
            data.setBudgetCode(code);
            repointDetailDAO.delete(data);
        }
    }
}
