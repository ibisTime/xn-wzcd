package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.StorageOut;

/**
 * 出库管理
 * @author: silver 
 * @since: 2018年6月5日 下午4:19:25 
 * @history:
 */
public interface IStorageOutBO extends IPaginableBO<StorageOut> {

    public boolean isStorageOutExist(String code);

    public String saveStorageOut(StorageOut data);

    public List<StorageOut> queryStorageOutList(StorageOut condition);

    public StorageOut getStorageOut(String code);

}
