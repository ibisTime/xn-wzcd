package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IArchiveDAO;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午5:29:23 
 * @history:
 */
@Component
public class ArchiveBOImpl extends PaginableBOImpl<Archive>
        implements IArchiveBO {

    @Autowired
    private IArchiveDAO archiveDAO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public boolean isArchiveExist(String code) {
        Archive condition = new Archive();
        condition.setCode(code);
        if (archiveDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveArchive(Archive data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.RECRUITAPPLY.getCode());
            data.setCode(code);
            archiveDAO.insert(data);
        }
        return code;
    }

    @Override
    public void removeArchive(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Archive data = new Archive();
            data.setCode(code);
            count = archiveDAO.delete(data);
        }
    }

    @Override
    public void refreshArchive(Archive data) {

        if (StringUtils.isNotBlank(data.getCode())) {
            archiveDAO.update(data);
        }
    }

    @Override
    public List<Archive> queryArchiveList(Archive condition) {
        List<Archive> archiveList = archiveDAO.selectList(condition);
        for (Archive archive : archiveList) {
            archive.setDepartmentName(departmentBO
                .getDepartment(archive.getDepartmentCode()).getName());
            archive.setPostName(
                departmentBO.getDepartment(archive.getPostCode()).getName());
        }
        return archiveList;
    }

    @Override
    public Archive getArchive(String code) {
        Archive data = null;
        if (StringUtils.isNotBlank(code)) {
            Archive condition = new Archive();
            condition.setCode(code);
            condition.setIsDelete("1");
            data = archiveDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public void refreshLeaveArchive(Archive data) {

        if (StringUtils.isNotBlank(data.getCode())) {
            archiveDAO.updateLeaveArchive(data);
        }
    }

    @Override
    public Archive getArchiveByUserid(String userId) {
        Archive data = null;
        if (StringUtils.isNotBlank(userId)) {
            Archive condition = new Archive();
            condition.setUserId(userId);
            data = archiveDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public int getTotalCount(int ageStart, int ageEnd) {
        Archive condition = new Archive();
        condition.setAgeStart(ageStart);
        condition.setAgeEnd(ageEnd);
        return (int) archiveDAO.selectTotalCount(condition);

    }

    @Override
    public void doCheck(String userId) {
        Archive condition = new Archive();
        condition.setUserId(userId);
        long count = archiveDAO.selectTotalCount(condition);
        if (count == 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该申请人不在人事档案中！");
        }
    }

}
