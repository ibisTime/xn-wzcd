package com.cdkj.loan.dto.req;

import java.util.Date;

/**
 * 分页查询垫资
 * @author: jiafr 
 * @since: 2018年6月17日 下午5:25:14 
 * @history:
 */
public class XN632185Req extends APageReq {

    private static final long serialVersionUID = -3646680350039454519L;

    // 预算单编号
    private String budgetCode;

    // 客户姓名
    private String customerName;

    // 业务公司编号
    private String companyCode;

    // 垫资日期
    private Date advanceFundDatetime;

    // 付款银行编号
    private String payBankcardCode;

    // 付款凭证
    private String billPdf;

    // 意见说明
    private String note;

    // 撤销理由
    private String cancelReason;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

}
