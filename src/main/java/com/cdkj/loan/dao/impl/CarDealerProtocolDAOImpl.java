package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarDealerProtocolDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarDealerProtocol;

@Repository("carDealerProtocolDAOImpl")
public class CarDealerProtocolDAOImpl extends AMybatisTemplate
        implements ICarDealerProtocolDAO {

    @Override
    public int insert(CarDealerProtocol data) {
        return super.insert(NAMESPACE.concat("insert_carDealerProtocol"), data);
    }

    @Override
    public int delete(CarDealerProtocol data) {
        return super.delete(NAMESPACE.concat("delete_carDealerProtocol"), data);
    }

    @Override
    public int update(CarDealerProtocol data) {
        return super.update(NAMESPACE.concat("update_carDealerProtocol"), data);
    }

    @Override
    public CarDealerProtocol select(CarDealerProtocol condition) {
        return super.select(NAMESPACE.concat("select_carDealerProtocol"),
            condition, CarDealerProtocol.class);
    }

    @Override
    public long selectTotalCount(CarDealerProtocol condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_carDealerProtocol_count"), condition);
    }

    @Override
    public List<CarDealerProtocol> selectList(CarDealerProtocol condition) {
        return super.selectList(NAMESPACE.concat("select_carDealerProtocol"),
            condition, CarDealerProtocol.class);
    }

    @Override
    public List<CarDealerProtocol> selectList(CarDealerProtocol condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_carDealerProtocol"),
            start, count, condition, CarDealerProtocol.class);
    }

}
