package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRegimeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Regime;

/**
 * 公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:33:51 
 * @history:
 */
@Repository("regimeDAOImpl")
public class RegimeDAOImpl extends AMybatisTemplate implements IRegimeDAO {

    @Override
    public int insert(Regime data) {
        return super.insert(NAMESPACE.concat("insert_Regime"), data);
    }

    @Override
    public int delete(Regime data) {
        return super.delete(NAMESPACE.concat("delete_Regime"), data);
    }

    @Override
    public Regime select(Regime condition) {
        return super.select(NAMESPACE.concat("select_Regime"), condition,
            Regime.class);
    }

    @Override
    public long selectTotalCount(Regime condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_Regime_count"),
            condition);
    }

    @Override
    public List<Regime> selectList(Regime condition) {
        return super.selectList(NAMESPACE.concat("select_Regime"), condition,
            Regime.class);
    }

    @Override
    public List<Regime> selectList(Regime condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_Regime"), start, count,
            condition, Regime.class);
    }

}
