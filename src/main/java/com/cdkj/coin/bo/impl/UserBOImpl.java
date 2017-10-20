package com.cdkj.coin.bo.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.domain.User;
import com.cdkj.coin.dto.req.XN001001Req;
import com.cdkj.coin.dto.req.XN001100Req;
import com.cdkj.coin.dto.req.XN001102Req;
import com.cdkj.coin.dto.req.XN001400Req;
import com.cdkj.coin.dto.req.XN805041Req;
import com.cdkj.coin.dto.req.XN805042Req;
import com.cdkj.coin.dto.req.XN805190Req;
import com.cdkj.coin.dto.res.XN001102Res;
import com.cdkj.coin.dto.res.XN001400Res;
import com.cdkj.coin.dto.res.XN805041Res;
import com.cdkj.coin.dto.res.XN805042Res;
import com.cdkj.coin.enums.ESystemCode;
import com.cdkj.coin.enums.EUserKind;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.http.BizConnecter;
import com.cdkj.coin.http.JsonUtils;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:30 
 * @history:
 */
@Component
public class UserBOImpl implements IUserBO {

    @Override
    public void checkTradePwd(String userId, String tradePwd) {
        if (StringUtils.isBlank(tradePwd)) {
            throw new BizException("XN000000", "请输入支付密码");
        }
        XN001100Req req = new XN001100Req();
        req.setTokenId(userId);
        req.setUserId(userId);
        req.setTradePwd(tradePwd);
        BizConnecter.getBizData("001100", JsonUtils.object2Json(req),
            Object.class);
    }

    @Override
    public User getRemoteUser(String userId) {
        User user = null;
        if (StringUtils.isNotBlank(userId)) {
            XN001400Req req = new XN001400Req();
            req.setTokenId(userId);
            req.setUserId(userId);
            XN001400Res res = BizConnecter.getBizData("001400",
                JsonUtils.object2Json(req), XN001400Res.class);
            if (res == null) {
                throw new BizException("XN000000", "编号为" + userId + "的用户不存在");
            }
            user = new User();
            user.setUserId(res.getUserId());
            user.setOpenId(res.getOpenId());
            user.setKind(res.getKind());
            user.setLoginName(res.getLoginName());
            user.setNickname(res.getNickname());
            user.setPhoto(res.getPhoto());
            user.setMobile(res.getMobile());
            user.setIdentityFlag(res.getIdentityFlag());
            user.setIdKind(res.getIdKind());
            user.setRealName(res.getRealName());
            user.setIdNo(res.getIdNo());
            user.setUserReferee(res.getUserReferee());
            user.setDivRate(StringValidater.toDouble(res.getDivRate()));
            user.setCompanyCode(res.getCompanyCode());
            user.setSystemCode(res.getSystemCode());
            user.setBlacklistFlag(res.getBlacklistFlag());
            user.setProvince(res.getProvince());
            user.setCity(res.getCity());
            user.setArea(res.getArea());
            user.setAddress(res.getAddress());

        }
        return user;
    }

    @Override
    public void doIdentify(String userId, String idKind, String idNo,
            String realName) {
        XN805190Req req = new XN805190Req();
        req.setUserId(userId);
        req.setIdKind(idKind);
        req.setIdNo(idNo);
        req.setRealName(realName);
        BizConnecter.getBizData("805190", JsonUtils.object2Json(req),
            Object.class);
    }

    @Override
    public String isUserExist(String mobile, EUserKind kind, String systemCode) {
        String userId = null;
        XN001102Req req = new XN001102Req();
        req.setMobile(mobile);
        req.setKind(kind.getCode());
        req.setSystemCode(systemCode);
        XN001102Res res = BizConnecter.getBizData("001102",
            JsonUtils.object2Json(req), XN001102Res.class);
        if (res != null) {
            userId = res.getUserId();
        }
        return userId;
    }

    @Override
    public XN805041Res doCustomerRegister(String mobile, String loginPwd,
            String userReferee, String userRefereeKind, String smsCaptcha) {
        XN805041Req req = new XN805041Req();
        req.setMobile(mobile);
        req.setLoginPwd(loginPwd);
        req.setUserReferee(userReferee);
        req.setUserRefereeKind(userRefereeKind);
        req.setSmsCaptcha(smsCaptcha);
        req.setKind(EUserKind.Customer.getCode());
        req.setIsRegHx("0");
        req.setCompanyCode(ESystemCode.COIN.getCode());
        req.setSystemCode(ESystemCode.COIN.getCode());
        return BizConnecter.getBizData("805041", JsonUtils.object2Json(req),
            XN805041Res.class);
    }

    @Override
    public void addBlacklist(String userId, String type, String updater,
            String remark) {
        XN001001Req req = new XN001001Req();
        req.setRemark(remark);
        req.setUserId(userId);
        req.setUpdater(updater);
        req.setType(type);
        BizConnecter.getBizData("001001", JsonUtils.object2Json(req));
    }

    @Override
    public String doAddUser(XN805042Req req) {
        XN805042Res res = BizConnecter.getBizData("805042",
            JsonUtils.object2Json(req), XN805042Res.class);
        return res.getUserId();
    }

}
