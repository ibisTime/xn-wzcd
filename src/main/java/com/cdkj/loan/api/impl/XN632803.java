package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632803Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 人事分析
 * @author: CYL 
 * @since: 2018年6月7日 下午8:25:12 
 * @history:
 */
public class XN632803 extends AProcessor {
    private IArchiveAO archiveAO = SpringContextHolder
        .getBean(IArchiveAO.class);

    private XN632803Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return archiveAO.getTotal();
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632803Req.class);
        ObjValidater.validateReq(req);
    }
}
