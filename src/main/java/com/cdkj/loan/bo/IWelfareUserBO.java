package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.WelfareUser;

/**
 * 福利发放人员
 * @author: silver 
 * @since: 2018年6月6日 下午8:18:48 
 * @history:
 */
public interface IWelfareUserBO extends IPaginableBO<WelfareUser> {

    public boolean isWelfareUserExist(String code);

    public String saveWelfareUser(String welfareApplyCode, String userId,
            String remark);

    public List<WelfareUser> queryWelfareUserList(WelfareUser condition);

    public WelfareUser getWelfareUser(String code);

    public WelfareUser getWelfareUserByApply(String welfareCode);
}
