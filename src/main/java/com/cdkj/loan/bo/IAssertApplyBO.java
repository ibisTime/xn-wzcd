package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.AssertApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午8:27:35 
 * @history:
 */
public interface IAssertApplyBO extends IPaginableBO<AssertApply> {

    public boolean isAssertApplyExist(String code);

    public String saveAssertApply(AssertApply data);

    public int removeAssertApply(String code);

    public int refreshAssertApply(AssertApply data);

    public List<AssertApply> queryAssertApplyList(AssertApply condition);

    public Paginable<AssertApply> getPaginableByDepartmentCode(int start,
            int pageSize, AssertApply condition);

    public AssertApply getAssertApply(String code);

}
