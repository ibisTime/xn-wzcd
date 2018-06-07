package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.INoticeReadBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.INoticeReadDAO;
import com.cdkj.loan.domain.NoticeRead;
import com.cdkj.loan.enums.ENoticeReadStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 公告阅读记录
 * @author: silver 
 * @since: 2018年6月7日 下午3:49:03 
 * @history:
 */
@Component
public class NoticeReadBOImpl extends PaginableBOImpl<NoticeRead>
        implements INoticeReadBO {

    @Autowired
    private INoticeReadDAO noticeReadDAO;

    @Override
    public void saveNoticeRead(NoticeRead data) {
        if (data != null) {
            noticeReadDAO.insert(data);
        }
    }

    @Override
    public List<NoticeRead> queryNoticeReadList(NoticeRead condition) {
        return noticeReadDAO.selectList(condition);
    }

    @Override
    public NoticeRead getNoticeRead(Integer id) {
        NoticeRead data = null;
        if (0 != id) {
            NoticeRead condition = new NoticeRead();
            condition.setId(id);
            data = noticeReadDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在！");
            }

            // 将记录标记为已读
            if (ENoticeReadStatus.NO.getCode().equals(data.getStatus())) {
                NoticeRead noticeRead = new NoticeRead();
                noticeRead.setId(id);
                noticeRead.setStatus(ENoticeReadStatus.YES.getCode());
                noticeReadDAO.update(noticeRead);
            }
        }
        return data;
    }
}
