package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IProvinceDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Province;

/**
 * 省份编号
 * @author: silver 
 * @since: 2018年5月27日 下午12:53:22 
 * @history:
 */
@Repository("provinceDAOImpl")
public class ProvinceDAOImpl extends AMybatisTemplate implements IProvinceDAO {

    @Override
    public int insert(Province data) {
        return super.insert(NAMESPACE.concat("insert_province"), data);
    }

    @Override
    public int delete(Province data) {
        return super.delete(NAMESPACE.concat("delete_province"), data);
    }

    @Override
    public int updateProvince(Province data) {
        return super.update(NAMESPACE.concat("update_province"), data);
    }

    @Override
    public Province select(Province condition) {
        return super.select(NAMESPACE.concat("select_province"), condition,
            Province.class);
    }

    @Override
    public long selectTotalCount(Province condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_province_count"),
            condition);
    }

    @Override
    public List<Province> selectList(Province condition) {
        return super.selectList(NAMESPACE.concat("select_province"), condition,
            Province.class);
    }

    @Override
    public List<Province> selectList(Province condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_province"), start,
            count, condition, Province.class);
    }
}
