package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IStorageInBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IStorageInDAO;
import com.cdkj.loan.domain.StorageIn;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 入库管理
 * @author: silver 
 * @since: 2018年6月5日 下午2:22:25 
 * @history:
 */
@Component
public class StorageInBOImpl extends PaginableBOImpl<StorageIn>
        implements IStorageInBO {

    @Autowired
    private IStorageInDAO storageInDAO;

    @Override
    public boolean isStorageInExist(String code) {
        StorageIn condition = new StorageIn();
        condition.setCode(code);
        if (storageInDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveStorageIn(StorageIn data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.STORAGE_IN.getCode());
            data.setCode(code);
            storageInDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshStorageIn(StorageIn data) {
        if (null != data) {
            storageInDAO.update(data);
        }
    }

    @Override
    public List<StorageIn> queryStorageInList(StorageIn condition) {
        return storageInDAO.selectList(condition);
    }

    @Override
    public StorageIn getStorageIn(String code) {
        StorageIn data = null;
        if (StringUtils.isNotBlank(code)) {
            StorageIn condition = new StorageIn();
            condition.setCode(code);
            data = storageInDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "库存不存在");
            }
        }
        return data;
    }
}
