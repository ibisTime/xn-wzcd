package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.ao.IStorageOutAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.StorageOut;
import com.cdkj.loan.dto.req.XN632775Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询出库
 * @author: silver 
 * @since: 2018年6月5日 下午5:04:37 
 * @history:
 */
public class XN632775 extends AProcessor {
    private IStorageOutAO storageOutAO = SpringContextHolder
        .getBean(IStorageOutAO.class);

    private XN632775Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        StorageOut condition = new StorageOut();
        condition.setProductCode(req.getProductCode());
        condition.setCategoryCode(req.getCategoryCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBankAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return storageOutAO.queryStorageOutPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632775Req.class);
        ObjValidater.validateReq(req);
    }

}
