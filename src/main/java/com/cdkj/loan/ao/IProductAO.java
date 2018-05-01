/**
 * @Title IProductAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:33:00 
 * @version V1.0   
 */
package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.dto.req.XN808010Req;
import com.cdkj.loan.dto.req.XN808012Req;
import com.cdkj.loan.dto.req.XN808013Req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:33:00 
 * @history:
 */
public interface IProductAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<Product> queryProductPage(int start, int limit,
            Product condition);

    public List<Product> queryProductList(Product condition);

    public Product getProduct(String code, String userId);

    public String addProduct(XN808010Req req);

    public void dropProduct(String code);

    public void editProduct(XN808012Req req);

    public void putOn(XN808013Req req);

    public void putOff(String code, String updater, String remark);

    public void inRecyle(String code, String updater, String remark);

    public void outRecyle(String code, String updater, String remark);

}
