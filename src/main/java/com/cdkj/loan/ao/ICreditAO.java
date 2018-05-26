package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.dto.req.XN632114Req;
import com.cdkj.loan.dto.req.XN632115Req;

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

    // 修改征信信息 征信表和征信人员表
    public void editCredit(XN632112Req req);

    // 征信分页查询
    public Paginable<Credit> queryCreditPage(XN632115Req req);

    // 征信详情查询
    public Credit queryCreditDetail(String code);

    // 查询征信单 根据征信单编号
    public Credit queryCreditByCode(String creditCode);

    // 征信初审
    public void primaryAudit(XN632113Req req);

    // 征信一审
    public void firstAudit(XN632114Req req);

}
