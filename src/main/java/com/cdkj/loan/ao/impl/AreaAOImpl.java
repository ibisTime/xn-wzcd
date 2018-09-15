package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.bo.IAreaBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Area;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

/**
 * 身份证区域
 * @author: silver 
 * @since: 2018年5月27日 上午11:12:13 
 * @history:
 */
@Service
public class AreaAOImpl implements IAreaAO {

    @Autowired
    private IAreaBO areaBO;

    @Override
    @Transactional
    public int addArea(String areaNo, String areaName) {
        Area data = new Area();
        data.setAreaNo(areaNo);
        Area area = areaBO.getArea(data);
        if (area != null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "身份证区域号已存在，请勿重复添加!");
        }
        data.setAreaNo(null);// 置空，只查名称
        data.setAreaName(areaName);
        Area domain = areaBO.getArea(data);
        if (null != domain) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "身份证区域名称已存在，请勿重复添加!");
        }
        data.setAreaNo(areaNo);// 填充
        return areaBO.saveArea(data);
    }

    @Override
    public int dropArea(int id) {
        Area condition = new Area();
        condition.setId(id);
        return areaBO.dropArea(condition);
    }

    @Override
    public int editArea(int id, String areaNo, String areaName) {
        Area data = new Area();
        data.setId(id);
        data.setAreaNo(areaNo);
        data.setAreaName(areaName);

        return areaBO.editArea(data);
    }

    @Override
    public Area getArea(int id) {
        Area condition = new Area();
        condition.setId(id);
        return areaBO.getArea(condition);
    }

    @Override
    public Paginable<Area> queryAreaPage(int start, int limit, Area condition) {
        return areaBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Area> queryAreaList(Area condition) {
        return areaBO.queryAreaList(condition);
    }
}
