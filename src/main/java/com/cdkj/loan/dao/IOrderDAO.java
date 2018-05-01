package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Order;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:03:38 
 * @history:
 */
public interface IOrderDAO extends IBaseDAO<Order> {
    String NAMESPACE = IOrderDAO.class.getName().concat(".");

    public int updateUserCancel(Order data);

    public int updatePayYESuccess(Order data);

    public int updatePaySuccess(Order data);

    public int updatePayRelationSuccess(Order data);

    public int updatePromptTimes(Order data);

    public int updateDeliverLogistics(Order data);

    public int updateDeliverXianchang(Order data);

    public int updatePlatCancel(Order data);

    public int updateConfirm(Order data);

    public int updateComment(Order data);

    public int updatePayGroup(Order data);

    public int updateYunfei(Order data);

    public Long selectTotalAmount(Order condition);

    // 统计用户消费总额
    public Long selectXFAmount(String userId);

    public int updateRemove(Order order);
}
