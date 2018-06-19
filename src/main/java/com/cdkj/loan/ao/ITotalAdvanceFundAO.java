package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.TotalAdvanceFund;
import com.cdkj.loan.dto.req.XN632174Req;
import com.cdkj.loan.dto.req.XN632176Req;
import com.cdkj.loan.dto.req.XN632233Req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月17日 上午11:23:42 
 * @history:
 */
@Component
public interface ITotalAdvanceFundAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 分公司制单
    public void addTotalAdvanceFund(XN632174Req req);

    public int dropTotalAdvanceFund(String code);

    public int editTotalAdvanceFund(TotalAdvanceFund data);

    public Paginable<TotalAdvanceFund> queryTotalAdvanceFundPage(int start,
            int limit, TotalAdvanceFund condition);

    public List<TotalAdvanceFund> queryTotalAdvanceFundList(
            TotalAdvanceFund condition);

    public TotalAdvanceFund getTotalAdvanceFund(String code);

    // 确认打款给分公司
    public String confirmPayBranchCompany(XN632176Req req);

    // 财务审核
    public void financeConfirm(XN632233Req req);

}
