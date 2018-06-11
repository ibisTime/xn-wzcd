package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.OverdueMenu;
import com.cdkj.loan.dto.req.XN632300ReqOverdue;

@Component
public interface IOverdueMenuAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 导入
    public void importOverdueMenu(String loanBankCode,
            List<XN632300ReqOverdue> list);

    // 处理
    public void handleOverdueMenu(String code, String repayBizCode,
            String operator);

    public Paginable<OverdueMenu> queryOverdueMenuPage(int start, int limit,
            OverdueMenu condition);

    public List<OverdueMenu> queryOverdueMenuList(OverdueMenu condition);

    public OverdueMenu getOverdueMenu(String code);

}
