package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IReplaceRepayApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IReplaceRepayApplyDAO;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EReplaceRepayStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 代偿预算单
 * @author: silver 
 * @since: 2018年6月14日 下午9:37:13 
 * @history:
 */
@Component
public class ReplaceRepayApplyBOImpl extends PaginableBOImpl<ReplaceRepayApply>
        implements IReplaceRepayApplyBO {

    @Autowired
    private IReplaceRepayApplyDAO replaceRepayApplyDAO;

    @Override
    public boolean isReplaceRepayApplyExist(String code) {
        ReplaceRepayApply condition = new ReplaceRepayApply();
        condition.setCode(code);
        if (replaceRepayApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveReplaceRepayApply(ReplaceRepayApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.REPLACE_REPAY_APPLY.getCode());
            data.setCode(code);
            replaceRepayApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<ReplaceRepayApply> queryReplaceRepayApplyList(
            ReplaceRepayApply condition) {
        return replaceRepayApplyDAO.selectList(condition);
    }

    @Override
    public ReplaceRepayApply getReplaceRepayApply(String code) {
        ReplaceRepayApply data = null;
        if (StringUtils.isNotBlank(code)) {
            ReplaceRepayApply condition = new ReplaceRepayApply();
            condition.setCode(code);
            data = replaceRepayApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }
        }
        return data;
    }

    @Override
    public void refreshFinanceManageApprove(String code, String approveResult,
            String updater, String remark) {
        ReplaceRepayApply data = new ReplaceRepayApply();
        data.setCode(code);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);

        if (EBoolean.YES.getCode().equals(approveResult)) {
            data.setStatus(EReplaceRepayStatus.APPROVED_YES.getCode());
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            data.setStatus(EReplaceRepayStatus.APPROVED_NO.getCode());
        }
        replaceRepayApplyDAO.updateFinanceManageApprove(data);
    }

    @Override
    public void refreshMakeDocument(String code, String updater) {
        ReplaceRepayApply data = new ReplaceRepayApply();
        data.setCode(code);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setStatus(EReplaceRepayStatus.MAKE_DOCUMENT.getCode());
        replaceRepayApplyDAO.updateFinanceManageApprove(data);
    }
}
