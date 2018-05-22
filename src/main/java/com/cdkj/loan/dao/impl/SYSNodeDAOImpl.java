package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISYSNodeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SYSNode;



//CHECK 。。。 
@Repository("SYSNodeDAOImpl")
public class SYSNodeDAOImpl extends AMybatisTemplate implements ISYSNodeDAO {


	@Override
	public int insert(SYSNode data) {
		return super.insert(NAMESPACE.concat("insert_SYSNode"), data);
	}


	@Override
	public int delete(SYSNode data) {
		return super.delete(NAMESPACE.concat("delete_SYSNode"), data);
	}


	@Override
	public SYSNode select(SYSNode condition) {
		return super.select(NAMESPACE.concat("select_SYSNode"), condition,SYSNode.class);
	}


	@Override
	public long selectTotalCount(SYSNode condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_SYSNode_count"),condition);
	}


	@Override
	public List<SYSNode> selectList(SYSNode condition) {
		return super.selectList(NAMESPACE.concat("select_SYSNode"), condition,SYSNode.class);
	}


	@Override
	public List<SYSNode> selectList(SYSNode condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_SYSNode"), start, count,condition, SYSNode.class);
	}


}