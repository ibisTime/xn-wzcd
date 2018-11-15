package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICityListDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CityList;



//CHECK 。。。 
@Repository("cityListDAOImpl")
public class CityListDAOImpl extends AMybatisTemplate implements ICityListDAO {


	@Override
	public int insert(CityList data) {
		return super.insert(NAMESPACE.concat("insert_cityList"), data);
	}


	@Override
	public int delete(CityList data) {
		return super.delete(NAMESPACE.concat("delete_cityList"), data);
	}


	@Override
	public CityList select(CityList condition) {
		return super.select(NAMESPACE.concat("select_cityList"), condition,CityList.class);
	}


	@Override
	public long selectTotalCount(CityList condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_cityList_count"),condition);
	}


	@Override
	public List<CityList> selectList(CityList condition) {
		return super.selectList(NAMESPACE.concat("select_cityList"), condition,CityList.class);
	}


	@Override
	public List<CityList> selectList(CityList condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_cityList"), start, count,condition, CityList.class);
	}


}