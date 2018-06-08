package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SYSUser;

public interface ISYSUserDAO extends IBaseDAO<SYSUser> {

    String NAMESPACE = ISYSUserDAO.class.getName().concat(".");

    // 更新状态
    public void updateStatus(SYSUser data);

    // 更新角色
    public void updateRole(SYSUser data);

    // 更新部门
    public void updatePost(SYSUser data);

    // 设置登录密码
    public void updateLoginPwd(SYSUser data);

    // 更新手机号
    public void updateMobile(SYSUser data);

    // 更新头像
    public void updatePhoto(SYSUser data);

    // 更新团队
    public void updateTeam(SYSUser data);
}
