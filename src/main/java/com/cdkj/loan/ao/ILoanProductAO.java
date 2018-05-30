package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.dto.req.XN632170Req;
import com.cdkj.loan.dto.req.XN632172Req;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:46:28 
 * @history:
 */
public interface ILoanProductAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 添加贷款产品
    public String saveLoanProduct(XN632170Req req);

    // 删除贷款产品
    public void dropLoanProduct(String code);

    // 编辑贷款产品
    public void editLoanProduct(XN632172Req req);

    // 上架
    public void publishYesLoanProduct(String code, String updater);

    // 下架
    public void publishNoLoanProduct(String code, String updater);

    // 分页查
    public Paginable<LoanProduct> queryLoanProductPage(int start, int limit,
            LoanProduct condition);

    // 列表查
    public List<LoanProduct> queryLoanProductList(LoanProduct condition);

    // 详细查
    public LoanProduct getLoanProduct(String code);
}
