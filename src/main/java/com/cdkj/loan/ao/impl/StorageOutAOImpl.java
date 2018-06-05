package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IStorageOutAO;
import com.cdkj.loan.bo.ICompCategoryBO;
import com.cdkj.loan.bo.ICompProductBO;
import com.cdkj.loan.bo.IStorageInBO;
import com.cdkj.loan.bo.IStorageOutBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CompCategory;
import com.cdkj.loan.domain.CompProduct;
import com.cdkj.loan.domain.StorageIn;
import com.cdkj.loan.domain.StorageOut;
import com.cdkj.loan.dto.req.XN632770Req;
import com.cdkj.loan.exception.BizException;

/**
 * 出库管理
 * @author: silver 
 * @since: 2018年6月5日 下午4:21:44 
 * @history:
 */
@Service
public class StorageOutAOImpl implements IStorageOutAO {
    @Autowired
    private IStorageOutBO storageOutBO;

    @Autowired
    private IStorageInBO storageInBO;

    @Autowired
    private ICompProductBO compProductBO;

    @Autowired
    private ICompCategoryBO compCategoryBO;

    @Override
    @Transactional
    public String addStorageOut(XN632770Req req) {
        StorageIn storageIn = storageInBO.getStorageIn(req.getStorageInCode());
        if (storageIn.getQuantity() < StringValidater
            .toInteger(req.getQuantity())) {
            throw new BizException("xn0000", "库存数量不足！");
        }

        StorageOut data = new StorageOut();
        data.setProductCode(storageIn.getProductCode());
        data.setCategoryCode(storageIn.getCategoryCode());
        data.setStorageInCode(req.getStorageInCode());
        data.setQuantity(StringValidater.toInteger(req.getQuantity()));
        data.setUpdater(req.getUpdater());

        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        data.setQuantity(StringValidater.toInteger(req.getQuantity()));
        data.setPrice(storageIn.getPrice());
        data.setTotalPrice(StringValidater.toInteger(req.getQuantity())
                * storageIn.getPrice());

        // 更新库存信息
        Integer currentQuantity = storageIn.getQuantity()
                - StringValidater.toInteger(req.getQuantity());
        storageIn.setQuantity(currentQuantity);
        storageIn.setTotalPrice(currentQuantity * storageIn.getPrice());
        storageIn.setCode(req.getStorageInCode());
        storageIn.setUpdateDatetime(new Date());
        storageInBO.refreshStorageIn(storageIn);

        return storageOutBO.saveStorageOut(data);
    }

    @Override
    public Paginable<StorageOut> queryStorageOutPage(int start, int limit,
            StorageOut condition) {
        Paginable<StorageOut> page = storageOutBO.getPaginable(start, limit,
            condition);

        List<StorageOut> storageOutList = page.getList();
        for (StorageOut storageOut : storageOutList) {
            assemble(storageOut);
        }

        return page;
    }

    @Override
    public List<StorageOut> queryStorageOutList(StorageOut condition) {
        List<StorageOut> storageOutList = storageOutBO
            .queryStorageOutList(condition);
        for (StorageOut storageOut : storageOutList) {
            assemble(storageOut);
        }
        return storageOutList;
    }

    @Override
    public StorageOut getStorageOut(String code) {
        StorageOut storageOut = storageOutBO.getStorageOut(code);
        assemble(storageOut);
        return storageOut;
    }

    private void assemble(StorageOut storageOut) {
        CompProduct compProduct = compProductBO
            .getCompProduct(storageOut.getProductCode());
        if (null != compProduct) {
            storageOut.setProductName(compProduct.getName());
        }

        CompCategory compCategory = compCategoryBO
            .getCompCategory(storageOut.getCategoryCode());
        if (null != compCategory) {
            storageOut.setCategoryName(compCategory.getName());
        }
    }
}
