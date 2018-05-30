package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632128Req;

@Component
public interface IBudgetOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 填写准入申请单
    public String addBudgetOrder(XN632120Req req);

    // 风控专员审核
    public void riskApprove(String code, String approveResult,
            String approveNote, String operator);

    // 风控主管审核
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote);

    // 面签
    public void interview(String code, String interviewVideo,
            String interviewContract, String operator);

    // 业务总监审核
    public void bizChargeApprove(String code, String operator,
            String approveResult, String approveNote);

    // 财务确认垫资
    public void advanceFund(String code, String operator,
            String advanceFundDatetime, String advanceFundAmount, String billPdf);

    // 安装GPS
    public void installGps(String code, String operator,
            List<XN632126ReqGps> gpsAzList);

    // GPS管理员审核
    public void gpsManagerApprove(String code, String operator,
            String approveResult, String approveNote);

    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    // 车辆落户
    public void carSettle(XN632128Req req);

    // 确认提交银行
    public void commitBank(String code, String operator,
            String bankCommitDatetime, String bankCommitNote);

    // 确定入档
    public void archive(String code, String operator, String enterLocation);

}
