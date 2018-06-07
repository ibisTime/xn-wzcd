package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 公告阅读记录
* @author: silver 
* @since: 2018-06-07 15:43:51
* @history:
*/
public class NoticeRead extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private Integer id;

    // 用户编号
    private String userId;

    // 状态(0=未读，1=已读)
    private String status;

    // 公告编号
    private String noticeCode;

    // 公告
    private Notice notice;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode;
    }

    public String getNoticeCode() {
        return noticeCode;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

}
