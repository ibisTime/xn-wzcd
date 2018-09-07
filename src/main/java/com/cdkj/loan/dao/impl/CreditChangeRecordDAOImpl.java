package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICreditChangeRecordDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CreditChangeRecord;



//CHECK 。。。 
@Repository("creditChangeRecordDAOImpl")
public class CreditChangeRecordDAOImpl extends AMybatisTemplate implements ICreditChangeRecordDAO {


	@Override
	public int insert(CreditChangeRecord data) {
		return super.insert(NAMESPACE.concat("insert_creditChangeRecord"), data);
	}


	@Override
	public int delete(CreditChangeRecord data) {
		return super.delete(NAMESPACE.concat("delete_creditChangeRecord"), data);
	}


	@Override
	public CreditChangeRecord select(CreditChangeRecord condition) {
		return super.select(NAMESPACE.concat("select_creditChangeRecord"), condition,CreditChangeRecord.class);
	}


	@Override
	public long selectTotalCount(CreditChangeRecord condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_creditChangeRecord_count"),condition);
	}


	@Override
	public List<CreditChangeRecord> selectList(CreditChangeRecord condition) {
		return super.selectList(NAMESPACE.concat("select_creditChangeRecord"), condition,CreditChangeRecord.class);
	}


	@Override
	public List<CreditChangeRecord> selectList(CreditChangeRecord condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_creditChangeRecord"), start, count,condition, CreditChangeRecord.class);
	}


}