package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ITableExportDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.TableExport;



//CHECK 。。。 
@Repository("tableExportDAOImpl")
public class TableExportDAOImpl extends AMybatisTemplate implements ITableExportDAO {


	@Override
	public int insert(TableExport data) {
		return super.insert(NAMESPACE.concat("insert_tableExport"), data);
	}


	@Override
	public int delete(TableExport data) {
		return super.delete(NAMESPACE.concat("delete_tableExport"), data);
	}


	@Override
	public TableExport select(TableExport condition) {
		return super.select(NAMESPACE.concat("select_tableExport"), condition,TableExport.class);
	}


	@Override
	public long selectTotalCount(TableExport condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_tableExport_count"),condition);
	}


	@Override
	public List<TableExport> selectList(TableExport condition) {
		return super.selectList(NAMESPACE.concat("select_tableExport"), condition,TableExport.class);
	}


	@Override
	public List<TableExport> selectList(TableExport condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_tableExport"), start, count,condition, TableExport.class);
	}


}