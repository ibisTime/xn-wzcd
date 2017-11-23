/**
 * @Title UserRelationAOImpl.java 
 * @Package com.std.user.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月31日 上午11:48:23 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import java.util.List;

import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.domain.UserStatistics;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IUserRelationAO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.bo.IUserRelationBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.User;
import com.cdkj.coin.domain.UserRelation;
import com.cdkj.coin.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年8月31日 上午11:48:23 
 * @history:
 */
@Service
public class UserRelationAOImpl implements IUserRelationAO {

    @Autowired
    IUserRelationBO userRelationBO;

    @Autowired
    IUserBO userBO;

    @Autowired
    ITradeOrderBO tradeOrderBO;

    /** 
     * @see com.std.user.ao.IUserRelationAO#queryUserRelationPage(int, int, com.std.user.domain.UserRelation)
     */
    @Override
    public Paginable<UserRelation> queryUserRelationPage(int start, int limit,
            UserRelation condition) {
        Paginable<UserRelation> page = userRelationBO.getPaginable(start,
            limit, condition);
        for (UserRelation userRelation : page.getList()) {

            User lookUser = null;
            if (StringUtils.isNotBlank(condition.getUserId())) {
                //查询——我信任的
                User toUser = userBO.getUser(userRelation.getToUser());
                lookUser = toUser;
                //
                userRelation.setToUserInfo(toUser);

            } else  {
                //查询——信任我的
                User fromUser = userBO.getUser(userRelation
                        .getUserId());
                lookUser = fromUser;
                userRelation.setFromUserInfo(fromUser);
            }

            //查询统计信息
            if (lookUser != null) {

                UserStatistics userStatistics = new UserStatistics();
                userStatistics = this.tradeOrderBO.obtainUserStatistics(lookUser.getUserId());
                userStatistics.setBeiXinRenCount(this.userRelationBO.getRelationCount(lookUser.getUserId()));
                lookUser.setUserStatistics(userStatistics);
            }

        }

        return page;

    }

    /** 
     * @see com.std.user.ao.IUserRelationAO#followUser(java.lang.String, java.lang.String)
     */
    @Override
    public void followUser(String userId, String toUserId) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn702001", "用户不存在");
        }
        User toUser = userBO.getUser(toUserId);
        if (toUser == null) {
            throw new BizException("xn702001", "关注用户不存在");
        }
        // 判断两者关系是否存在
        if (userRelationBO.isExistUserRelation(userId, toUserId)) {
            throw new BizException("xn702001", "用户关系已建立");
        }
        userRelationBO.saveUserRelation(userId, toUserId, user.getSystemCode());
    }

    /** 
     * @see com.std.user.ao.IUserRelationAO#unfollowUser(java.lang.String, java.lang.String)
     */
    @Override
    public void unfollowUser(String userId, String toUserId) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn702001", "用户不存在");
        }
        User toUser = userBO.getUser(toUserId);
        if (toUser == null) {
            throw new BizException("xn702001", "取消关注用户不存在");
        }
        // 判断两者关系是否存在
        if (!userRelationBO.isExistUserRelation(userId, toUserId)) {
            throw new BizException("xn702001", "用户关系未建立，无法解除");
        }
        userRelationBO.removeUserRelation(userId, toUserId);
    }

    @Override
    public boolean isExistUserRelation(String userId, String toUser) {
        List<UserRelation> userRelationList = userRelationBO
            .queryUserRelationList(userId, toUser);
        boolean flag = false;
        if (CollectionUtils.isNotEmpty(userRelationList)) {
            flag = true;
        }
        return flag;
    }
}
