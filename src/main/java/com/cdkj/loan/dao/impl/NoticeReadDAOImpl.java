package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.INoticeReadDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.NoticeRead;

/**
 * 公告阅读记录
 * @author: silver 
 * @since: 2018年6月7日 下午3:45:39 
 * @history:
 */
@Repository("noticeReadDAOImpl")
public class NoticeReadDAOImpl extends AMybatisTemplate
        implements INoticeReadDAO {

    @Override
    public int insert(NoticeRead data) {
        return super.insert(NAMESPACE.concat("insert_noticeRead"), data);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void insertNoticeReadList(List<NoticeRead> dataList) {
        super.insertBatch(NAMESPACE.concat("insert_noticeReadList"),
            (List) dataList);
    }

    @Override
    public int delete(NoticeRead data) {
        return super.delete(NAMESPACE.concat("delete_noticeRead"), data);
    }

    @Override
    public NoticeRead select(NoticeRead condition) {
        return super.select(NAMESPACE.concat("select_noticeRead"), condition,
            NoticeRead.class);
    }

    @Override
    public long selectTotalCount(NoticeRead condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_noticeRead_count"), condition);
    }

    @Override
    public List<NoticeRead> selectList(NoticeRead condition) {
        return super.selectList(NAMESPACE.concat("select_noticeRead"),
            condition, NoticeRead.class);
    }

    @Override
    public List<NoticeRead> selectList(NoticeRead condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_noticeRead"), start,
            count, condition, NoticeRead.class);
    }

    @Override
    public void update(NoticeRead data) {
        super.update(NAMESPACE.concat("update_noticeRead"), data);
    }

}
