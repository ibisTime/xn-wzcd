package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBaofooWithholdDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BaofooWithhold;

@Repository("baofooWithholdDAOImpl")
public class BaofooWithholdDAOImpl extends AMybatisTemplate
        implements IBaofooWithholdDAO {

    @Override
    public int insert(BaofooWithhold data) {
        return super.insert(NAMESPACE.concat("insert_baofooWithhold"), data);
    }

    @Override
    public int delete(BaofooWithhold data) {
        return 0;
    }

    @Override
    public BaofooWithhold select(BaofooWithhold condition) {
        return super.select(NAMESPACE.concat("select_baofooWithhold"),
            condition, BaofooWithhold.class);
    }

    @Override
    public long selectTotalCount(BaofooWithhold condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_baofooWithhold_count"), condition);
    }

    @Override
    public List<BaofooWithhold> selectList(BaofooWithhold condition) {
        return super.selectList(NAMESPACE.concat("select_baofooWithhold"),
            condition, BaofooWithhold.class);
    }

    @Override
    public List<BaofooWithhold> selectList(BaofooWithhold condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_baofooWithhold"),
            start, count, condition, BaofooWithhold.class);
    }

}
