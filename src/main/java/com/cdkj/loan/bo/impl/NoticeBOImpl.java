package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.INoticeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.INoticeDAO;
import com.cdkj.loan.domain.Notice;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 公告管理
 * @author: silver 
 * @since: 2018年6月4日 下午5:15:59 
 * @history:
 */
@Component
public class NoticeBOImpl extends PaginableBOImpl<Notice> implements INoticeBO {

    @Autowired
    private INoticeDAO noticeDAO;

    @Override
    public boolean isNoticeExist(String code) {
        Notice condition = new Notice();
        condition.setCode(code);
        if (noticeDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveNotice(Notice data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.NOTICE.getCode());
            data.setCode(code);
            noticeDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<Notice> queryNoticeList(Notice condition) {
        return noticeDAO.selectList(condition);
    }

    @Override
    public Notice getNotice(String code) {
        Notice data = null;
        if (StringUtils.isNotBlank(code)) {
            Notice condition = new Notice();
            condition.setCode(code);
            data = noticeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "公告不存在！");
            }
        }
        return data;
    }
}
