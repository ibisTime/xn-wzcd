package com.cdkj.loan.ao;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.req.XN630551Req;

public interface IRepayBizAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editBankcardNew(XN630510Req req);

    public void editBankcardModify(XN630511Req req);

    // 提前还款，车贷和商品分期都有
    public void advanceRepay(String code, String updater, String remark);

    // 清欠催收部审核
    public void approveByQkcsDepart(String code, Long cutLyDeposit,
            String updater, String remark);

    // 驻行人员审核
    public void approveByBankCheck(XN630551Req req);

    // 总经理审核
    public void approveByManager(String code, String approveResult,
            String updater, String remark);

    // 财务审核
    public void approveByFinance(String code, String approveResult,
            String updater, String remark);

    // 业务团队解除抵押
    public void releaseMortgage(String code, Date releaseDatetime,
            String updater);
    // ********************************car********************************

    public void enterBlackListProduct(String code, String blackHandleNote,
            String updater, String remark);

    public void confirmSettledProduct(XN630513Req req);

    // ********************************car********************************

    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition);

    public List<RepayBiz> queryRepayBizList(RepayBiz condition);

    public RepayBiz getRepayBiz(String code);

}
