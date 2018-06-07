package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.INoticeReadAO;
import com.cdkj.loan.bo.INoticeBO;
import com.cdkj.loan.bo.INoticeReadBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.NoticeRead;

/**
 * 公告阅读记录
 * @author: silver 
 * @since: 2018年6月7日 下午4:04:01 
 * @history:
 */
@Service
public class NoticeReadAOImpl implements INoticeReadAO {
    @Autowired
    private INoticeReadBO noticeReadBO;

    @Autowired
    private INoticeBO noticeBO;

    @Override
    public Paginable<NoticeRead> queryNoticeReadPage(int start, int limit,
            NoticeRead condition) {
        Paginable<NoticeRead> page = noticeReadBO.getPaginable(start, limit,
            condition);
        List<NoticeRead> noticeReadList = page.getList();
        for (NoticeRead noticeRead : noticeReadList) {
            noticeRead
                .setNotice(noticeBO.getNotice(noticeRead.getNoticeCode()));
        }

        return page;
    }

    @Override
    public List<NoticeRead> queryNoticeReadList(NoticeRead condition) {
        return noticeReadBO.queryNoticeReadList(condition);
    }

    @Override
    public NoticeRead getNoticeRead(Integer id) {
        NoticeRead noticeRead = noticeReadBO.getNoticeRead(id);
        noticeRead.setNotice(noticeBO.getNotice(noticeRead.getNoticeCode()));
        return noticeRead;
    }
}
