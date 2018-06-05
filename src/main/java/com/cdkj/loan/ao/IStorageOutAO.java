package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.StorageOut;
import com.cdkj.loan.dto.req.XN632770Req;

/**
 * 出库管理
 * @author: silver 
 * @since: 2018年6月5日 下午4:21:12 
 * @history:
 */
@Component
public interface IStorageOutAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addStorageOut(XN632770Req req);

    public Paginable<StorageOut> queryStorageOutPage(int start, int limit,
            StorageOut condition);

    public List<StorageOut> queryStorageOutList(StorageOut condition);

    public StorageOut getStorageOut(String code);

}
