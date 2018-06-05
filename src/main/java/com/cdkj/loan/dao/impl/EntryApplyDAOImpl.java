package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IEntryApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.EntryApply;



//CHECK 。。。 
@Repository("entryApplyDAOImpl")
public class EntryApplyDAOImpl extends AMybatisTemplate implements IEntryApplyDAO {


	@Override
	public int insert(EntryApply data) {
		return super.insert(NAMESPACE.concat("insert_entryApply"), data);
	}


	@Override
	public int delete(EntryApply data) {
		return super.delete(NAMESPACE.concat("delete_entryApply"), data);
	}


	@Override
	public EntryApply select(EntryApply condition) {
		return super.select(NAMESPACE.concat("select_entryApply"), condition,EntryApply.class);
	}


	@Override
	public long selectTotalCount(EntryApply condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_entryApply_count"),condition);
	}


	@Override
	public List<EntryApply> selectList(EntryApply condition) {
		return super.selectList(NAMESPACE.concat("select_entryApply"), condition,EntryApply.class);
	}


	@Override
	public List<EntryApply> selectList(EntryApply condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_entryApply"), start, count,condition, EntryApply.class);
	}


}