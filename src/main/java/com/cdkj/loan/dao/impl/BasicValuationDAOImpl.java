package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBasicValuationDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BasicValuation;



//CHECK 。。。 
@Repository("basicValuationDAOImpl")
public class BasicValuationDAOImpl extends AMybatisTemplate implements IBasicValuationDAO {


	@Override
	public int insert(BasicValuation data) {
		return super.insert(NAMESPACE.concat("insert_basicValuation"), data);
	}


	@Override
	public int delete(BasicValuation data) {
		return super.delete(NAMESPACE.concat("delete_basicValuation"), data);
	}


	@Override
	public BasicValuation select(BasicValuation condition) {
		return super.select(NAMESPACE.concat("select_basicValuation"), condition,BasicValuation.class);
	}


	@Override
	public long selectTotalCount(BasicValuation condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_basicValuation_count"),condition);
	}


	@Override
	public List<BasicValuation> selectList(BasicValuation condition) {
		return super.selectList(NAMESPACE.concat("select_basicValuation"), condition,BasicValuation.class);
	}


	@Override
	public List<BasicValuation> selectList(BasicValuation condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_basicValuation"), start, count,condition, BasicValuation.class);
	}


}