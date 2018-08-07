package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISYSMenuBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ISYSMenuDAO;
import com.cdkj.loan.domain.SYSMenu;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

/**
 * @author: Gejin 
 * @since: 2016年4月16日 下午7:56:45 
 * @history:
 */
@Component
public class SYSMenuBOImpl extends PaginableBOImpl<SYSMenu>
        implements ISYSMenuBO {

    @Autowired
    private ISYSMenuDAO sysMenuDAO;

    /** 
     * @see com.std.user.bo.ISYSMenuBO#isSYSMenuExist(java.lang.String)
     */
    @Override
    public boolean isSYSMenuExist(String code) {
        SYSMenu menu = new SYSMenu();
        menu.setCode(code);
        if (sysMenuDAO.selectTotalCount(menu) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.std.user.bo.ISYSMenuBO#saveSYSMenu(com.xnjr.std.security.domain.SYSMenu)
     */
    @Override
    public int saveSYSMenu(SYSMenu data) {
        int count = 0;
        if (data != null) {
            data.setCode(OrderNoGenerater.generate("SM"));
            data.setUpdateDatetime(new Date());
            count = sysMenuDAO.insert(data);
        }
        return count;
    }

    /** 
     * @see com.std.user.bo.ISYSMenuBO#removeSYSMenu(java.lang.String)
     */
    @Override
    public int removeSYSMenu(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            SYSMenu data = new SYSMenu();
            data.setCode(code);
            count = sysMenuDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.std.user.bo.ISYSMenuBO#refreshSYSMenu(com.xnjr.std.security.domain.SYSMenu)
     */
    @Override
    public int refreshSYSMenu(SYSMenu data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getCode())) {
            data.setUpdateDatetime(new Date());
            count = sysMenuDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.std.user.bo.ISYSMenuBO#getSYSMenu(java.lang.String)
     */
    @Override
    public SYSMenu getSYSMenu(String code) {
        SYSMenu data = null;
        if (StringUtils.isNotBlank(code)) {
            SYSMenu condition = new SYSMenu();
            condition.setCode(code);
            data = sysMenuDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.std.user.bo.ISYSMenuBO#querySYSMenuList(com.xnjr.std.security.domain.SYSMenu)
     */
    @Override
    public List<SYSMenu> querySYSMenuList(SYSMenu data) {
        return sysMenuDAO.selectList(data);
    }

    @Override
    public SYSMenu getSYSMenuByUrl(String url) {
        SYSMenu data = new SYSMenu();
        data.setUrl(url);
        SYSMenu menu = sysMenuDAO.select(data);
        if (menu == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据URL查询的菜单不存在！");
        }
        return menu;
    }
}
