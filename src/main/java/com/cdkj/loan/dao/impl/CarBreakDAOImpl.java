package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarBreakDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarBreak;

/**
 * 违章处理
 * @author: silver 
 * @since: 2018年6月6日 下午4:35:37 
 * @history:
 */
@Repository("carBreakDAOImpl")
public class CarBreakDAOImpl extends AMybatisTemplate implements ICarBreakDAO {

    @Override
    public int insert(CarBreak data) {
        return super.insert(NAMESPACE.concat("insert_CarBreak"), data);
    }

    @Override
    public int delete(CarBreak data) {
        return super.delete(NAMESPACE.concat("delete_CarBreak"), data);
    }

    @Override
    public void update(CarBreak data) {
        super.update(NAMESPACE.concat("update_CarBreak"), data);
    }

    @Override
    public CarBreak select(CarBreak condition) {
        return super.select(NAMESPACE.concat("select_CarBreak"), condition,
            CarBreak.class);
    }

    @Override
    public long selectTotalCount(CarBreak condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_CarBreak_count"),
            condition);
    }

    @Override
    public List<CarBreak> selectList(CarBreak condition) {
        return super.selectList(NAMESPACE.concat("select_CarBreak"), condition,
            CarBreak.class);
    }

    @Override
    public List<CarBreak> selectList(CarBreak condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_CarBreak"), start,
            count, condition, CarBreak.class);
    }
}
