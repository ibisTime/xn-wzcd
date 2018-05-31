/**
 * @Title XN802900.java 
 * @Package com.cdkj.loan.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2018年6月1日 上午4:34:31 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.loan.ao.IAccountAO;
import com.cdkj.loan.ao.IJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.dto.req.XN802900Req;
import com.cdkj.loan.dto.res.XN802503Res;
import com.cdkj.loan.dto.res.XN802900Res;
import com.cdkj.loan.enums.EBizType;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EJourBizTypeUser;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 统计充值、提现、消费总额
 * @author: haiqingzheng 
 * @since: 2018年6月1日 上午4:34:31 
 * @history:
 */
public class XN802900 extends AProcessor {

    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN802900Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {

        XN802900Res res = new XN802900Res();

        XN802503Res xn802503Res = accountAO.getAccountByUserId(req.getUserId(),
            ECurrency.CNY.getCode());
        if (CollectionUtils.isNotEmpty(xn802503Res.getAccountList())) {
            Account cnyAccount = xn802503Res.getAccountList().get(0);

            res.setTotalCharge(jourAO
                .getTotalAmount(EJourBizTypeUser.AJ_CHARGE.getCode(), null,
                    cnyAccount.getAccountNumber(), null, null)
                .longValue());

            res.setTotalWithdraw(
                jourAO
                    .getTotalAmount(EJourBizTypeUser.AJ_WITHDRAW.getCode(),
                        null, cnyAccount.getAccountNumber(), null, null)
                    .longValue());

            res.setTotalConsume(jourAO.getTotalAmount(EBizType.AJ_GW.getCode(),
                null, cnyAccount.getAccountNumber(), null, null).longValue());

        }

        return res;
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String, java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802900Req.class);
        ObjValidater.validateReq(req);
    }

}
