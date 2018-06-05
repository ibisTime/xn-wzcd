package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IStorageOutAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.StorageOut;
import com.cdkj.loan.dto.req.XN632777Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询出库
 * @author: silver 
 * @since: 2018年6月5日 下午5:06:42 
 * @history:
 */
public class XN632777 extends AProcessor {
    private IStorageOutAO storageOutAO = SpringContextHolder
        .getBean(IStorageOutAO.class);

    private XN632777Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        StorageOut condition = new StorageOut();
        condition.setProductCode(req.getProductCode());
        condition.setCategoryCode(req.getCategoryCode());

        return storageOutAO.queryStorageOutList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632777Req.class);
        ObjValidater.validateReq(req);
    }

}
