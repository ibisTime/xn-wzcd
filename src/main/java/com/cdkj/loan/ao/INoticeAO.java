package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Notice;
import com.cdkj.loan.dto.req.XN632720Req;

/**
 * 公告管理
 * @author: silver 
 * @since: 2018年6月4日 下午5:19:00 
 * @history:
 */
@Component
public interface INoticeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addNotice(XN632720Req req);

    public Paginable<Notice> queryNoticePage(int start, int limit,
            Notice condition);

    public List<Notice> queryNoticeList(Notice condition);

    public Notice getNotice(String code);
}
