package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ArchiveLocation;

/**
 * 档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 下午1:33:22 
 * @history:
 */
@Component
public interface IArchiveLocationAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addArchiveLocation(ArchiveLocation data);

    public int dropArchiveLocation(String code);

    public int editArchiveLocation(ArchiveLocation data);

    public Paginable<ArchiveLocation> queryArchiveLocationPage(int start,
            int limit, ArchiveLocation condition);

    public List<ArchiveLocation> queryArchiveLocationList(
            ArchiveLocation condition);

    public ArchiveLocation getArchiveLocation(String code);

}
