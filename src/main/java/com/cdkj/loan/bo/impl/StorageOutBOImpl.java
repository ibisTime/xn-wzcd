package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IStorageOutBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IStorageOutDAO;
import com.cdkj.loan.domain.StorageOut;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 出库管理
 * @author: silver 
 * @since: 2018年6月5日 下午4:19:58 
 * @history:
 */
@Component
public class StorageOutBOImpl extends PaginableBOImpl<StorageOut>
        implements IStorageOutBO {

    @Autowired
    private IStorageOutDAO storageOutDAO;

    @Override
    public boolean isStorageOutExist(String code) {
        StorageOut condition = new StorageOut();
        condition.setCode(code);
        if (storageOutDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveStorageOut(StorageOut data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.STORAGE_OUT.getCode());
            data.setCode(code);
            storageOutDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<StorageOut> queryStorageOutList(StorageOut condition) {
        return storageOutDAO.selectList(condition);
    }

    @Override
    public StorageOut getStorageOut(String code) {
        StorageOut data = null;
        if (StringUtils.isNotBlank(code)) {
            StorageOut condition = new StorageOut();
            condition.setCode(code);
            data = storageOutDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "库存记录不存在！");
            }
        }
        return data;
    }
}
