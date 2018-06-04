package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Notice;

/**
 * 公告管理
 * @author: silver 
 * @since: 2018年6月4日 下午5:15:17 
 * @history:
 */
public interface INoticeBO extends IPaginableBO<Notice> {
    public boolean isNoticeExist(String code);

    public String saveNotice(Notice data);

    public List<Notice> queryNoticeList(Notice condition);

    public Notice getNotice(String code);

}
