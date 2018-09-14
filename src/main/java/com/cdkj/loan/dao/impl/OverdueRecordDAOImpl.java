package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IOverdueRecordDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.OverdueRecord;



//CHECK 。。。 
@Repository("overdueRecordDAOImpl")
public class OverdueRecordDAOImpl extends AMybatisTemplate implements IOverdueRecordDAO {


	@Override
	public int insert(OverdueRecord data) {
		return super.insert(NAMESPACE.concat("insert_overdueRecord"), data);
	}


	@Override
	public int delete(OverdueRecord data) {
		return super.delete(NAMESPACE.concat("delete_overdueRecord"), data);
	}


	@Override
	public OverdueRecord select(OverdueRecord condition) {
		return super.select(NAMESPACE.concat("select_overdueRecord"), condition,OverdueRecord.class);
	}


	@Override
	public long selectTotalCount(OverdueRecord condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_overdueRecord_count"),condition);
	}


	@Override
	public List<OverdueRecord> selectList(OverdueRecord condition) {
		return super.selectList(NAMESPACE.concat("select_overdueRecord"), condition,OverdueRecord.class);
	}


	@Override
	public List<OverdueRecord> selectList(OverdueRecord condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_overdueRecord"), start, count,condition, OverdueRecord.class);
	}


}