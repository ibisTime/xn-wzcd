package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISocialRelationBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ISocialRelationDAO;
import com.cdkj.loan.domain.SocialRelation;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 社会关系
 * @author: jiafr 
 * @since: 2018年6月4日 下午10:42:47 
 * @history:
 */
@Component
public class SocialRelationBOImpl extends PaginableBOImpl<SocialRelation>
        implements ISocialRelationBO {

    @Autowired
    private ISocialRelationDAO socialRelationDAO;

    @Override
    public boolean isSocialRelationExist(String code) {
        SocialRelation condition = new SocialRelation();
        condition.setCode(code);
        if (socialRelationDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveSocialRelation(SocialRelation data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.SOCIAL_RELATION
                .getCode());
            data.setCode(code);
            socialRelationDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeSocialRelation(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            SocialRelation data = new SocialRelation();
            data.setArchiveCode(code);
            count = socialRelationDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshSocialRelation(SocialRelation data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = socialRelationDAO.update(data);
        }
        return count;
    }

    @Override
    public List<SocialRelation> querySocialRelationList(SocialRelation condition) {
        return socialRelationDAO.selectList(condition);
    }

    @Override
    public SocialRelation getSocialRelation(String code) {
        SocialRelation data = null;
        if (StringUtils.isNotBlank(code)) {
            SocialRelation condition = new SocialRelation();
            condition.setCode(code);
            data = socialRelationDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }
}
