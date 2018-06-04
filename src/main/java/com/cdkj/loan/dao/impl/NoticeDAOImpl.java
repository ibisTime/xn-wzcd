package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.INoticeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Notice;

/**
 * 公告管理
 * @author: silver 
 * @since: 2018年6月4日 下午5:14:36 
 * @history:
 */
@Repository("noticeDAOImpl")
public class NoticeDAOImpl extends AMybatisTemplate implements INoticeDAO {

    @Override
    public int insert(Notice data) {
        return super.insert(NAMESPACE.concat("insert_notice"), data);
    }

    @Override
    public int delete(Notice data) {
        return super.delete(NAMESPACE.concat("delete_notice"), data);
    }

    @Override
    public Notice select(Notice condition) {
        return super.select(NAMESPACE.concat("select_notice"), condition,
            Notice.class);
    }

    @Override
    public long selectTotalCount(Notice condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_notice_count"),
            condition);
    }

    @Override
    public List<Notice> selectList(Notice condition) {
        return super.selectList(NAMESPACE.concat("select_notice"), condition,
            Notice.class);
    }

    @Override
    public List<Notice> selectList(Notice condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_notice"), start, count,
            condition, Notice.class);
    }

}
