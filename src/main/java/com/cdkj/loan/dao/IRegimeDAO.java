package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Regime;

//dao层 
public interface IRegimeDAO extends IBaseDAO<Regime> {
    String NAMESPACE = IRegimeDAO.class.getName().concat(".");

    public void update(Regime data);

    public void publishRemoveRegime(Regime data);
}
