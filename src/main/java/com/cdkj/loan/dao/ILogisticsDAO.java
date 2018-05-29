package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Logistics;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午10:21:10 
 * @history:
 */

public interface ILogisticsDAO extends IBaseDAO<Logistics> {
    String NAMESPACE = ILogisticsDAO.class.getName().concat(".");

    // 发件
    public void updateLogisticsSend(Logistics data);

    // 收件并审核通过
    public void updateLogisticsReceive(Logistics data);

    // 收件待补件
    public void updateLogisticsSendAgain(Logistics data);

}
