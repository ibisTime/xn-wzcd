package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SocialRelation;

/**
 * 社会关系
 * @author: jiafr 
 * @since: 2018年6月4日 下午10:41:57 
 * @history:
 */
@Component
public interface ISocialRelationAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addSocialRelation(SocialRelation data);

    public int dropSocialRelation(String code);

    public int editSocialRelation(SocialRelation data);

    public Paginable<SocialRelation> querySocialRelationPage(int start,
            int limit, SocialRelation condition);

    public List<SocialRelation> querySocialRelationList(SocialRelation condition);

    public SocialRelation getSocialRelation(String code);

}
