package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ITableExportBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ITableExportDAO;
import com.cdkj.loan.domain.TableExport;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class TableExportBOImpl extends PaginableBOImpl<TableExport>
        implements ITableExportBO {

    @Autowired
    private ITableExportDAO tableExportDAO;

    public int saveTableExport(TableExport data) {
        return tableExportDAO.insert(data);
    }

    @Override
    public List<TableExport> queryTableExportList(TableExport condition) {
        return tableExportDAO.selectList(condition);
    }

    @Override
    public TableExport getTableExport(int id) {
        TableExport data = null;
        if (id != 0) {
            TableExport condition = new TableExport();
            condition.setId(id);
            data = tableExportDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "表格导出编号不存在！");
            }
        }
        return data;
    }
}
