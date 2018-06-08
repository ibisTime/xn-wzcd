package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.NoticeRead;

/**
 * 公告阅读记录
 * @author: silver 
 * @since: 2018年6月7日 下午3:48:31 
 * @history:
 */
public interface INoticeReadBO extends IPaginableBO<NoticeRead> {
    public void saveNoticeRead(NoticeRead data);

    public List<NoticeRead> queryNoticeReadList(NoticeRead condition);

    public NoticeRead getNoticeRead(Integer id);

}
