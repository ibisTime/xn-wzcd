package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.dto.req.XN808050Req;
import com.cdkj.loan.dto.req.XN808054Req;
import com.cdkj.loan.dto.req.XN808070CReq;
import com.cdkj.loan.dto.res.XN003020Res;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午10:39:37 
 * @history:
 */
public interface IOrderAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public String commitOrder(XN808050Req req);

    public void modifyYunfei(String code, Long yunfei);

    public Object toPayOrder(String code, String payType, String tradePwd);

    public void userCancel(String code, String userId, String remark);

    public void platCancel(List<String> codeList, String updater,
            String remark);

    public void deliverLogistics(XN808054Req req);

    public void confirm(String code, String updater, String remark);

    public Paginable<Order> queryOrderPage(int start, int limit,
            Order condition);

    public Paginable<Order> queryMyOrderPage(int start, int limit,
            Order condition);

    public List<Order> queryOrderList(Order condition);

    public Order getOrder(String code);

    public void doChangeOrderStatusDaily();

    public void paySuccessHW(String payGroup, String payCode, Long amount);

    public XN003020Res getExpressFee(List<XN808070CReq> list, String address);

    public void dropOrderCancelByUser(String code);

}
