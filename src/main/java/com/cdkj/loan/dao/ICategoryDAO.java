/**
 * @Title ICategoryDAO.java 
 * @Package com.xnjr.mall.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年11月16日 下午3:49:59 
 * @version V1.0   
 */
package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Category;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月16日 下午3:49:59 
 * @history:
 */
public interface ICategoryDAO extends IBaseDAO<Category> {
    String NAMESPACE = ICategoryDAO.class.getName().concat(".");

    public int update(Category data);

    public int putOn(Category data);

    public int putOff(Category data);
}
