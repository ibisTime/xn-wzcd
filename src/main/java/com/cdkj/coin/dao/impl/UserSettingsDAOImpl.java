package com.cdkj.coin.dao.impl;

import com.cdkj.coin.dao.IUserSettingsDAO;
import com.cdkj.coin.dao.base.support.AMybatisTemplate;
import com.cdkj.coin.domain.UserSettings;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository("UserSettingsDAOImpl")
public class UserSettingsDAOImpl extends AMybatisTemplate implements IUserSettingsDAO {


	@Override
	public int insert(UserSettings data) {
		return super.insert(NAMESPACE.concat("insert_UserSettings"), data);
	}


	@Override
	public int delete(UserSettings data) {
		return super.delete(NAMESPACE.concat("delete_UserSettings"), data);
	}


	@Override
	public UserSettings select(UserSettings condition) {
		return super.select(NAMESPACE.concat("select_UserSettings"), condition,UserSettings.class);
	}


	@Override
	public long selectTotalCount(UserSettings condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_UserSettings_count"),condition);
	}


	@Override
	public List<UserSettings> selectList(UserSettings condition) {
		return super.selectList(NAMESPACE.concat("select_UserSettings"), condition,UserSettings.class);
	}


	@Override
	public List<UserSettings> selectList(UserSettings condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_UserSettings"), start, count,condition, UserSettings.class);
	}


}