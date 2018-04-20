package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.dto.req.XN630407Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/*列表查询*/

public class XN630407 extends AProcessor {

    private IBrandAO brandAO = SpringContextHolder.getBean(IBrandAO.class);

    private XN630407Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Brand brand = new Brand();
        brand.setName(req.getName());
        brand.setLetter(req.getLetter());
        brand.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBrandAO.DEFAULT_ORDER_COLUMN;
        }
        brand.setOrder(orderColumn, "asc");
        return brandAO.queryBrandList(brand);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        // TODO Auto-generated method stub

    }

}
