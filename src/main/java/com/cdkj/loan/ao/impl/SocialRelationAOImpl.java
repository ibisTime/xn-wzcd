package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISocialRelationAO;
import com.cdkj.loan.bo.ISocialRelationBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SocialRelation;
import com.cdkj.loan.exception.BizException;

/**
 * 社会关系
 * @author: jiafr 
 * @since: 2018年6月4日 下午10:42:15 
 * @history:
 */
@Service
public class SocialRelationAOImpl implements ISocialRelationAO {

    @Autowired
    private ISocialRelationBO SocialRelationBO;

    @Override
    public String addSocialRelation(SocialRelation data) {
        return SocialRelationBO.saveSocialRelation(data);
    }

    @Override
    public int editSocialRelation(SocialRelation data) {
        if (!SocialRelationBO.isSocialRelationExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return SocialRelationBO.refreshSocialRelation(data);
    }

    @Override
    public int dropSocialRelation(String code) {
        if (!SocialRelationBO.isSocialRelationExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return SocialRelationBO.removeSocialRelation(code);
    }

    @Override
    public Paginable<SocialRelation> querySocialRelationPage(int start,
            int limit, SocialRelation condition) {
        return SocialRelationBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SocialRelation> querySocialRelationList(SocialRelation condition) {
        return SocialRelationBO.querySocialRelationList(condition);
    }

    @Override
    public SocialRelation getSocialRelation(String code) {
        return SocialRelationBO.getSocialRelation(code);
    }
}
