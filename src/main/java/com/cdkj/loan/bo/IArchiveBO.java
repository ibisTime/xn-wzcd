package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Archive;

/**
 * 人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午5:28:29 
 * @history:
 */
public interface IArchiveBO extends IPaginableBO<Archive> {

    public boolean isArchiveExist(String code);

    public String saveArchive(Archive data);

    public void removeArchive(String code);

    public void refreshArchive(Archive data);

    public List<Archive> queryArchiveList(Archive condition);

    public Archive getArchive(String code);

    // 新增离职档案
    public void refreshLeaveArchive(Archive data);

    public Archive getArchiveByUserid(String userId);

    public int getTotalCount(int ageStart, int agetEnd);

    // 判断是否存在
    public void doCheck(String userId);
}
