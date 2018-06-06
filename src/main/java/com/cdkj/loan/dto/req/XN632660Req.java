package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午7:23:21 
 * @history:
 */
public class XN632660Req {
    // 申请人
    @NotBlank
    private String applyUser;

    // 申请说明
    @NotBlank
    private String applyNote;

    // 备注
    @NotBlank
    private String remark;

    List<XN632660ReqDetail> userList;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<XN632660ReqDetail> getUserList() {
        return userList;
    }

    public void setUserList(List<XN632660ReqDetail> userList) {
        this.userList = userList;
    }

}
