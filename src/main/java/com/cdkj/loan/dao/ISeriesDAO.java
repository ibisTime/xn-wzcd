package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Series;

public interface ISeriesDAO extends IBaseDAO<Series> {

    String NAMESPACE = ISeriesDAO.class.getName().concat(".");

    public int update(Series data);

    public int updateUp(Series data);

    public int updateDown(Series data);
}
