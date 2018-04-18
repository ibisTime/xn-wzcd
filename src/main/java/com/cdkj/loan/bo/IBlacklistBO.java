package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Blacklist;
import com.cdkj.loan.domain.User;

public interface IBlacklistBO extends IPaginableBO<Blacklist> {

    public Long saveBlacklist(User user, String type, String updater,
            String remark);

    public int removeBlacklist(Long id, String updater, String remark);

    public List<Blacklist> queryBlacklistList(Blacklist condition);

    public Blacklist getBlacklist(Long id);

    public String isAddBlacklist(String userId);

}
