package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRemindLogDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.RemindLog;

@Repository("remindLogDAOImpl")
public class RemindLogDAOImpl extends AMybatisTemplate
        implements IRemindLogDAO {

    @Override
    public int insert(RemindLog data) {
        return super.insert(NAMESPACE.concat("insert_remindLog"), data);
    }

    @Override
    public int delete(RemindLog data) {
        return super.delete(NAMESPACE.concat("delete_remindLog"), data);
    }

    @Override
    public RemindLog select(RemindLog condition) {
        return super.select(NAMESPACE.concat("select_remindLog"), condition,
            RemindLog.class);
    }

    @Override
    public long selectTotalCount(RemindLog condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_remindLog_count"), condition);
    }

    @Override
    public List<RemindLog> selectList(RemindLog condition) {
        return super.selectList(NAMESPACE.concat("select_remindLog"), condition,
            RemindLog.class);
    }

    @Override
    public List<RemindLog> selectList(RemindLog condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_remindLog"), start,
            count, condition, RemindLog.class);
    }

    @Override
    public int update(RemindLog data) {
        // TODO Auto-generated method stub
        return 0;
    }

}
