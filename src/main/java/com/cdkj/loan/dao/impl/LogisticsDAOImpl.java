package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ILogisticsDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Logistics;

/**
 * 资料发送
 * @author: silver 
 * @since: 2018年5月29日 下午10:24:35 
 * @history:
 */

@Repository("logisticsDAOImpl")
public class LogisticsDAOImpl extends AMybatisTemplate
        implements ILogisticsDAO {

    @Override
    public int insert(Logistics data) {
        return super.insert(NAMESPACE.concat("insert_logistics"), data);
    }

    @Override
    public int delete(Logistics data) {
        return super.delete(NAMESPACE.concat("delete_logistics"), data);
    }

    @Override
    public Logistics select(Logistics condition) {
        return super.select(NAMESPACE.concat("select_logistics"), condition,
            Logistics.class);
    }

    @Override
    public long selectTotalCount(Logistics condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_logistics_count"), condition);
    }

    @Override
    public List<Logistics> selectList(Logistics condition) {
        return super.selectList(NAMESPACE.concat("select_logistics"), condition,
            Logistics.class);
    }

    @Override
    public List<Logistics> selectList(Logistics condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_logistics"), start,
            count, condition, Logistics.class);

    }

    @Override
    public void updateLogisticsSend(Logistics data) {
        super.update(NAMESPACE.concat("update_logistics_send"), data);
    }

    @Override
    public void updateLogisticsReceive(Logistics data) {
        super.update(NAMESPACE.concat("update_logistics_receive"), data);

    }

    @Override
    public void updateLogisticsBackPiece(Logistics data) {
        super.update(NAMESPACE.concat("update_logistics_backPiece"), data);
    }

    @Override
    public void updateLogisticsAudite(Logistics data) {
        super.update(NAMESPACE.concat("update_logistics_audite"), data);

    }

    @Override
    public void updateLogisticsSendAgain(Logistics data) {
        super.update(NAMESPACE.concat("update_logistics_sendAgain"), data);
    }

    @Override
    public void updateLogistics(Logistics data) {
        super.update(NAMESPACE.concat("update_logistics"), data);
    }

}
