package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IArchiveLocationDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.ArchiveLocation;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月5日 上午1:04:45 
 * @history:
 */
@Repository("archiveLocationDAOImpl")
public class ArchiveLocationDAOImpl extends AMybatisTemplate implements
        IArchiveLocationDAO {

    @Override
    public int insert(ArchiveLocation data) {
        return super.insert(NAMESPACE.concat("insert_archiveLocation"), data);
    }

    @Override
    public int delete(ArchiveLocation data) {
        return super.delete(NAMESPACE.concat("delete_archiveLocation"), data);
    }

    @Override
    public ArchiveLocation select(ArchiveLocation condition) {
        return super.select(NAMESPACE.concat("select_archiveLocation"),
            condition, ArchiveLocation.class);
    }

    @Override
    public long selectTotalCount(ArchiveLocation condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_archiveLocation_count"), condition);
    }

    @Override
    public List<ArchiveLocation> selectList(ArchiveLocation condition) {
        return super.selectList(NAMESPACE.concat("select_archiveLocation"),
            condition, ArchiveLocation.class);
    }

    @Override
    public List<ArchiveLocation> selectList(ArchiveLocation condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_archiveLocation"),
            start, count, condition, ArchiveLocation.class);
    }

    @Override
    public int update(ArchiveLocation data) {

        return super.update(NAMESPACE.concat("update_archiveLocation"), data);
    }

}
