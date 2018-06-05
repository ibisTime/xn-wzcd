package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IStorageInDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.StorageIn;

/**
 * 入库管理
 * @author: silver 
 * @since: 2018年6月5日 下午2:21:04 
 * @history:
 */
@Repository("storageInDAOImpl")
public class StorageInDAOImpl extends AMybatisTemplate
        implements IStorageInDAO {

    @Override
    public int insert(StorageIn data) {
        return super.insert(NAMESPACE.concat("insert_StorageIn"), data);
    }

    @Override
    public int delete(StorageIn data) {
        return super.delete(NAMESPACE.concat("delete_StorageIn"), data);
    }

    @Override
    public void update(StorageIn data) {
        super.update(NAMESPACE.concat("update_StorageIn"), data);
    }

    @Override
    public StorageIn select(StorageIn condition) {
        return super.select(NAMESPACE.concat("select_StorageIn"), condition,
            StorageIn.class);
    }

    @Override
    public long selectTotalCount(StorageIn condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_StorageIn_count"), condition);
    }

    @Override
    public List<StorageIn> selectList(StorageIn condition) {
        return super.selectList(NAMESPACE.concat("select_StorageIn"), condition,
            StorageIn.class);
    }

    @Override
    public List<StorageIn> selectList(StorageIn condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_StorageIn"), start,
            count, condition, StorageIn.class);
    }

}
