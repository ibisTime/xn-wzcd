package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.TableExport;

@Component
public interface ITableExportAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public int addTableExport(String url, String operator);

    public Paginable<TableExport> queryTableExportPage(int start, int limit,
            TableExport condition);

    public List<TableExport> queryTableExportList(TableExport condition);

    public TableExport getTableExport(int id);

}
