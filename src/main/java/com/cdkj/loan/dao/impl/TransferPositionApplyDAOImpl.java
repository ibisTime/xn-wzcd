package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ITransferPositionApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.TransferPositionApply;

//CHECK 。。。 
@Repository("transferPositionApplyDAOImpl")
public class TransferPositionApplyDAOImpl extends AMybatisTemplate
        implements ITransferPositionApplyDAO {

    @Override
    public int insert(TransferPositionApply data) {
        return super.insert(NAMESPACE.concat("insert_transferPositionApply"),
            data);
    }

    @Override
    public int delete(TransferPositionApply data) {
        return super.delete(NAMESPACE.concat("delete_transferPositionApply"),
            data);
    }

    @Override
    public void updateTransferPositionApplyStatus(TransferPositionApply data) {
        super.update(NAMESPACE.concat("update_transferPositionApplyStatus"),
            data);
    }

    @Override
    public TransferPositionApply select(TransferPositionApply condition) {
        return super.select(NAMESPACE.concat("select_transferPositionApply"),
            condition, TransferPositionApply.class);
    }

    @Override
    public long selectTotalCount(TransferPositionApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_transferPositionApply_count"), condition);
    }

    @Override
    public List<TransferPositionApply> selectList(
            TransferPositionApply condition) {
        return super.selectList(
            NAMESPACE.concat("select_transferPositionApply"), condition,
            TransferPositionApply.class);
    }

    @Override
    public List<TransferPositionApply> selectList(
            TransferPositionApply condition, int start, int count) {
        return super.selectList(
            NAMESPACE.concat("select_transferPositionApply"), start, count,
            condition, TransferPositionApply.class);
    }

}
