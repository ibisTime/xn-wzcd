package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SaleUser;

public interface ISaleUserDAO extends IBaseDAO<SaleUser> {

    String NAMESPACE = ISaleUserDAO.class.getName().concat(".");

    // 设置登录密码
    public int updateLoginPwd(SaleUser data);

    // 更新手机号
    public int updateMobile(SaleUser data);

    // 更新头像
    public int updatePhoto(SaleUser data);

    // 更新状态
    public int updateStatus(SaleUser data);

    // 设置角色
    public void updateRole(SaleUser data);

    // 设置部门
    public void updateDepartment(SaleUser data);

}
