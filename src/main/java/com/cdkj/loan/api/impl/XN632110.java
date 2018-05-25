package com.cdkj.loan.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN632110 extends AProcessor {

    private ICreditAO creditAO = SpringContextHolder.getBean(ICreditAO.class);

    private XN632110Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        Credit data = new Credit();
        data.setLoanAmount(req.getLoanBank());
        data.setShopWay(req.getShopWay());
        data.setLoanAmount(req.getLoanAmount());
        data.setXszFront(req.getXszFront());
        data.setXszReverse(req.getXszReverse());

        List<CreditUser> dataList = new ArrayList<CreditUser>();
        for (CreditUser creditUser : req.getCreditUserList()) {
            CreditUser a = new CreditUser();
            a.setUserName(creditUser.getUserName());
            a.setRelation(creditUser.getRelation());
            a.setLoanRole(creditUser.getLoanRole());
            a.setIdNo(creditUser.getIdNo());
            a.setMobile(creditUser.getMobile());
            a.setAuthPdf(creditUser.getAuthPdf());
            a.setInterviewPic(creditUser.getInterviewPic());
            dataList.add(a);
        }

        return new PKCodeRes(creditAO.addCredit(data, dataList));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632110Req.class);
        ObjValidater.validateReq(req);

    }

}
