package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ITableExportAO;
import com.cdkj.loan.bo.ISYSMenuBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ITableExportBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSMenu;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.TableExport;

@Service
public class TableExportAOImpl implements ITableExportAO {

    @Autowired
    private ITableExportBO tableExportBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSMenuBO sysMenuBO;

    @Override
    public String addTableExport(String url, String operator) {
        TableExport data = new TableExport();
        data.setUrl(url);
        data.setOperator(operator);
        data.setUpdateDatetime(new Date());
        tableExportBO.saveTableExport(data);
        // 菜单名称
        if (StringUtils.isNotBlank(data.getUrl())) {
            SYSMenu menu = sysMenuBO.getSYSMenuByUrl(data.getUrl() + ".htm");
            data.setMenuName(menu.getName());
        }
        return data.getMenuName();
    }

    @Override
    public Paginable<TableExport> queryTableExportPage(int start, int limit,
            TableExport condition) {
        Paginable<TableExport> paginable = tableExportBO.getPaginable(start,
            limit, condition);
        for (TableExport tableExport : paginable.getList()) {
            // 真实姓名
            if (StringUtils.isNotBlank(tableExport.getOperator())) {
                SYSUser user = sysUserBO.getUser(tableExport.getOperator());
                tableExport.setRealName(user.getRealName());
            }
            // 菜单名称
            if (StringUtils.isNotBlank(tableExport.getUrl())) {
                String url = tableExport.getUrl() + ".htm";
                SYSMenu menu = sysMenuBO.getSYSMenuByUrl(url);
                tableExport.setMenuName(menu.getName());
            }
        }
        return paginable;
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
