package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IStorageInAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.StorageIn;
import com.cdkj.loan.dto.req.XN632765Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询库存
 * @author: silver 
 * @since: 2018年6月5日 下午2:44:04 
 * @history:
 */
public class XN632765 extends AProcessor {
    private IStorageInAO storageInAO = SpringContextHolder
        .getBean(IStorageInAO.class);

    private XN632765Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        StorageIn condition = new StorageIn();
        condition.setProductCode(req.getProductCode());
        condition.setCategoryCode(req.getCategoryCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IStorageInAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return storageInAO.queryStorageInPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632765Req.class);
        ObjValidater.validateReq(req);
    }

}
