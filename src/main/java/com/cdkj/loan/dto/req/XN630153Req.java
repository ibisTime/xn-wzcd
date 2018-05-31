package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class XN630153Req {

    @NotBlank
    private String id;// 序号

    @NotEmpty
    private List<String> fileStrs;// 材料清单

    public List<String> getFileStrs() {
        return fileStrs;
    }

    public void setFileStrs(List<String> fileStrs) {
        this.fileStrs = fileStrs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
