package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.bo.ICUserBO;
import com.cdkj.loan.bo.ILoanOrderBO;
import com.cdkj.loan.bo.IOrderBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.enums.ERepayBizType;

@Service
public class RepayBizAOImpl implements IRepayBizAO {

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IBankcardAO bankcardAO;

    @Autowired
    private ICUserBO cUserBO;

    @Autowired
    private ILoanOrderBO loanOrderBO;

    @Autowired
    private IOrderBO orderBO;

    @Override
    public void editBankcardNew(XN630510Req req) {
        String code = bankcardAO.addBankcard(req);
        repayBizBO.refreshBankcardNew(req.getCode(), code, req.getUpdater(),
            req.getRemark());
    }

    @Override
    public void editBankcardModify(XN630511Req req) {
        repayBizBO.refreshBankcardModify(req.getCode(), req.getBankcardCode(),
            req.getUpdater(), req.getRemark());
    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition) {
        Paginable<RepayBiz> results = repayBizBO.getPaginable(start, limit,
            condition);
        for (RepayBiz repayBiz : results.getList()) {
            setRefInfo(repayBiz);
        }
        return results;
    }

    @Override
    public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
        return repayBizBO.queryRepayBizList(condition);
    }

    @Override
    public RepayBiz getRepayBiz(String code) {

        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);

        setRefInfo(repayBiz);

        return repayBiz;
    }

    /** 
     * @param repayBiz 
     * @create: 2018年5月6日 下午5:11:12 haiqingzheng
     * @history: 
     */
    private void setRefInfo(RepayBiz repayBiz) {

        repayBiz.setUser(cUserBO.getUser(repayBiz.getUserId()));

        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
            repayBiz
                .setLoanOrder(loanOrderBO.getLoanOrder(repayBiz.getRefCode()));
        } else {
            repayBiz.setMallOrder(orderBO.getOrder(repayBiz.getRefCode()));
        }

    }
}
