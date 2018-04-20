package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CUser;
import com.cdkj.loan.domain.User;

public interface ICUserDAO extends IBaseDAO<CUser> {
    String NAMESPACE = ICUserDAO.class.getName().concat(".");

    // 重置密码
    public int updateLoginPwd(User data);

    // 设置角色
    public int updateRole(User data);

    public int update(User data);
}
