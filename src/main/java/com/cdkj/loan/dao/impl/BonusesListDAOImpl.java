package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBonusesListDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BonusesList;



//CHECK 。。。 
@Repository("bonusesListDAOImpl")
public class BonusesListDAOImpl extends AMybatisTemplate implements IBonusesListDAO {


	@Override
	public int insert(BonusesList data) {
		return super.insert(NAMESPACE.concat("insert_bonusesList"), data);
	}


	@Override
	public int delete(BonusesList data) {
		return super.delete(NAMESPACE.concat("delete_bonusesList"), data);
	}


	@Override
	public BonusesList select(BonusesList condition) {
		return super.select(NAMESPACE.concat("select_bonusesList"), condition,BonusesList.class);
	}


	@Override
	public long selectTotalCount(BonusesList condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_bonusesList_count"),condition);
	}


	@Override
	public List<BonusesList> selectList(BonusesList condition) {
		return super.selectList(NAMESPACE.concat("select_bonusesList"), condition,BonusesList.class);
	}


	@Override
	public List<BonusesList> selectList(BonusesList condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_bonusesList"), start, count,condition, BonusesList.class);
	}


}