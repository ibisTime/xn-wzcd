package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SaleUser;
import com.cdkj.loan.enums.EUserStatus;

public interface ISaleUserBO extends IPaginableBO<SaleUser> {

    // C端用户注册
    public String doRegister(String mobile, String loginPwd, String type);

    // 判断手机号是否存在
    public void isMobileExist(String mobile, String type);

    // 更新手机号
    public int refreshMobile(String userId, String mobile);

    // 更新登录密码
    public int refreshLoginPwd(String userId, String loginPwd);

    // 管理员重置登录密码
    public void refreshLoginPwdOss(SaleUser saleUser, String loginPwd,
            String udpater, String remark);

    // 更新头像
    public void refreshPhoto(String userId, String photo);

    // 更新状态
    public void refreshStatus(String userId, EUserStatus normal, String updater,
            String remark);

    // 验证登录密码:拿loginPwd进行MD5后与数据库中userId得数据库支付密码比对
    public void checkLoginPwd(String userId, String loginPwd);

    public List<SaleUser> querySaleUserList(SaleUser condition);

    public String getUserIdByMobile(String mobile);

    // 获取用户，不检查是否存在
    public SaleUser getSaleUser(String mobile, String type);

    // 获取UserId并检查是否存在
    public String getUserId(String mobile, String type);

    public SaleUser getSaleUser(String userId);

    public String saveSaleUser(String mobile);

    public void refreshRole(String userId, String roleCode, String updater,
            String remark);

    public void refreshDepartment(String userId, String departmentCode,
            String updater, String remark);

}
