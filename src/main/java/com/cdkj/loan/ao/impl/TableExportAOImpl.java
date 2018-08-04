package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ITableExportAO;
import com.cdkj.loan.bo.ITableExportBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.TableExport;

@Service
public class TableExportAOImpl implements ITableExportAO {

    @Autowired
    private ITableExportBO tableExportBO;

    @Override
    public int addTableExport(String url, String operator) {
        TableExport data = new TableExport();
        data.setUrl(url);
        data.setOperator(operator);
        data.setUpdateDatetime(new Date());
        return tableExportBO.saveTableExport(data);
    }

    @Override
    public Paginable<TableExport> queryTableExportPage(int start, int limit,
            TableExport condition) {
        return tableExportBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<TableExport> queryTableExportList(TableExport condition) {
        return tableExportBO.queryTableExportList(condition);
    }

    @Override
    public TableExport getTableExport(int id) {
        return tableExportBO.getTableExport(id);
    }
}
