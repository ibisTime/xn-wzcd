package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.StorageIn;
import com.cdkj.loan.dto.req.XN632760Req;

/**
 * 入库管理
 * @author: silver 
 * @since: 2018年6月5日 下午2:26:41 
 * @history:
 */
@Component
public interface IStorageInAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addStorageIn(XN632760Req req);

    public Paginable<StorageIn> queryStorageInPage(int start, int limit,
            StorageIn condition);

    public List<StorageIn> queryStorageInList(StorageIn condition);

    public StorageIn getStorageIn(String code);

}
