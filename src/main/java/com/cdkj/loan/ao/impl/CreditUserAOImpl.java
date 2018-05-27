package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632111ReqChild;
import com.cdkj.loan.dto.req.XN632118Req;
import com.cdkj.loan.enums.ECreditNode;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:51:03 
 * @history:
 */
@Service
public class CreditUserAOImpl implements ICreditUserAO {

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private INodeBO nodeBO;

    @Autowired
    private ICreditAO creditAO;

    @Autowired
    private ICreditBO creditBO;

    // 录入银行征信结果
    @Override
    public void inputBankCreditResult(XN632111Req req) {
        String operator = req.getOprerator();

        List<XN632111ReqChild> list = req.getBankCreditResultList();

        for (XN632111ReqChild Child : list) {
            CreditUser creditUser = new CreditUser();

            creditUser.setCode(Child.getCode());

            creditUser.setDkdyCount(StringValidater.toInteger(Child
                .getDkdyCount()));
            creditUser.setDkdyAmount(StringValidater.toLong(Child
                .getDkdyAmount()));
            creditUser.setDkdy2YearOverTimes(StringValidater.toInteger(Child
                .getDkdy2yearOverTimes()));
            creditUser.setDkdyMaxOverAmount(StringValidater.toLong(Child
                .getDkdyMaxOverAmount()));
            creditUser.setDkdyCurrentOverAmount(StringValidater.toLong(Child
                .getDkdyCurrentOverAmount()));
            creditUser.setDkdy6MonthAvgAmount(StringValidater.toLong(Child
                .getDkdy6monthAvgAmount()));

            creditUser.setHkxyUnsettleCount(StringValidater.toInteger(Child
                .getHkxyUnsettleCount()));
            creditUser.setHkxyUnsettleAmount(StringValidater.toLong(Child
                .getHkxyUnsettleAmount()));
            creditUser.setHkxy2YearOverTimes(StringValidater.toInteger(Child
                .getHkxy2yearOverTimes()));
            creditUser.setHkxyMonthMaxOverAmount(StringValidater.toLong(Child
                .getHkxyMonthMaxOverAmount()));
            creditUser.setHkxy6MonthAvgAmount(StringValidater.toLong(Child
                .getHkxy6monthAvgAmount()));
            creditUser.setHkxyCurrentOverAmount(StringValidater.toLong(Child
                .getHkxyCurrentOverAmount()));

            creditUser.setXykCount(StringValidater.toInteger(Child
                .getXykCount()));
            creditUser.setXykCreditAmount(StringValidater.toLong(Child
                .getXykCreditAmount()));
            creditUser.setXyk6MonthUseAmount(StringValidater.toLong(Child
                .getXyk6monthUseAmount()));
            creditUser.setXyk2YearOverTimes(StringValidater.toInteger(Child
                .getXyk2yearOverTimes()));
            creditUser.setXykMonthMaxOverAmount(StringValidater.toLong(Child
                .getXykMonthMaxOverAmount()));
            creditUser.setXykCurrentOverAmount(StringValidater.toLong(Child
                .getXykCurrentOverAmount()));

            creditUser.setOutGuaranteesCount(StringValidater.toInteger(Child
                .getOutGuaranteesCount()));
            creditUser.setOutGuaranteesAmount(StringValidater.toLong(Child
                .getOutGuaranteesAmount()));
            creditUser.setOutGuaranteesRemark(Child.getOutGuaranteesRemark());

            creditUserBO.inputBankCreditResult(creditUser);
        }

        Credit credit = creditAO.queryCreditByCode(req.getCreditCode());
        credit.setCurNodeCode(nodeBO.getNode(ECreditNode.LRZXY.getCode())
            .getNextNode());
        creditBO.refreshCreditNode(credit);

    }

    // 查看征信报告详情
    @Override
    public CreditUser queryCreditReportDetail(XN632118Req req) {

        return creditUserBO.queryCreditReportDetail(req.getCode());
    }
}
