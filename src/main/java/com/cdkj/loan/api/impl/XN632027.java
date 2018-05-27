package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IProvinceAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Province;
import com.cdkj.loan.dto.req.XN632027Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询省份区域
 * @author: silver 
 * @since: 2018年5月27日 上午11:32:09 
 * @history:
 */
public class XN632027 extends AProcessor {

    private IProvinceAO provinceAO = SpringContextHolder
        .getBean(IProvinceAO.class);

    private XN632027Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Province condition = new Province();
        condition.setId(StringValidater.toInteger(req.getId()));
        condition.setName(req.getName());
        condition.setProvinceNo(req.getProvinceNo());
        return provinceAO.queryProvinceList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632027Req.class);
        ObjValidater.validateReq(req);
    }

}
