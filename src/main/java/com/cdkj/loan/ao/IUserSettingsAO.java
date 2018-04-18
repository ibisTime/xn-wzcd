package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.UserSettings;



public interface IUserSettingsAO {

	static final String DEFAULT_ORDER_COLUMN = "id";

	public void addUserSettings(String userId, String type);

	public void dropUserSettings(String userId, String type);

	public Paginable<UserSettings> queryUserSettingsPage(int start, int limit, UserSettings condition);

	public List<UserSettings> queryUserSettingsList(UserSettings condition);


}