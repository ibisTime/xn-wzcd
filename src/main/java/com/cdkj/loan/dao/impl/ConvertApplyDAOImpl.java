package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IConvertApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.ConvertApply;

//CHECK 。。。 
@Repository("convertApplyDAOImpl")
public class ConvertApplyDAOImpl extends AMybatisTemplate
        implements IConvertApplyDAO {

    @Override
    public int insert(ConvertApply data) {
        return super.insert(NAMESPACE.concat("insert_convertApply"), data);
    }

    @Override
    public int delete(ConvertApply data) {
        return super.delete(NAMESPACE.concat("delete_convertApply"), data);
    }

    @Override
    public int update(ConvertApply data) {
        return super.update(NAMESPACE.concat("update_convertApply"), data);
    }

    @Override
    public void updateConvertApplyStatus(ConvertApply data) {
        super.update(NAMESPACE.concat("update_convertApply_status"), data);
    }

    @Override
    public ConvertApply select(ConvertApply condition) {
        return super.select(NAMESPACE.concat("select_convertApply"), condition,
            ConvertApply.class);
    }

    @Override
    public long selectTotalCount(ConvertApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_convertApply_count"), condition);
    }

    @Override
    public List<ConvertApply> selectList(ConvertApply condition) {
        return super.selectList(NAMESPACE.concat("select_convertApply"),
            condition, ConvertApply.class);
    }

    @Override
    public List<ConvertApply> selectList(ConvertApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_convertApply"), start,
            count, condition, ConvertApply.class);
    }

}
