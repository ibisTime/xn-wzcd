package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBizTeamDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BizTeam;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午1:05:03 
 * @history:
 */
@Repository("bizTeamDAOImpl")
public class BizTeamDAOImpl extends AMybatisTemplate implements IBizTeamDAO {

    @Override
    public int insert(BizTeam data) {
        return super.insert(NAMESPACE.concat("insert_bizTeam"), data);
    }

    @Override
    public int delete(BizTeam data) {
        return super.delete(NAMESPACE.concat("delete_bizTeam"), data);
    }

    @Override
    public BizTeam select(BizTeam condition) {
        return super.select(NAMESPACE.concat("select_bizTeam"), condition,
            BizTeam.class);
    }

    @Override
    public long selectTotalCount(BizTeam condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_bizTeam_count"),
            condition);
    }

    @Override
    public List<BizTeam> selectList(BizTeam condition) {
        return super.selectList(NAMESPACE.concat("select_bizTeam"), condition,
            BizTeam.class);
    }

    @Override
    public List<BizTeam> selectList(BizTeam condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bizTeam"), start,
            count, condition, BizTeam.class);
    }

    @Override
    public int update(BizTeam data) {

        return super.update(NAMESPACE.concat("update_bizTeam"), data);
    }

}
