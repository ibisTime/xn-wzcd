package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.TableExport;

public interface ITableExportBO extends IPaginableBO<TableExport> {

    public int saveTableExport(TableExport data);

    public List<TableExport> queryTableExportList(TableExport condition);

    public TableExport getTableExport(int id);

}
