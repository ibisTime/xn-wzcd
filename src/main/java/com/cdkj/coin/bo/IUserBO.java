package com.cdkj.coin.bo;

import com.cdkj.coin.domain.User;
import com.cdkj.coin.dto.req.XN805042Req;
import com.cdkj.coin.dto.res.XN805041Res;
import com.cdkj.coin.enums.EUserKind;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:13 
 * @history:
 */
public interface IUserBO {

    public void checkTradePwd(String userId, String tradePwd);

    public User getRemoteUser(String userId);

    public String isUserExist(String mobile, EUserKind kind, String systemCode);

    public void doIdentify(String userId, String idKind, String idNo,
            String realName);

    // 前端用户注册
    public XN805041Res doCustomerRegister(String mobile, String loginPwd,
            String userReferee, String userRefereeKind, String smsCaptcha);

    // 将用户拉入黑名单
    public void addBlacklist(String userId, String type, String updater,
            String remark);

    // 前端用户代注册
    public String doAddUser(XN805042Req req);
}
