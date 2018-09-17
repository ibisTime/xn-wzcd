package com.cdkj.loan.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630094Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

import demo.AbstractCredit;
import demo.MobileReportDemo;

/**
 * 身份证实名认证
 * @author: CYL 
 * @since: 2018年9月17日 上午10:58:27 
 * @history:
 */
public class XN630094 extends AProcessor {
    private MobileReportDemo mobileReportDemo = SpringContextHolder
        .getBean(MobileReportDemo.class);

    private XN630094Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam.add(new BasicNameValuePair("apiKey", AbstractCredit.apiKey));
        reqParam.add(new BasicNameValuePair("method", AbstractCredit.method));
        reqParam.add(new BasicNameValuePair("version", AbstractCredit.version));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(
            new BasicNameValuePair("sign", mobileReportDemo.getSign(reqParam)));// 请求参数签名
        try {
            mobileReportDemo.doProcess(reqParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630094Req.class);
        ObjValidater.validateReq(req);
    }
}
