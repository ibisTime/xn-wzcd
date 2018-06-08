package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Notice;
import com.cdkj.loan.dto.req.XN632720Req;
import com.cdkj.loan.dto.req.XN632722Req;

/**
 * 公告管理
 * @author: silver 
 * @since: 2018年6月4日 下午5:19:00 
 * @history:
 */
public interface INoticeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addNotice(XN632720Req req);

    public Paginable<Notice> queryNoticePage(int start, int limit,
            Notice condition);

    public List<Notice> queryNoticeList(Notice condition);

    public Notice getNotice(String code);

    public void editNotice(XN632722Req req);

    public void publishNotice(String code, String updater, String remark);

    public void removeNotice(String code, String updater, String remark);
}
