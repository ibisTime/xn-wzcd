package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SuppleSignApplyDetail;

/**
 * 补签细节
 * @author: silver 
 * @since: 2018年6月6日 下午1:59:18 
 * @history:
 */
public interface ISuppleSignApplyDetailBO
        extends IPaginableBO<SuppleSignApplyDetail> {
    public void saveSuppleSignApplyDetail(String suppleSignApplyCode,
            String suppleDatetime, String remark);

    public List<SuppleSignApplyDetail> querySuppleSignApplyDetailList(
            SuppleSignApplyDetail condition);

    public SuppleSignApplyDetail getSuppleSignApplyDetail(String code);

}
