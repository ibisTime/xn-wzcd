/**
 * @Title XN805205.java 
 * @Package com.std.user.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年8月23日 下午2:53:59 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBlacklistAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805201Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 移除黑名单
 * @author: haiqingzheng 
 * @since: 2017年8月23日 下午2:53:59 
 * @history:
 */
public class XN805201 extends AProcessor {

    private IBlacklistAO blacklistAO = SpringContextHolder
        .getBean(IBlacklistAO.class);

    private XN805201Req req = null;

    /** 
     * @see com.std.user.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return blacklistAO.dropBlacklist(StringValidater.toLong(req.getId()),
            req.getUpdater(), req.getRemark());
    }

    /** 
     * @see com.std.user.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805201Req.class);
        StringValidater.validateBlank(req.getId(), req.getUpdater());
    }

}
