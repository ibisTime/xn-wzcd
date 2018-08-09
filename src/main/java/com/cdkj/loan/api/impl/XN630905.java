package com.cdkj.loan.api.impl;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.dto.req.XN630905Req;
import com.cdkj.loan.enums.EAdvanceFundNode;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 当天0点为止分公司没有打款给车行的数据统计
 * @author: jiafr 
 * @since: 2018年8月9日 上午10:29:58 
 * @history:
 */
public class XN630905 extends AProcessor {

    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN630905Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        AdvanceFund condition = new AdvanceFund();
        condition.setBudgetCode(req.getBudgetCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCustomerName(req.getCustomerName());
        condition.setLoanBankCode(req.getLoanBankCode());
        condition.setCurNodeCode(EAdvanceFundNode.BRANCH_CAR_DEALER.getCode());
        // 获取当前时间的前一天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String date = DateUtil.dateToStr(calendar.getTime(),
            DateUtil.FRONT_DATE_FORMAT_STRING);
        condition.setUpdateDatetimeStart(DateUtil.getStartDatetime(date));
        condition.setUpdateDatetimeEnd(DateUtil.getEndDatetime(date));

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IAdvanceFundAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return advanceFundAO.queryAdvanceFundPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630905Req.class);
        ObjValidater.validateReq(req);
    }
}
