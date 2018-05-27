package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Area;

/**
 * 身份证区域
 * @author: silver 
 * @since: 2018年5月27日 上午11:06:28 
 * @history:
 */
public interface IAreaAO {
    String DEFAULT_ORDER_COLUMN = "id";

    public int addArea(String areaNo, String areaName);

    public int dropArea(int id);

    public int editArea(int id, String areaNo, String areaName);

    public Area getArea(int id);

    public Paginable<Area> queryAreaPage(int start, int limit, Area condition);

    public List<Area> queryAreaList(Area condition);
}
