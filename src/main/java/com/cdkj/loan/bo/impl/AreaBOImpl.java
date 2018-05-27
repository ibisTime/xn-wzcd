package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAreaBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IAreaDAO;
import com.cdkj.loan.domain.Area;

@Component
public class AreaBOImpl extends PaginableBOImpl<Area> implements IAreaBO {

    @Autowired
    private IAreaDAO areaDAO;

    @Override
    public int saveArea(Area data) {
        return areaDAO.insert(data);
    }

    @Override
    public int dropArea(Area data) {
        return areaDAO.delete(data);
    }

    @Override
    public Area getArea(Area condition) {
        return areaDAO.select(condition);
    }

    @Override
    public int editArea(Area data) {
        return areaDAO.updateArea(data);
    }

    @Override
    public List<Area> queryAreaList(Area condition) {
        return areaDAO.selectList(condition);
    }
}
