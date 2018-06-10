package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayBiz;

public interface IRepayBizDAO extends IBaseDAO<RepayBiz> {
    String NAMESPACE = IRepayBizDAO.class.getName().concat(".");

    public int updateBankcard(RepayBiz data);

    public int updateRepayAllAdvance(RepayBiz data);

    public int updateRepayAll(RepayBiz data);

    public int updateEnterBlackList(RepayBiz data);

    public int updateConfirmSettledProduct(RepayBiz data);

    public int updateRepayBizRestAmount(RepayBiz data);

    // 清欠催收部审核
    public void approveByQkcsDepart(RepayBiz data);

    // 驻行人员审核
    public void approveByBankCheck(RepayBiz data);

    // 总经理审核
    public void approveByManager(RepayBiz data);

    // 财务审核
    public void approveByFinance(RepayBiz data);

    // 业务团队解除抵押
    public void releaseMortgage(RepayBiz data);

}
