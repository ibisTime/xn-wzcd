package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.cdkj.loan.domain.FileList;

public class XN630153Req {

    @NotBlank
    private String id;// 序号

    @NotEmpty
    private List<FileList> fileStrs;// 材料清单

    public List<FileList> getFileStrs() {
        return fileStrs;
    }

    public void setFileStrs(List<FileList> fileStrs) {
        this.fileStrs = fileStrs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
