package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepointDetail;

//dao层 
public interface IRepointDetailDAO extends IBaseDAO<RepointDetail> {
    String NAMESPACE = IRepointDetailDAO.class.getName().concat(".");

    int update(RepointDetail data);

    void updateCurNodeCode(RepointDetail data);

    int deletePreRepointDetail(RepointDetail data);

    void updateRepointDetailType(RepointDetail data);

    // 根据经销商编号查返点（去重）
    List<RepointDetail> selectListByCarDealer(RepointDetail condition);
}
