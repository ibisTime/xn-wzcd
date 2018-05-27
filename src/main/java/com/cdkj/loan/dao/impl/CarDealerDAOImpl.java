package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarDealerDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarDealer;

@Repository("carDealerDAOImpl")
public class CarDealerDAOImpl extends AMybatisTemplate
        implements ICarDealerDAO {

    @Override
    public int insert(CarDealer data) {
        return super.insert(NAMESPACE.concat("insert_carDealer"), data);
    }

    @Override
    public int delete(CarDealer data) {
        return super.delete(NAMESPACE.concat("delete_carDealer"), data);
    }

    @Override
    public int update(CarDealer data) {
        return super.update(NAMESPACE.concat("update_carDealer"), data);
    }

    @Override
    public int updateNode(CarDealer data) {
        return super.update(NAMESPACE.concat("update_carDealer_node"), data);
    }

    @Override
    public CarDealer select(CarDealer condition) {
        return super.select(NAMESPACE.concat("select_carDealer"), condition,
            CarDealer.class);
    }

    @Override
    public long selectTotalCount(CarDealer condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_carDealer_count"), condition);
    }

    @Override
    public List<CarDealer> selectList(CarDealer condition) {
        return super.selectList(NAMESPACE.concat("select_carDealer"), condition,
            CarDealer.class);
    }

    @Override
    public List<CarDealer> selectList(CarDealer condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_carDealer"), start,
            count, condition, CarDealer.class);
    }

}
