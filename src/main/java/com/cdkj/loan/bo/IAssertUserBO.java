package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.AssertUser;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:56:41 
 * @history:
 */
public interface IAssertUserBO extends IPaginableBO<AssertUser> {

    public boolean isAssertUserExist(String code);

    public String saveAssertUser(AssertUser data);

    public int removeAssertUser(String code);

    public int refreshAssertUser(AssertUser data);

    public List<AssertUser> queryAssertUserList(AssertUser condition);

    public AssertUser getAssertUser(String code);

}
