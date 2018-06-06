package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IWelfareUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IWelfareUserDAO;
import com.cdkj.loan.domain.WelfareUser;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 福利发放人员
 * @author: silver 
 * @since: 2018年6月6日 下午8:19:11 
 * @history:
 */
@Component
public class WelfareUserBOImpl extends PaginableBOImpl<WelfareUser>
        implements IWelfareUserBO {
    @Autowired
    private IWelfareUserDAO WelfareUserDAO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public boolean isWelfareUserExist(String code) {
        WelfareUser condition = new WelfareUser();
        condition.setCode(code);
        if (WelfareUserDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveWelfareUser(String welfareApplyCode, String userId,
            String remark) {
        WelfareUser data = new WelfareUser();
        data.setWelfareCode(welfareApplyCode);
        data.setUserId(userId);
        data.setRemark(remark);
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.WELFARE_USER.getCode());

        data.setCode(code);
        WelfareUserDAO.insert(data);
        return code;
    }

    @Override
    public List<WelfareUser> queryWelfareUserList(WelfareUser condition) {
        List<WelfareUser> welfareUserList = WelfareUserDAO
            .selectList(condition);
        for (WelfareUser welfareUser : welfareUserList) {
            welfareUser.setUserName(
                sysUserBO.getUser(welfareUser.getUserId()).getRealName());
        }
        return welfareUserList;
    }

    @Override
    public WelfareUser getWelfareUser(String code) {
        WelfareUser data = null;
        if (StringUtils.isNotBlank(code)) {
            WelfareUser condition = new WelfareUser();
            condition.setCode(code);
            data = WelfareUserDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }
        }
        return data;
    }

    @Override
    public WelfareUser getWelfareUserByApply(String welfareCode) {
        WelfareUser data = null;
        if (StringUtils.isNotBlank(welfareCode)) {
            WelfareUser condition = new WelfareUser();
            condition.setWelfareCode(welfareCode);
            data = WelfareUserDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }
        }
        return data;
    }
}
