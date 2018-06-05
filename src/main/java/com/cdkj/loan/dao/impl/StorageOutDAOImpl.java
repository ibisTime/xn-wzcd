package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IStorageOutDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.StorageOut;

/**
 * 出库
 * @author: silver 
 * @since: 2018年6月5日 下午4:18:54 
 * @history:
 */
@Repository("storageOutDAOImpl")
public class StorageOutDAOImpl extends AMybatisTemplate
        implements IStorageOutDAO {

    @Override
    public int insert(StorageOut data) {
        return super.insert(NAMESPACE.concat("insert_StorageOut"), data);
    }

    @Override
    public int delete(StorageOut data) {
        return super.delete(NAMESPACE.concat("delete_StorageOut"), data);
    }

    @Override
    public StorageOut select(StorageOut condition) {
        return super.select(NAMESPACE.concat("select_StorageOut"), condition,
            StorageOut.class);
    }

    @Override
    public long selectTotalCount(StorageOut condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_StorageOut_count"), condition);
    }

    @Override
    public List<StorageOut> selectList(StorageOut condition) {
        return super.selectList(NAMESPACE.concat("select_StorageOut"),
            condition, StorageOut.class);
    }

    @Override
    public List<StorageOut> selectList(StorageOut condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_StorageOut"), start,
            count, condition, StorageOut.class);
    }

}
