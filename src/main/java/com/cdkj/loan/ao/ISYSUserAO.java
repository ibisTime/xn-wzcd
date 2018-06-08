package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSUser;

@Component
public interface ISYSUserAO {

    static final String DEFAULT_ORDER_COLUMN = "user_id";

    // 用户登录
    public String doLogin(String type, String loginName, String loginPwd);

    // 注销/激活用户
    public void doCloseOpen(String userId, String updater, String remark);

    // 设置角色
    public void doRoleUser(String userId, String roleCode, String updater,
            String remark);

    // 设置部门岗位
    public void doModifyPost(String userId, String postCode, String updater,
            String remark);

    // 重置登录密码
    public void resetAdminLoginPwd(String userId, String newLoginPwd);

    // 检查手机号是否存在
    public void doCheckMobile(String mobile);

    // 根据手机号修改登录密码
    public void doResetLoginPwd(String mobile, String smsCaptcha,
            String newLoginPwd);

    // 更换手机号
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha);

    // 修改登录密码
    public void doModifyLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd);

    // 管理员重置用户密码
    public void doResetLoginPwdByOss(String userId, String loginPwd,
            String udpater, String remark);

    // 修改头像
    public void doModifyPhoto(String userId, String photo);

    public Paginable<SYSUser> queryUserPage(int start, int limit,
            SYSUser condition);

    public List<SYSUser> queryUserList(SYSUser condition);

    public SYSUser getUser(String code);

    public String doAddUser(String type, String loginName, String loginPwd,
            String mobile, String realName, String roleCode,
            String companyCode, String departmentCode, String postCode);

    // 设置团队
    public void doModifyTeam(String userId, String teamCode, String updater);

}
