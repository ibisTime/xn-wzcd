package com.cdkj.coin.domain;

import java.util.Date;

import com.cdkj.coin.dao.base.ABaseDO;

/**
* 以太坊地址
* @author: haiqingzheng
* @since: 2017年10月23日 21:53:23
* @history:
*/
public class EthAddress extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // ID主键
    private Long id;

    // 用户编号
    private String userId;

    // 以太坊地址
    private String address;

    // 密码
    private String password;

    // 创建时间
    private Date createDatetime;

    // 更新时间
    private Date updateDatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}
