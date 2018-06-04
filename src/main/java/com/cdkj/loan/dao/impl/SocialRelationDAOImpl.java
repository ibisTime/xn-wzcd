package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISocialRelationDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SocialRelation;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月4日 下午11:29:37 
 * @history:
 */
@Repository("socialRelationDAOImpl")
public class SocialRelationDAOImpl extends AMybatisTemplate implements
        ISocialRelationDAO {

    @Override
    public int insert(SocialRelation data) {
        return super.insert(NAMESPACE.concat("insert_SocialRelation"), data);
    }

    @Override
    public int delete(SocialRelation data) {
        return super.delete(NAMESPACE.concat("delete_SocialRelation"), data);
    }

    @Override
    public SocialRelation select(SocialRelation condition) {
        return super.select(NAMESPACE.concat("select_SocialRelation"),
            condition, SocialRelation.class);
    }

    @Override
    public long selectTotalCount(SocialRelation condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_SocialRelation_count"), condition);
    }

    @Override
    public List<SocialRelation> selectList(SocialRelation condition) {
        return super.selectList(NAMESPACE.concat("select_SocialRelation"),
            condition, SocialRelation.class);
    }

    @Override
    public List<SocialRelation> selectList(SocialRelation condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_SocialRelation"),
            start, count, condition, SocialRelation.class);
    }

    @Override
    public int update(SocialRelation data) {

        return super.update(NAMESPACE.concat("update_SocialRelation"), data);
    }

}
