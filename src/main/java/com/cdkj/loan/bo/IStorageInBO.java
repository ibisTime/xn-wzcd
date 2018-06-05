package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.StorageIn;

/**
 * 入库管理
 * @author: silver 
 * @since: 2018年6月5日 下午2:21:31 
 * @history:
 */
public interface IStorageInBO extends IPaginableBO<StorageIn> {

    public boolean isStorageInExist(String code);

    public String saveStorageIn(StorageIn data);

    public void refreshStorageIn(StorageIn data);

    public List<StorageIn> queryStorageInList(StorageIn condition);

    public StorageIn getStorageIn(String code);
}
