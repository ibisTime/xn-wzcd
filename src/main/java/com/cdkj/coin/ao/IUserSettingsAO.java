package com.cdkj.coin.ao;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.UserSettings;

import java.util.List;



public interface IUserSettingsAO {

	static final String DEFAULT_ORDER_COLUMN = "id";

	public void addUserSettings(String userId, String type);

	public void dropUserSettings(String userId, String type);

//	public int editUserSettings(UserSettings data);

	public Paginable<UserSettings> queryUserSettingsPage(int start, int limit, UserSettings condition);

	public List<UserSettings> queryUserSettingsList(UserSettings condition);

//	public UserSettings getUserSettings(String code);

}