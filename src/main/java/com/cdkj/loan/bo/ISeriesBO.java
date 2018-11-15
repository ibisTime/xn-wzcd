package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Series;

public interface ISeriesBO extends IPaginableBO<Series> {

    public String saveSeries(Series data);

    public Series getSeries(String code);

    public void removeSeries(Series data);

    public int editSeries(Series data);

    public int upSeries(Series data);

    public int downSeries(Series data);

    public List<Series> querySeries(Series condition);

    public Series getSeriesBySeriesId(String seriesId);
}
