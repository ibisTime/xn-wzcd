package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.TotalAdvanceFund;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月17日 下午10:34:29 
 * @history:
 */
public interface ITotalAdvanceFundBO extends IPaginableBO<TotalAdvanceFund> {

    public boolean isTotalAdvanceFundExist(String code);

    public String saveTotalAdvanceFund(TotalAdvanceFund data);

    public int removeTotalAdvanceFund(String code);

    public int refreshTotalAdvanceFund(TotalAdvanceFund data);

    public List<TotalAdvanceFund> queryTotalAdvanceFundList(
            TotalAdvanceFund condition);

    public TotalAdvanceFund getTotalAdvanceFund(String code);

    // 查询垫资汇总单 通过公司编号和状态
    public TotalAdvanceFund getTotalAdvanceFundByCompanyCodeAndStatus(
            String companyCode, String status);

}
