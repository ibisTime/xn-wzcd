package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.NoticeRead;

/**
 * 阅读记录
 * @author: silver 
 * @since: 2018年6月7日 下午4:01:44 
 * @history:
 */
@Component
public interface INoticeReadAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public Paginable<NoticeRead> queryNoticeReadPage(int start, int limit,
            NoticeRead condition, String refType);

    public List<NoticeRead> queryNoticeReadList(NoticeRead condition);

    public NoticeRead getNoticeRead(Integer id);

}
