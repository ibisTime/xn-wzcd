package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.AdvanceFund;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:56:16 
 * @history:
 */
public interface IAdvanceFundDAO extends IBaseDAO<AdvanceFund> {
    String NAMESPACE = IAdvanceFundDAO.class.getName().concat(".");

    int update(AdvanceFund data);

    // 确认用款单 更新节点
    void updateConfirmAdvanceFund(AdvanceFund data);

    // 区域总经理审核 更新节点
    void updateAreaAudit(AdvanceFund data);

    // 省分公司总经理审核 更新节点
    void updateProvinceAudit(AdvanceFund data);
}
