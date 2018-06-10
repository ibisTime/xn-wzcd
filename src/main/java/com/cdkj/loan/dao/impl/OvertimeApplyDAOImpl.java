package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IOvertimeApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.OvertimeApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 上午8:26:03 
 * @history:
 */
@Repository("overtimeApplyDAOImpl")
public class OvertimeApplyDAOImpl extends AMybatisTemplate
        implements IOvertimeApplyDAO {

    @Override
    public int insert(OvertimeApply data) {
        return super.insert(NAMESPACE.concat("insert_overtimeApply"), data);
    }

    @Override
    public int delete(OvertimeApply data) {
        return super.delete(NAMESPACE.concat("delete_overtimeApply"), data);
    }

    @Override
    public OvertimeApply select(OvertimeApply condition) {
        return super.select(NAMESPACE.concat("select_overtimeApply"), condition,
            OvertimeApply.class);
    }

    @Override
    public long selectTotalCount(OvertimeApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_overtimeApply_count"), condition);
    }

    @Override
    public List<OvertimeApply> selectList(OvertimeApply condition) {
        return super.selectList(NAMESPACE.concat("select_overtimeApply"),
            condition, OvertimeApply.class);
    }

    @Override
    public List<OvertimeApply> selectList(OvertimeApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_overtimeApply"), start,
            count, condition, OvertimeApply.class);
    }

    @Override
    public int update(OvertimeApply data) {

        return super.update(NAMESPACE.concat("update_overtimeApply"), data);
    }

    @Override
    public Long selectTotalHour(OvertimeApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_overtimeApply_totalHour"), condition);
    }

}
