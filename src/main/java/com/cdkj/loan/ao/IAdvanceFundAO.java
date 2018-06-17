package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.dto.req.XN632170Req;
import com.cdkj.loan.dto.req.XN632171Req;
import com.cdkj.loan.dto.req.XN632172Req;
import com.cdkj.loan.dto.req.XN632173Req;
import com.cdkj.loan.dto.req.XN632175Req;
import com.cdkj.loan.dto.req.XN632177Req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:36:45 
 * @history:
 */
@Component
public interface IAdvanceFundAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 确认垫资单
    public void confirmAdvanceFund(XN632170Req req);

    public int dropAdvanceFund(String code);

    public int editAdvanceFund(AdvanceFund data);

    public Paginable<AdvanceFund> queryAdvanceFundPage(int start, int limit,
            AdvanceFund condition);

    public List<AdvanceFund> queryAdvanceFundList(AdvanceFund condition);

    public AdvanceFund getAdvanceFund(String code);

    // 区域总经理审核
    public void areaAudit(XN632171Req req);

    // 省分公司总经理审核
    public void provinceAudit(XN632172Req req);

    // 总公司制单
    public void parentMakeBill(XN632173Req req);

    // 确认打款给车行
    public void confirmPayCarDealer(XN632175Req req);

    // 申请撤销垫资
    public void applyCancelAdvanceFund(XN632177Req req);

    // 分页查询垫资单根据角色编号
    public Object queryAdvanceFundPageByRoleCode(int start, int limit,
            AdvanceFund condition);

}
