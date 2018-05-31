package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBudgetOrderGpsDAO;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
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
            code = OrderNoGenerater.generate(EGeneratePrefix.GPSAZ.getCode());
            data.setCode(code);
            budgetOrderGpsDAO.insert(data);
        }
        return code;
    }

    @Override
    public void saveBudgetOrderGpsList(String code,
            List<XN632126ReqGps> gpsAzList) {
        if (CollectionUtils.isNotEmpty(gpsAzList)) {
            for (XN632126ReqGps reqGps : gpsAzList) {
                String psCode = OrderNoGenerater.generate(EGeneratePrefix.GPSAZ
                    .getCode());
                BudgetOrderGps data = new BudgetOrderGps();
                data.setCode(psCode);
                data.setGpsDevNo(reqGps.getGpsDevNo());
                String gpsType = gpsBO.getGpsByDevNo(reqGps.getGpsDevNo())
                    .getGpsType();
                data.setGpsType(gpsType);
                data.setAzLocation(reqGps.getAzLocation());
                data.setAzDatetime(reqGps.getAzDatetime());
                data.setAzUser(reqGps.getAzUser());
                data.setRemark(reqGps.getRemark());
                data.setBudgetOrder(code);
                saveBudgetOrderGps(data);
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
    public void removeBudgetOrderGpsList(String code) {
        BudgetOrderGps condition = new BudgetOrderGps();
        condition.setBudgetOrder(code);
        List<BudgetOrderGps> queryBudgetOrderGpsList = queryBudgetOrderGpsList(condition);
        for (BudgetOrderGps budgetOrderGps : queryBudgetOrderGpsList) {
            budgetOrderGpsDAO.delete(budgetOrderGps);
        }
    }

    @Override
    public int refreshBudgetOrderGps(BudgetOrderGps data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = budgetOrderGpsDAO.update(data);
        }
        return count;
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
                    "gps安装编号不存在");
            }
        }
        return data;
    }

}