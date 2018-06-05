package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IStorageInAO;
import com.cdkj.loan.bo.ICompCategoryBO;
import com.cdkj.loan.bo.ICompProductBO;
import com.cdkj.loan.bo.IStorageInBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CompCategory;
import com.cdkj.loan.domain.CompProduct;
import com.cdkj.loan.domain.StorageIn;
import com.cdkj.loan.dto.req.XN632760Req;
import com.cdkj.loan.exception.BizException;

/**
 * 入库管理
 * @author: silver 
 * @since: 2018年6月5日 下午2:27:11 
 * @history:
 */
@Service
public class StorageInAOImpl implements IStorageInAO {
    @Autowired
    private IStorageInBO storageInBO;

    @Autowired
    private ICompProductBO compProductBO;

    @Autowired
    private ICompCategoryBO compCategoryBO;

    @Override
    public String addStorageIn(XN632760Req req) {
        CompProduct compProduct = compProductBO
            .getCompProduct(req.getProductCode());
        if (null == compProduct) {
            throw new BizException("xn0000", "品名不存在！");
        }
        StorageIn data = new StorageIn();
        data.setProductCode(req.getProductCode());
        data.setCategoryCode(compProduct.getCategoryCode());
        data.setQuantity(StringValidater.toInteger(req.getQuantity()));
        data.setPrice(StringValidater.toLong(req.getPrice()));
        data.setTotalPrice(StringValidater.toLong(req.getPrice())
                * StringValidater.toInteger(req.getQuantity()));

        data.setValidDateStart(DateUtil.strToDate(req.getValidDateStart(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setValidDateEnd(DateUtil.strToDate(req.getValidDateEnd(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return storageInBO.saveStorageIn(data);
    }

    @Override
    public Paginable<StorageIn> queryStorageInPage(int start, int limit,
            StorageIn condition) {
        Paginable<StorageIn> page = storageInBO.getPaginable(start, limit,
            condition);
        List<StorageIn> storageInList = page.getList();
        for (StorageIn storageIn : storageInList) {
            assemble(storageIn);
        }

        return page;
    }

    @Override
    public List<StorageIn> queryStorageInList(StorageIn condition) {
        List<StorageIn> storageInList = storageInBO
            .queryStorageInList(condition);
        for (StorageIn storageIn : storageInList) {
            assemble(storageIn);
        }
        return storageInList;
    }

    @Override
    public StorageIn getStorageIn(String code) {
        StorageIn storageIn = storageInBO.getStorageIn(code);
        assemble(storageIn);
        return storageIn;
    }

    private void assemble(StorageIn storageIn) {
        CompProduct compProduct = compProductBO
            .getCompProduct(storageIn.getProductCode());
        if (null != compProduct) {
            storageIn.setProductName(compProduct.getName());
        }

        CompCategory compCategory = compCategoryBO
            .getCompCategory(storageIn.getCategoryCode());
        if (null != compCategory) {
            storageIn.setCategoryName(compCategory.getName());
        }
    }
}
