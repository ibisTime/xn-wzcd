package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.UserSettings;

public interface IUserSettingsDAO extends IBaseDAO<UserSettings> {
	String NAMESPACE = IUserSettingsDAO.class.getName().concat(".");
}