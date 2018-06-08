package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IOvertimeApplyAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IOvertimeApplyBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.OvertimeApply;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.exception.BizException;

/**
 * 新增加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午8:23:25 
 * @history:
 */
@Service
public class OvertimeApplyAOImpl implements IOvertimeApplyAO {

    @Autowired
    private IOvertimeApplyBO overtimeApplyBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Override
    public String addOvertimeApply(OvertimeApply data) {
        return overtimeApplyBO.saveOvertimeApply(data);
    }

    @Override
    public int editOvertimeApply(OvertimeApply data) {
        if (!overtimeApplyBO.isOvertimeApplyExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return overtimeApplyBO.refreshOvertimeApply(data);
    }

    @Override
    public int dropOvertimeApply(String code) {
        if (!overtimeApplyBO.isOvertimeApplyExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return overtimeApplyBO.removeOvertimeApply(code);
    }

    @Override
    public Paginable<OvertimeApply> queryOvertimeApplyPage(int start,
            int limit, OvertimeApply condition) {
        Paginable<OvertimeApply> paginable = overtimeApplyBO.getPaginable(
            start, limit, condition);
        List<OvertimeApply> list = paginable.getList();
        for (OvertimeApply data : list) {
            init(data);
        }
        return paginable;
    }

    @Override
    public List<OvertimeApply> queryOvertimeApplyList(OvertimeApply condition) {
        return overtimeApplyBO.queryOvertimeApplyList(condition);
    }

    @Override
    public OvertimeApply getOvertimeApply(String code) {
        OvertimeApply data = overtimeApplyBO.getOvertimeApply(code);
        init(data);
        return data;
    }

    private void init(OvertimeApply overtimeApply) {
        SYSUser user = null;
        if (StringUtils.isNotBlank(overtimeApply.getApplyUser())) {
            String applyUserCode = overtimeApply.getApplyUser();
            user = sysUserBO.getUser(applyUserCode);
            overtimeApply.setApplyUserName(user.getRealName());
        }
        if (StringUtils.isNotBlank(overtimeApply.getDepartmentName())) {
            Department department = departmentBO.getDepartment(user
                .getDepartmentCode());
            Department post = departmentBO.getDepartment(user.getPostCode());
            overtimeApply.setDepartmentName(department.getName());
            overtimeApply.setPostName(post.getName());
        }

        Archive archiveConditon = new Archive();
        archiveConditon.setUserId(user.getUserId());
        List<Archive> archiveList = archiveBO.queryArchiveList(archiveConditon);
        if (!archiveList.isEmpty()) {
            Archive archive = archiveList.get(0);
            overtimeApply.setJobNo(archive.getJobNo());
        }

    }
}
