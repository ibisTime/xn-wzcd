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

    public int saveSYSBizLog(SYSBizLog data) {
        int id = data.getId();
        sysBizLogDAO.insert(data);
        return id;
    }

    @Override
    public int refreshSYSBizLog(SYSBizLog data) {
        // 计算花费时间
        Long start = data.getStartDatetime().getTime();
        Long end = data.getEndDatetime().getTime();
        Long diff = end - start;
        Long day = diff / (24 * 60 * 60 * 1000);
        Long hour = (diff / (60 * 60 * 1000) - day * 24);
        Long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        Long sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60
                - min * 60);
        data.setSpeedTime(day + "天" + hour + "时" + min + "分" + sec + "秒");

        return sysBizLogDAO.updateDatetime(data);
    }

    @Override
    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition) {
        return sysBizLogDAO.selectList(condition);
    }

    @Override
    public SYSBizLog getSYSBizLog(int id) {
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

    @Override
    public SYSBizLog getSYSBizLogByTime(SYSBizLog data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getSYSBizLoglatest(SYSBizLog condition) {
        return sysBizLogDAO.selectSysBizLogLatest(condition);
    }
}
