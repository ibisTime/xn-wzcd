package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BizTeam;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午1:04:16 
 * @history:
 */
public interface IBizTeamDAO extends IBaseDAO<BizTeam> {
    String NAMESPACE = IBizTeamDAO.class.getName().concat(".");

    int update(BizTeam data);
}
