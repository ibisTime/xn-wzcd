package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IBudgetOrderGpsDAO;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBudgetOrderGpsStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class BudgetOrderGpsBOImpl extends PaginableBOImpl<BudgetOrderGps>
        implements IBudgetOrderGpsBO {

    @Autowired
    private IBudgetOrderGpsDAO budgetOrderGpsDAO;

    @Autowired
    private IGpsBO gpsBO;

    public String saveBudgetOrderGps(BudgetOrderGps data) {
        String code = null;
        if (data != null) {
            budgetOrderGpsDAO.insert(data);
        }
        return code;
    }

    @Override
    public void saveBudgetOrderGpsList(String budgetOrder, List<String> gpsList) {
        if (CollectionUtils.isNotEmpty(gpsList)) {
            for (String gpsCode : gpsList) {
                BudgetOrderGps data = new BudgetOrderGps();
                Gps gps = gpsBO.getGps(gpsCode);
                data.setCode(gps.getCode());
                data.setGpsDevNo(gps.getGpsDevNo());
                data.setGpsType(gps.getGpsType());
                data.setStatus(EBudgetOrderGpsStatus.USE_ING.getCode());
                data.setBudgetOrder(budgetOrder);
                saveBudgetOrderGps(data);

                // 更新gps使用状态为使用中
                gpsBO.refreshUseGps(gpsCode, budgetOrder);
            }
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "gps安装列表为空！");
        }
    }

    @Override
    public int removeBudgetOrderGps(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrderGps data = new BudgetOrderGps();
            data.setCode(code);
            count = budgetOrderGpsDAO.delete(data);
        }
        return count;
    }

    @Override
    public void removeBudgetOrderGpsList(String budgetOrderCode) {
        BudgetOrderGps condition = new BudgetOrderGps();
        condition.setBudgetOrder(budgetOrderCode);
        List<BudgetOrderGps> queryBudgetOrderGpsList = queryBudgetOrderGpsList(condition);
        for (BudgetOrderGps budgetOrderGps : queryBudgetOrderGpsList) {
            budgetOrderGpsDAO.delete(budgetOrderGps);
            // 更新gps使用状态为未使用
            gpsBO.refreshUnUse(budgetOrderGps.getCode());
        }
    }

    @Override
    public void abandonBudgetOrderGps(BudgetOrderGps data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderGpsDAO.updateAbandonBudgetOrderGps(data);
        }
    }

    @Override
    public List<BudgetOrderGps> queryBudgetOrderGpsList(String budgetOrder) {
        BudgetOrderGps condition = new BudgetOrderGps();
        condition.setBudgetOrder(budgetOrder);
        return budgetOrderGpsDAO.selectList(condition);
    }

    @Override
    public List<BudgetOrderGps> queryBudgetOrderGpsList(BudgetOrderGps condition) {
        return budgetOrderGpsDAO.selectList(condition);
    }

    @Override
    public BudgetOrderGps getBudgetOrderGps(String code) {
        BudgetOrderGps data = null;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrderGps condition = new BudgetOrderGps();
            condition.setCode(code);
            data = budgetOrderGpsDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "gps安装不存在");
            }
        }
        return data;
    }

}
