package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IArchiveLocationBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IArchiveLocationDAO;
import com.cdkj.loan.domain.ArchiveLocation;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 上午1:01:15 
 * @history:
 */
@Component
public class ArchiveLocationBOImpl extends PaginableBOImpl<ArchiveLocation>
        implements IArchiveLocationBO {

    @Autowired
    private IArchiveLocationDAO archiveLocationDAO;

    @Override
    public boolean isArchiveLocationExist(String code) {
        ArchiveLocation condition = new ArchiveLocation();
        condition.setCode(code);
        if (archiveLocationDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveArchiveLocation(ArchiveLocation data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.ARCHIVE_LOCATION
                .getCode());
            data.setCode(code);
            archiveLocationDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeArchiveLocation(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ArchiveLocation data = new ArchiveLocation();
            data.setCode(code);
            count = archiveLocationDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshArchiveLocation(ArchiveLocation data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = archiveLocationDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ArchiveLocation> queryArchiveLocationList(
            ArchiveLocation condition) {
        return archiveLocationDAO.selectList(condition);
    }

    @Override
    public ArchiveLocation getArchiveLocation(String code) {
        ArchiveLocation data = null;
        if (StringUtils.isNotBlank(code)) {
            ArchiveLocation condition = new ArchiveLocation();
            condition.setCode(code);
            data = archiveLocationDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }
}
