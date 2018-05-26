package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICollectBankcardDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CollectBankcard;

//CHECK 。。。 
@Repository("collectBankcardDAOImpl")
public class CollectBankcardDAOImpl extends AMybatisTemplate
        implements ICollectBankcardDAO {

    @Override
    public int insert(CollectBankcard data) {
        return super.insert(NAMESPACE.concat("insert_collectBankcard"), data);
    }

    @Override
    public int delete(CollectBankcard data) {
        return super.delete(NAMESPACE.concat("delete_collectBankcard"), data);
    }

    @Override
    public CollectBankcard select(CollectBankcard condition) {
        return super.select(NAMESPACE.concat("select_collectBankcard"),
            condition, CollectBankcard.class);
    }

    @Override
    public long selectTotalCount(CollectBankcard condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_collectBankcard_count"), condition);
    }

    @Override
    public List<CollectBankcard> selectList(CollectBankcard condition) {
        return super.selectList(NAMESPACE.concat("select_collectBankcard"),
            condition, CollectBankcard.class);
    }

    @Override
    public List<CollectBankcard> selectList(CollectBankcard condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_collectBankcard"),
            start, count, condition, CollectBankcard.class);
    }

    @Override
    public int update(CollectBankcard data) {
        return super.update(NAMESPACE.concat("update_collectBankcard"), data);
    }

}
