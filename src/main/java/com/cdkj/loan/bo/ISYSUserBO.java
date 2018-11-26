package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.ESYSUserStatus;

public interface ISYSUserBO extends IPaginableBO<SYSUser> {

    public void refreshStatus(String userId, ESYSUserStatus status,
            String updater, String remark);

    public void refreshMobile(String userId, String mobile);

    public void refreshRole(String userId, String roleCode, String updater,
            String remark);

    public void refreshPost(String userId, String postCode,
            String departmentCode, String companyCode, String updater,
            String remark);

    public void resetAdminLoginPwd(SYSUser user, String loginPwd);

    public void isMobileExist(String mobile);

    public boolean isUserExist(String code);

    public void saveUser(SYSUser data);

    public List<SYSUser> queryUserList(SYSUser condition);

    public SYSUser getUser(String userId);

    public SYSUser getMoreUser(String userId);

    public SYSUser getUserByLoginName(String loginName);

    public SYSUser getUserByMobile(String mobile);

    public void refreshLoginPwd(SYSUser data, String loginPwd, String udpater,
            String remark);

    // 验证登录密码:拿loginPwd进行MD5后与数据库中userId得数据库支付密码比对
    public void checkLoginPwd(String userId, String loginPwd);

    public void refreshLoginPwd(String userId, String loginPwd);

    public void refreshPhoto(String userId, String photo);

    public void refreshTeam(String userId, String teamCode, String updater);
}
