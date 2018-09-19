package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RepointDetail;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月16日 下午2:45:08 
 * @history:
 */
public interface IRepointDetailBO extends IPaginableBO<RepointDetail> {

    public boolean isRepointDetailExist(String code);

    public String saveRepointDetail(RepointDetail data);

    public int removeRepointDetail(String code);

    public int refreshRepointDetail(RepointDetail data);

    public List<RepointDetail> queryRepointDetailList(RepointDetail condition);

    public List<RepointDetail> queryRepointDetailList(String budgetOrder,
            String useMoneyPurpose);

    public RepointDetail getRepointDetail(String code);

    // 更新返点明细状态
    public void updateCurNodeCode(RepointDetail data);

    // 发票不匹配重填预算单 删除所有返点数据
    public void delete(String budgetOrderCode);

    // 删除返点明细数据 根据预算编号和类型（1正常数据2发票不匹配产生的新返点数据）
    public void deletePreRepointDetail(String budgetOrderCode, String type);

    public void updateRepointDetailType(RepointDetail data);

    // 根据预算单编号删除返点明细数据
    public void deleteRepointDetailByBudgetOrderCode(String code);

    // 根据经销商编号查返点（去重）
    public List<RepointDetail> queryRepointDetailListByCarDealer(
            RepointDetail condition);

}
