package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IArchiveLocationAO;
import com.cdkj.loan.bo.IArchiveLocationBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ArchiveLocation;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.exception.BizException;

/**
 * 档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 上午1:00:33 
 * @history:
 */
@Service
public class ArchiveLocationAOImpl implements IArchiveLocationAO {

    @Autowired
    private IArchiveLocationBO archiveLocationBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addArchiveLocation(ArchiveLocation data) {
        return archiveLocationBO.saveArchiveLocation(data);
    }

    @Override
    public int editArchiveLocation(ArchiveLocation data) {
        if (!archiveLocationBO.isArchiveLocationExist(data.getCode())) {
            throw new BizException("xn0000", "人事档案位置不存在");
        }
        return archiveLocationBO.refreshArchiveLocation(data);
    }

    @Override
    public int dropArchiveLocation(String code) {
        if (!archiveLocationBO.isArchiveLocationExist(code)) {
            throw new BizException("xn0000", "人事档案位置不存在");
        }
        return archiveLocationBO.removeArchiveLocation(code);
    }

    @Override
    public Paginable<ArchiveLocation> queryArchiveLocationPage(int start,
            int limit, ArchiveLocation condition) {
        Paginable<ArchiveLocation> paginable = archiveLocationBO
            .getPaginable(start, limit, condition);
        List<ArchiveLocation> list = paginable.getList();
        for (ArchiveLocation archiveLocation : list) {
            init(archiveLocation);
        }

        return paginable;
    }

    @Override
    public List<ArchiveLocation> queryArchiveLocationList(
            ArchiveLocation condition) {
        return archiveLocationBO.queryArchiveLocationList(condition);
    }

    @Override
    public ArchiveLocation getArchiveLocation(String code) {
        ArchiveLocation archiveLocation = archiveLocationBO
            .getArchiveLocation(code);
        init(archiveLocation);
        return archiveLocation;
    }

    // 初始化数据
    private void init(ArchiveLocation archiveLocation) {
        // 业务公司名称
        if (StringUtils.isNotBlank(archiveLocation.getUpdater())) {
            SYSUser user = sysUserBO.getUser(archiveLocation.getUpdater());
            archiveLocation.setUpdaterName(user.getRealName());
        }

    }
}
