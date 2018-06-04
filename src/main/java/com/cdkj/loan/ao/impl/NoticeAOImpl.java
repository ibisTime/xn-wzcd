package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.INoticeAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INoticeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Notice;
import com.cdkj.loan.dto.req.XN632720Req;
import com.cdkj.loan.exception.BizException;

/**
 * 公告管理
 * @author: silver 
 * @since: 2018年6月4日 下午5:19:34 
 * @history:
 */
@Service
public class NoticeAOImpl implements INoticeAO {
    @Autowired
    private INoticeBO noticeBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addNotice(XN632720Req req) {
        Department department = departmentBO
            .getDepartment(req.getPublishDepartmentCode());
        if (null == department) {
            throw new BizException("xn0000", "部门不存在！");
        }

        Notice data = new Notice();
        data.setTitle(req.getTitle());
        data.setType(req.getType());
        data.setUrgentStatus(req.getUrgentStatus());
        data.setPublishDepartmentCode(req.getPublishDepartmentCode());
        data.setScope(req.getScope());

        data.setContent(req.getContent());
        data.setRemark(req.getRemark());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        return noticeBO.saveNotice(data);
    }

    @Override
    public Paginable<Notice> queryNoticePage(int start, int limit,
            Notice condition) {
        Paginable<Notice> page = noticeBO.getPaginable(start, limit, condition);
        List<Notice> list = page.getList();
        for (Notice notice : list) {
            Department department = departmentBO
                .getDepartment(notice.getPublishDepartmentCode());
            notice.setPublishDepartmentName(department.getName());
        }
        return page;
    }

    @Override
    public List<Notice> queryNoticeList(Notice condition) {
        List<Notice> list = noticeBO.queryNoticeList(condition);
        for (Notice notice : list) {
            Department department = departmentBO
                .getDepartment(notice.getPublishDepartmentCode());
            notice.setPublishDepartmentName(department.getName());
        }
        return list;
    }

    @Override
    public Notice getNotice(String code) {
        Notice notice = noticeBO.getNotice(code);
        Department department = departmentBO
            .getDepartment(notice.getPublishDepartmentCode());
        notice.setPublishDepartmentName(department.getName());
        return notice;
    }
}
