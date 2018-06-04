package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IArchiveDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Archive;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月4日 下午9:05:17 
 * @history:
 */
@Repository("archiveDAOImpl")
public class ArchiveDAOImpl extends AMybatisTemplate implements IArchiveDAO {

    @Override
    public int insert(Archive data) {
        return super.insert(NAMESPACE.concat("insert_archive"), data);
    }

    @Override
    public int delete(Archive data) {
        return super.delete(NAMESPACE.concat("delete_archive"), data);
    }

    @Override
    public Archive select(Archive condition) {
        return super.select(NAMESPACE.concat("select_archive"), condition,
            Archive.class);
    }

    @Override
    public long selectTotalCount(Archive condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_archive_count"),
            condition);
    }

    @Override
    public List<Archive> selectList(Archive condition) {
        return super.selectList(NAMESPACE.concat("select_archive"), condition,
            Archive.class);
    }

    @Override
    public List<Archive> selectList(Archive condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_archive"), start,
            count, condition, Archive.class);
    }

    @Override
    public int update(Archive data) {
        return super.update(NAMESPACE.concat("update_archive"), data);

    }

    @Override
    public int updateLeaveArchive(Archive data) {

        return super.update(NAMESPACE.concat("update_leave_archive"), data);
    }
}
