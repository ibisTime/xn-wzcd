/**
 * @Title UserRelationBOImpl.java 
 * @Package com.std.user.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月31日 上午11:17:49 
 * @version V1.0   
 */
package com.cdkj.coin.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.IUserRelationBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.IUserRelationDAO;
import com.cdkj.coin.domain.UserRelation;
import com.cdkj.coin.enums.EBoolean;

/** 
 * 用户关系BO
 * @author: xieyj 
 * @since: 2016年8月31日 上午11:17:49 
 * @history:
 */
@Component
public class UserRelationBOImpl extends PaginableBOImpl<UserRelation> implements
        IUserRelationBO {
    @Autowired
    private IUserRelationDAO userRelationDAO;

    /** 
     * @see com.std.user.bo.IUserRelationBO#isExistUserRelation(java.lang.String, java.lang.String)
     */
    @Override
    public boolean isExistUserRelation(String userId, String toUser) {
        UserRelation condition = new UserRelation();
        condition.setUserId(userId);
        condition.setToUser(toUser);
        long count = userRelationDAO.selectTotalCount(condition);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.std.user.bo.IUserRelationBO#saveUserRelation(java.lang.String, java.lang.String)
     */
    @Override
    public String saveUserRelation(String userId, String toUser,
            String systemCode) {
        String code = null;
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(toUser)) {
            UserRelation data = new UserRelation();
            code = OrderNoGenerater.generate("UR");
            data.setCode(code);
            data.setUserId(userId);
            data.setToUser(toUser);
            data.setStatus(EBoolean.YES.getCode());
            data.setUpdateDatetime(new Date());
            data.setSystemCode(systemCode);
            userRelationDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.std.user.bo.IUserRelationBO#refreshUserRelation(java.lang.String, java.lang.String)
     */
    @Override
    public int refreshUserRelation(String userId, String toUser) {
        int count = 0;
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(toUser)) {
            UserRelation data = new UserRelation();
            data.setUserId(userId);
            data.setToUser(toUser);
            data.setStatus(EBoolean.NO.getCode());
            count = userRelationDAO.updateStatus(data);
        }
        return count;
    }

    /**
     * @see com.std.user.bo.IUserRelationBO#removeUserRelation(java.lang.String, java.lang.String)
     */
    @Override
    public int removeUserRelation(String userId, String toUser) {
        int count = 0;
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(toUser)) {
            UserRelation data = new UserRelation();
            data.setUserId(userId);
            data.setToUser(toUser);
            count = userRelationDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<UserRelation> queryUserRelationList(String userId, String toUser) {
        UserRelation condition = new UserRelation();
        condition.setUserId(userId);
        condition.setToUser(toUser);
        return userRelationDAO.selectList(condition);
    }

    @Override
    public long getRelationCount(String toUser) {
        UserRelation condition = new UserRelation();
        condition.setToUser(toUser);
        return getTotalCount(condition);
    }

    @Override
    public boolean checkReleation(String userId, String toUser) {

        UserRelation condition = new UserRelation();
        condition.setUserId(userId);
        condition.setToUser(toUser);
        return this.userRelationDAO.selectTotalCount(condition) >= 1;
    }
}
