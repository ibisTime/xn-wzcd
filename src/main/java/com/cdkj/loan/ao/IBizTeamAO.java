package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTeam;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午1:00:39 
 * @history:
 */
@Component
public interface IBizTeamAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBizTeam(BizTeam data);

    public int dropBizTeam(String code);

    public int editBizTeam(BizTeam data);

    public Paginable<BizTeam> queryBizTeamPage(int start, int limit,
            BizTeam condition);

    public List<BizTeam> queryBizTeamList(BizTeam condition);

    public BizTeam getBizTeam(String code);

}
