package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IArchiveDAO;
import com.cdkj.loan.domain.Archive;
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
    private IArchiveDAO ArchiveDAO;

    @Override
    public boolean isArchiveExist(String code) {
        Archive condition = new Archive();
        condition.setCode(code);
        if (ArchiveDAO.selectTotalCount(condition) > 0) {
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
            ArchiveDAO.insert(data);
        }
        return code;
    }

    @Override
    public void removeArchive(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Archive data = new Archive();
            data.setCode(code);
            count = ArchiveDAO.delete(data);
        }
    }

    @Override
    public void refreshArchive(Archive data) {

        if (StringUtils.isNotBlank(data.getCode())) {
            ArchiveDAO.update(data);
        }
    }

    @Override
    public List<Archive> queryArchiveList(Archive condition) {
        return ArchiveDAO.selectList(condition);
    }

    @Override
    public Archive getArchive(String code) {
        Archive data = null;
        if (StringUtils.isNotBlank(code)) {
            Archive condition = new Archive();
            condition.setCode(code);
            data = ArchiveDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public void refreshLeaveArchive(Archive data) {

        if (StringUtils.isNotBlank(data.getCode())) {
            ArchiveDAO.updateLeaveArchive(data);
        }
    }
}
