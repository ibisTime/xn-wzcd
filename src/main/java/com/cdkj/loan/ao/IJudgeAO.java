package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.dto.req.XN630560Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.dto.req.XN630564Req;
import com.cdkj.loan.dto.req.XN630565Req;
import com.cdkj.loan.dto.req.XN630566Req;
import com.cdkj.loan.dto.req.XN630567Req;
import com.cdkj.loan.dto.req.XN630568Req;
import com.cdkj.loan.dto.req.XN630569Req;
import com.cdkj.loan.dto.req.XN630580Req;
import com.cdkj.loan.dto.req.XN630581Req;
import com.cdkj.loan.dto.req.XN630582Req;
import com.cdkj.loan.dto.req.XN630583Req;

@Component
public interface IJudgeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 司法诉讼录入
    public String judgeApply(XN630560Req req);

    // 财务审核
    public void judgeFinanceCheck(XN630564Req req);

    // 出纳打款
    public void cashier(XN630565Req req);

    // 执行结果录入
    public void judgeResultInput(XN630562Req req);

    // 重新申请执行
    public void resultInputAgain(String code, String operator);

    public Paginable<Judge> queryJudgePage(int start, int limit,
            Judge condition);

    public List<Judge> queryJudgeList(Judge condition);

    public Judge getJudge(String code);

    // 受理
    public void acceptance(XN630566Req req);

    // 开庭
    public void toHoldCourt(XN630567Req req);

    // 判决
    public void sentence(XN630568Req req);

    // 生效
    public void takeEffect(XN630569Req req);

    // 申请执行
    public void applyImplement(XN630580Req req);

    // 执行案件：案件受理
    public void implementAdmissibility(XN630581Req req);

    // 执行案件：拍卖
    public void auction(XN630582Req req);

    // 执行案件：公告
    public void notice(XN630583Req req);

}
