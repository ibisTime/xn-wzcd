package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.dto.req.XN632807Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午9:36:24 
 * @history:
 */
public class XN632807 extends AProcessor {
    private IArchiveAO archiveAO = SpringContextHolder
        .getBean(IArchiveAO.class);

    private XN632807Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Archive condition = new Archive();
        condition.setRealName(req.getRealName());
        condition.setDepartmentCode(req.getDepartmentCode());
        condition.setPostCode(req.getPostCode());
        condition.setEntryDatetimeStart(req.getEntryDatetimeStart());
        condition.setEntryDatetimeEnd(req.getEntryDatetimeEnd());
        condition.setWorkStatus(req.getWorkStatus());
        return archiveAO.queryArchiveList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632807Req.class);
    }
}
