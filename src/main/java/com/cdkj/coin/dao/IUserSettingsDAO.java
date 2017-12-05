package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.UserSettings;

public interface IUserSettingsDAO extends IBaseDAO<UserSettings> {
	String NAMESPACE = IUserSettingsDAO.class.getName().concat(".");
}