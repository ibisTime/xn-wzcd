package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BizTeam;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午1:01:06 
 * @history:
 */
public interface IBizTeamBO extends IPaginableBO<BizTeam> {

    public boolean isBizTeamExist(String code);

    public String saveBizTeam(BizTeam data);

    public int removeBizTeam(String code);

    public int refreshBizTeam(BizTeam data);

    public List<BizTeam> queryBizTeamList(BizTeam condition);

    public BizTeam getBizTeam(String code);

}
