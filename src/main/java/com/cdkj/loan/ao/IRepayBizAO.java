package com.cdkj.loan.ao;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630512Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.req.XN630550Req;
import com.cdkj.loan.dto.req.XN630556Req;
import com.cdkj.loan.dto.req.XN630557Req;
import com.cdkj.loan.dto.req.XN630563Req;

public interface IRepayBizAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editBankcardNew(XN630510Req req);

    public void editBankcardModify(XN630511Req req);

    // 管理端提前还款
    public void advanceRepayOss(XN630512Req req);

    // 前端提前还款(保留)
    // public void advanceRepay(String code, String updater, String remark);

    // ********************************car********************************

    // 申请拖车
    public void takeCarApply(XN630550Req req);

    // 拖车分控经理审核
    public void takeCarRiskManageCheck(String code, String approveResult,
            String operator, String remark);

    // 拖车分公司总公司审核
    public void takeCarCompanyManageCheck(String code, String approveResult,
            String operator, String remark);

    // 风控总监审核
    public void takeCarRiskLeaderCheck(String code, String approveResult,
            String operator, String remark);

    // 财务经理审核
    public void takeCarFinanceManageCheck(String code, String approveResult,
            String operator, String remark);

    // 确认放款
    public void takeCarSureFk(String code, String remitBankCode,
            String remitBillPdf, Date remitDatetime, String operator);

    // 录入拖车结果
    public void takeCarInputResult(XN630556Req req);

    // 结果处理
    public void takeCarResultHandle(XN630557Req req);

    // 司法诉讼财务收款
    public void judgeFinanceSureReceipt(XN630563Req req);

    // ********************************car********************************

    // ********************************product********************************

    public void enterBlackListProduct(String code, String blackHandleNote,
            String updater, String remark);

    public void confirmSettledProduct(XN630513Req req);

    // ********************************product********************************

    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition);

    public List<RepayBiz> queryRepayBizList(RepayBiz condition);

    public RepayBiz getRepayBiz(String code);

    public Paginable<RepayBiz> queryRepayBizPageByRoleCode(int start,
            int limit, RepayBiz condition);

}
