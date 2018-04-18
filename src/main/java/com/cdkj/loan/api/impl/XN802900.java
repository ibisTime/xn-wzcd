/**
 * @Title XN802900.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年12月7日 上午10:21:31 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import java.math.BigDecimal;

import com.cdkj.loan.ao.IAccountAO;
import com.cdkj.loan.ao.IEthAddressAO;
import com.cdkj.loan.ao.IEthCollectionAO;
import com.cdkj.loan.ao.IWithdrawAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.dto.res.XN802900Res;
import com.cdkj.loan.enums.EEthAddressType;
import com.cdkj.loan.enums.ESystemAccount;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * @author: haiqingzheng 
 * @since: 2017年12月7日 上午10:21:31 
 * @history:
 */
public class XN802900 extends AProcessor {
    private IEthAddressAO ethAddressAO = SpringContextHolder
        .getBean(IEthAddressAO.class);

    private IEthCollectionAO ethCollectionAO = SpringContextHolder
        .getBean(IEthCollectionAO.class);

    private IWithdrawAO withdrawAO = SpringContextHolder
        .getBean(IWithdrawAO.class);

    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        XN802900Res res = new XN802900Res();
        // 散取钱包总额
        BigDecimal toWithdrawCount = ethAddressAO
            .getTotalBalance(EEthAddressType.M);
        // 客户未归集总额
        BigDecimal toCollectCount = ethAddressAO
            .getTotalBalance(EEthAddressType.X);
        // 历史总归集
        BigDecimal totolCollectCount = ethCollectionAO.getTotalCollect();
        // 历史总取现
        BigDecimal totolWithdrawCount = withdrawAO.getTotalWithdraw();
        // 冷钱包余额
        BigDecimal coldCount = accountAO.getAccount(
            ESystemAccount.SYS_ACOUNT_ETH_COLD.getCode()).getAmount();
        // 盈亏账户余额
        BigDecimal platCount = accountAO.getAccount(
            ESystemAccount.SYS_ACOUNT_ETH.getCode()).getAmount();
        res.setToWithdrawCount(toWithdrawCount.toString());
        res.setToCollectCount(toCollectCount.toString());
        res.setTotolCollectCount(totolCollectCount.toString());
        res.setTotolWithdrawCount(totolWithdrawCount.toString());
        res.setTotalCount(coldCount.add(toCollectCount).add(toWithdrawCount)
            .toString());
        res.setColdCount(coldCount.toString());
        res.setPlatCount(platCount.toString());
        return res;
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

    }

}
