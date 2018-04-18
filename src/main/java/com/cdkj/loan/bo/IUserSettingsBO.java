package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.UserSettings;



public interface IUserSettingsBO extends IPaginableBO<UserSettings> {


	public boolean isUserSettingsExist(String code);

	public void saveUserSettings(UserSettings data);

	public int removeUserSettings(String userId, String type);

	//检查是否已经进行过该设置
	public long checkUserSetting(String userId,String type);

	public int refreshUserSettings(UserSettings data);


	public List<UserSettings> queryUserSettingsList(UserSettings condition);


//	public UserSettings getUserSettings(String code);


}