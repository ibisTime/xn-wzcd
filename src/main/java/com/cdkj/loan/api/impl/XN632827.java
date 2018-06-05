package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArchiveLocationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.ArchiveLocation;
import com.cdkj.loan.dto.req.XN632827Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 下午7:04:05 
 * @history:
 */
public class XN632827 extends AProcessor {
    private IArchiveLocationAO archiveLocationAO = SpringContextHolder
        .getBean(IArchiveLocationAO.class);

    private XN632827Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ArchiveLocation condition = new ArchiveLocation();
        condition.setName(req.getName());
        return archiveLocationAO.queryArchiveLocationList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632827Req.class);
    }
}
