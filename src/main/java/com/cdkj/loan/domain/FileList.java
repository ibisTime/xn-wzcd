package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

public class FileList extends ABaseDO {
    private static final long serialVersionUID = 4733016091171187458L;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
