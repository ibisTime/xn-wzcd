package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISeriesBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ISeriesDAO;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class SeriesBOImpl extends PaginableBOImpl<Series> implements ISeriesBO {

    @Autowired
    private ISeriesDAO seriesDAO;

    @Override
    public long getTotalCount(Series condition) {
        return seriesDAO.selectTotalCount(condition);
    }

    @Override
    public String saveSeries(Series data) {
        String code = null;
        if (data != null) {
            if (data.getCode() == null) {
                code = OrderNoGenerater
                    .generate(EGeneratePrefix.Series.getCode());
                data.setCode(code);
            }
            seriesDAO.insert(data);
        }
        return code;
    }

    @Override
    public Series getSeries(String code) {
        Series data = null;
        if (StringUtils.isNotBlank(code)) {
            Series condition = new Series();
            condition.setCode(code);
            data = seriesDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该编号不存在");
            }
        }
        return data;
    }

    @Override
    public int editSeries(Series data) {
        return seriesDAO.update(data);
    }

    @Override
    public List<Series> querySeries(Series condition) {
        return seriesDAO.selectList(condition);
    }

}
