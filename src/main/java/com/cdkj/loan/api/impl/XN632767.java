package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IStorageInAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.StorageIn;
import com.cdkj.loan.dto.req.XN632767Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询库存
 * @author: silver 
 * @since: 2018年6月5日 下午2:46:52 
 * @history:
 */
public class XN632767 extends AProcessor {
    private IStorageInAO storageInAO = SpringContextHolder
        .getBean(IStorageInAO.class);

    private XN632767Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        StorageIn condition = new StorageIn();
        condition.setProductCode(req.getProductCode());
        condition.setCategoryCode(req.getCategoryCode());

        return storageInAO.queryStorageInList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632767Req.class);
        ObjValidater.validateReq(req);
    }

}
