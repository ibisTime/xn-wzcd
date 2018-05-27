package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Area;

/**
 * 身份证区域
 * @author: silver 
 * @since: 2018年5月26日 下午5:50:22 
 * @history:
 */
public interface IAreaBO extends IPaginableBO<Area> {
    public int saveArea(Area data);

    public int dropArea(Area data);

    public Area getArea(Area condition);

    public int editArea(Area data);

    public List<Area> queryAreaList(Area condition);
}
