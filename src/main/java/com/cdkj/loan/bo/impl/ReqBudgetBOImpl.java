package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IReqBudgetDAO;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class ReqBudgetBOImpl extends PaginableBOImpl<ReqBudget> implements
        IReqBudgetBO {

    @Autowired
    private IReqBudgetDAO reqBudgetDAO;

    public String saveReqBudget(ReqBudget data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.REQBUDGET
                .getCode());
            data.setCode(code);
            reqBudgetDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeReqBudget(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ReqBudget data = new ReqBudget();
            data.setCode(code);
            count = reqBudgetDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshReqBudget(ReqBudget data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = reqBudgetDAO.update(data);
        }
        return count;
    }

    @Override
    public int refreshReqBudgetNode(ReqBudget data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = reqBudgetDAO.updateNode(data);
        }
        return count;
    }

    @Override
    public int loan(ReqBudget data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = reqBudgetDAO.loan(data);
        }
        return count;
    }

    @Override
    public List<ReqBudget> queryReqBudgetList(ReqBudget condition) {
        return reqBudgetDAO.selectList(condition);
    }

    @Override
    public ReqBudget getReqBudget(String code) {
        ReqBudget data = null;
        if (StringUtils.isNotBlank(code)) {
            ReqBudget condition = new ReqBudget();
            condition.setCode(code);
            data = reqBudgetDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请款预算单不存在!");
            }
        }
        return data;
    }

    @Override
    public Paginable<ReqBudget> getPaginableByRoleCode(int start, int pageSize,
            ReqBudget condition) {
        prepare(condition);

        long totalCount = reqBudgetDAO.selectTotalCountByRoleCode(condition);

        Paginable<ReqBudget> page = new Page<ReqBudget>(start, pageSize,
            totalCount);

        List<ReqBudget> dataList = reqBudgetDAO.selectReqBudgetByRoleCodeList(
            condition, page.getStart(), page.getPageSize());

        page.setList(dataList);
        return page;
    }

    @Override
    public int collectionReqBudget(ReqBudget data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = reqBudgetDAO.collectionReqBudget(data);
        }
        return count;
    }

    @Override
    public ReqBudget getTodayReqBudget(String companyCode) {
        ReqBudget data = null;
        if (StringUtils.isNotBlank(companyCode)) {
            ReqBudget condition = new ReqBudget();
            condition.setCompanyCode(companyCode);
            condition.setPayDatetimeStart(DateUtil.getTodayStart());
            condition.setPayDatetimeEnd(DateUtil.getTodayEnd());
            data = reqBudgetDAO.selectTodayReqBudget(condition);
        }
        return data;
    }
}
