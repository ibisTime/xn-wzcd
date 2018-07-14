package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISupplementReasonDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SupplementReason;

@Repository("supplementReasonDAOImpl")
public class SupplementReasonDAOImpl extends AMybatisTemplate
        implements ISupplementReasonDAO {

    @Override
    public int insert(SupplementReason data) {
        return super.insert(NAMESPACE.concat("insert_supplementReason"), data);
    }

    @Override
    public int delete(SupplementReason data) {
        return 0;
    }

    @Override
    public SupplementReason select(SupplementReason condition) {
        return super.select(NAMESPACE.concat("select_supplementReason"),
            condition, SupplementReason.class);
    }

    @Override
    public long selectTotalCount(SupplementReason condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_supplementReason_count"), condition);
    }

    @Override
    public List<SupplementReason> selectList(SupplementReason condition) {
        return super.selectList(NAMESPACE.concat("select_supplementReason"),
            condition, SupplementReason.class);
    }

    @Override
    public List<SupplementReason> selectList(SupplementReason condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_supplementReason"),
            start, count, condition, SupplementReason.class);
    }

}
