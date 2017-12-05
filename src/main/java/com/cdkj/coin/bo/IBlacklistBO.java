package com.cdkj.coin.bo;

import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.Blacklist;
import com.cdkj.coin.domain.User;

public interface IBlacklistBO extends IPaginableBO<Blacklist> {

    public Long saveBlacklist(User user, String type, String updater,
            String remark);

    public int removeBlacklist(Long id, String updater, String remark);

    public List<Blacklist> queryBlacklistList(Blacklist condition);

    public Blacklist getBlacklist(Long id);

    public String isAddBlacklist(String userId);

}
