package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ChannelBank;

public interface IChannelBankAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addChannelBank(ChannelBank data);

    public void dropChannelBank(Long id);

    public void editChannelBank(ChannelBank data);

    public Paginable<ChannelBank> queryChannelBankPage(int start, int limit,
            ChannelBank condition);

    public List<ChannelBank> queryChannelBankList(ChannelBank condition);

    public ChannelBank getChannelBank(Long id);
}
