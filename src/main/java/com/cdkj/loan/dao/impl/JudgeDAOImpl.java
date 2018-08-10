package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IJudgeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Judge;

/**
 * 司法诉讼
 * @author: silver 
 * @since: 2018年6月16日 下午8:23:22 
 * @history:
 */
@Repository("judgeDAOImpl")
public class JudgeDAOImpl extends AMybatisTemplate implements IJudgeDAO {

    @Override
    public int insert(Judge data) {
        return super.insert(NAMESPACE.concat("insert_judge"), data);
    }

    @Override
    public int delete(Judge data) {
        return super.delete(NAMESPACE.concat("delete_judge"), data);
    }

    @Override
    public Judge select(Judge condition) {
        return super.select(NAMESPACE.concat("select_judge"), condition,
            Judge.class);
    }

    @Override
    public long selectTotalCount(Judge condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_judge_count"),
            condition);
    }

    @Override
    public List<Judge> selectList(Judge condition) {
        return super.selectList(NAMESPACE.concat("select_judge"), condition,
            Judge.class);
    }

    @Override
    public List<Judge> selectList(Judge condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_judge"), start, count,
            condition, Judge.class);
    }

    @Override
    public void updateJudgeFollow(Judge data) {
        super.update(NAMESPACE.concat("update_judgeFollow"), data);
    }

    @Override
    public void updateJudgeResultInput(Judge data) {
        super.update(NAMESPACE.concat("update_judgeResultInput"), data);
    }

    @Override
    public void cashier(Judge data) {
        super.update(NAMESPACE.concat("update_cashier"), data);
    }

    @Override
    public void acceptance(Judge data) {
        super.update(NAMESPACE.concat("update_acceptance"), data);
    }

    @Override
    public void toHoldCourt(Judge data) {
        super.update(NAMESPACE.concat("update_toHoldCourt"), data);
    }

    @Override
    public void sentence(Judge data) {
        super.update(NAMESPACE.concat("update_sentence"), data);
    }
}
