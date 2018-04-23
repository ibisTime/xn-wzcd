/**
 * @Title XNlh5034.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年6月12日 下午1:36:16 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSConfigAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630047Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 根据key获取value值
 * @author: haiqingzheng 
 * @since: 2016年6月12日 下午1:36:16 
 * @history:
 */
public class XN630047 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN630047Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return sysConfigAO.getSYSConfig(req.getKey());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630047Req.class);
        ObjValidater.validateReq(req);
    }

}
