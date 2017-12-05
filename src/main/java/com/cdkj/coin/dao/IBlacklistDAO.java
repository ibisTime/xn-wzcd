package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.Blacklist;

public interface IBlacklistDAO extends IBaseDAO<Blacklist> {
    String NAMESPACE = IBlacklistDAO.class.getName().concat(".");
}
