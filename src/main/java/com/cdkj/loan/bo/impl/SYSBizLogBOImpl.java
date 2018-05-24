package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ISYSBizLogDAO;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class SYSBizLogBOImpl extends PaginableBOImpl<SYSBizLog>
        implements ISYSBizLogBO {

    @Autowired
    private ISYSBizLogDAO sysBizLogDAO;

    public void saveSYSBizLog(SYSBizLog data) {

        sysBizLogDAO.insert(data);
    }

    @Override
    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition) {
        return sysBizLogDAO.selectList(condition);
    }

    @Override
    public SYSBizLog getSYSBizLog(Long id) {
        SYSBizLog data = null;
        if (id == 0) {
            SYSBizLog condition = new SYSBizLog();
            condition.setId(id);
            data = sysBizLogDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "日志不存在！");
            }
        }
        return data;
    }
}
