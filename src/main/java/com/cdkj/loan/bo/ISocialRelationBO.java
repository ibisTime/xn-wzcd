package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SocialRelation;

/**
 * 社会关系
 * @author: jiafr 
 * @since: 2018年6月4日 下午10:42:32 
 * @history:
 */
public interface ISocialRelationBO extends IPaginableBO<SocialRelation> {

    public boolean isSocialRelationExist(String code);

    public String saveSocialRelation(SocialRelation data);

    public int removeSocialRelation(String code);

    public int refreshSocialRelation(SocialRelation data);

    public List<SocialRelation> querySocialRelationList(SocialRelation condition);

    public SocialRelation getSocialRelation(String code);

}
