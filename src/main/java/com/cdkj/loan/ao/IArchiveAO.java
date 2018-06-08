package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.dto.req.XN632800Req;
import com.cdkj.loan.dto.req.XN632802Req;
import com.cdkj.loan.dto.res.XN632803Res;

/**
 * 人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午5:27:54 
 * @history:
 */
@Component
public interface IArchiveAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addArchive(XN632800Req req);

    public void dropArchive(String code);

    public void editArchive(XN632802Req req);

    public Paginable<Archive> queryArchivePage(int start, int limit,
            Archive condition);

    public List<Archive> queryArchiveList(Archive condition);

    public Archive getArchive(String code);

    // 新增离职档案
    public void editLeaveArchive(Archive data);

    // 按年龄统计分析
    public void statisticsAge(Archive condition);

    public List<XN632803Res> getTotal();

}
