package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632113Req;

/**
 * 征信
 * @author: jiafr 
 * @since: 2018年5月24日 下午11:05:31 
 * @history:
 */
public interface ICreditAO {

    String DEFAULT_ORDER_COLUMN = "code";

    // 新增征信 和 征信人员列表
    public String addCredit(XN632110Req req);

    // 修改征信信息 征信和征信人员
    public void editCredit(XN632112Req req);

    // 查询征信单
    public Credit getCredit(String Code);

    // 查询征信详情 征信单和征信人员列表
    public Credit getCreditAndCreditUser(String code);

    // 征信分页查询
    public Paginable<Credit> queryCreditPage(int start, int limit,
            Credit condition);

    // 征信分页查询 按角色权限
    public Paginable<Credit> queryCreditPageByRoleCode(int start, int limit,
            Credit condition);

    // 征信初审
    public void audit(XN632113Req req);

    // 录入银行征信结果
    public void inputBankCreditResult(XN632111Req req);

}
