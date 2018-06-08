package com.cdkj.loan.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSDictBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IScopePeopleBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.dao.INoticeReadDAO;
import com.cdkj.loan.dao.IScopePeopleDAO;
import com.cdkj.loan.domain.NoticeRead;
import com.cdkj.loan.domain.SYSDict;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.ScopePeople;
import com.cdkj.loan.dto.req.XN632720ReqScope;
import com.cdkj.loan.enums.ENoticeReadStatus;
import com.cdkj.loan.enums.EScopeType;
import com.cdkj.loan.exception.BizException;

/**
 * 公告范围
 * @author: silver 
 * @since: 2018年6月7日 下午1:59:08 
 * @history:
 */
@Component
public class ScopePeopleBOImpl extends PaginableBOImpl<ScopePeople>
        implements IScopePeopleBO {
    @Autowired
    private IScopePeopleDAO scopePeopleDAO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private INoticeReadDAO noticeReadDAO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSDictBO sysDictBO;

    @Override
    @Transactional
    public void saveScopePeople(String refCode, String refType,
            List<XN632720ReqScope> dataList) {
        List<ScopePeople> scopePeopleList = new ArrayList<ScopePeople>();
        for (XN632720ReqScope data : dataList) {
            if (!EScopeType.ALL.getCode().equals(data.getScopeType())
                    && (null == data.getPeopleCode())) {
                throw new BizException("xn0000", "具体类型人员编号不能为空！");
            }

            ScopePeople scopePeople = new ScopePeople();
            scopePeople.setType(data.getScopeType());
            scopePeople.setRefCode(refCode);
            scopePeople.setPeopleCode(data.getPeopleCode());
            scopePeopleList.add(scopePeople);
        }
        // 添加范围记录
        scopePeopleDAO.insertScopePeopleList(scopePeopleList);

        // 添加阅读记录
        saveNoticeRead(refCode, refType, scopePeopleList);
    }

    private void saveNoticeRead(String refCode, String refType,
            List<ScopePeople> scopePeopleList) {
        List<NoticeRead> noticeReadList = new ArrayList<NoticeRead>();
        SYSUser condition = new SYSUser();
        for (ScopePeople scopePeople : scopePeopleList) {
            if (EScopeType.ALL.getCode().equals(scopePeople.getType())) {// 所有人
                List<SYSUser> sysuserList = sysUserBO.queryUserList(condition);
                for (SYSUser sysuser : sysuserList) {
                    NoticeRead noticeRead = new NoticeRead();
                    noticeRead.setNoticeCode(refCode);
                    noticeRead.setStatus(ENoticeReadStatus.NO.getCode());
                    noticeRead.setUserId(sysuser.getUserId());
                    noticeRead.setRefType(refType);
                    noticeReadList.add(noticeRead);
                }
            } else if (EScopeType.PEOPLE.getCode()// 具体人
                .equals(scopePeople.getType())) {
                NoticeRead noticeRead = new NoticeRead();
                noticeRead.setNoticeCode(refCode);
                noticeRead.setStatus(ENoticeReadStatus.NO.getCode());
                noticeRead.setUserId(scopePeople.getPeopleCode());
                noticeRead.setRefType(refType);
                noticeReadList.add(noticeRead);
            } else {
                if (EScopeType.SUB_COMPANY.getCode()// 分公司
                    .equals(scopePeople.getType())) {
                    condition.setCompanyCode(scopePeople.getPeopleCode());
                } else if (EScopeType.DEPARTMENT.getCode()// 部门
                    .equals(scopePeople.getType())) {
                    condition.setDepartmentCode(scopePeople.getPeopleCode());
                } else if (EScopeType.POST.getCode()// 职位
                    .equals(scopePeople.getType())) {
                    condition.setPostCode(scopePeople.getPeopleCode());
                }

                List<SYSUser> sysuserList = sysUserBO.queryUserList(condition);
                for (SYSUser sysuser : sysuserList) {
                    NoticeRead noticeRead = new NoticeRead();
                    noticeRead.setNoticeCode(refCode);
                    noticeRead.setStatus(ENoticeReadStatus.NO.getCode());
                    noticeRead.setUserId(sysuser.getUserId());
                    noticeRead.setRefType(refType);
                    noticeReadList.add(noticeRead);
                }
            }
        }
        noticeReadDAO.insertNoticeReadList(noticeReadList);
    }

    @Override
    public List<ScopePeople> queryScopePeopleList(ScopePeople condition) {
        List<ScopePeople> scopePeopleList = scopePeopleDAO
            .selectList(condition);
        for (ScopePeople scopePeople : scopePeopleList) {
            if (EScopeType.SUB_COMPANY.getCode().equals(scopePeople.getType())
                    || EScopeType.DEPARTMENT.getCode()
                        .equals(scopePeople.getType())
                    || EScopeType.POST.getCode()
                        .equals(scopePeople.getType())) {
                scopePeople.setPeopleName(departmentBO
                    .getDepartment(scopePeople.getPeopleCode()).getName());
            } else if (EScopeType.PEOPLE.getCode()
                .equals(scopePeople.getType())) {
                scopePeople.setPeopleName(sysUserBO
                    .getUser(scopePeople.getPeopleCode()).getRealName());
            }

            // 转义类型名称
            SYSDict dictCondition = new SYSDict();
            dictCondition.setParentKey(SysConstants.SCOPE_PEOPLE_TYPE);
            List<SYSDict> scopeDicts = sysDictBO
                .querySYSDictList(dictCondition);
            for (SYSDict sysDict : scopeDicts) {
                if (sysDict.getDkey().equals(scopePeople.getType())) {
                    scopePeople.setTypeName(sysDict.getDvalue());
                }
            }
        }
        return scopePeopleList;
    }

    @Override
    @Transactional
    public void dropScopePeopleByRef(String refCode) {
        ScopePeople scopeCondition = new ScopePeople();
        scopeCondition.setRefCode(refCode);
        scopePeopleDAO.deleteScopePeopleByRef(scopeCondition);

        NoticeRead readCondition = new NoticeRead();
        readCondition.setNoticeCode(refCode);
        noticeReadDAO.deleteNoticeReadByRef(readCondition);
    }
}
