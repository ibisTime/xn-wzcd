package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ITravelApplyAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ITravelApplyBO;
import com.cdkj.loan.bo.ITravelApplyDetailBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.TravelApply;
import com.cdkj.loan.domain.TravelApplyDetail;
import com.cdkj.loan.dto.req.XN632620Req;
import com.cdkj.loan.dto.req.XN632620ReqChild;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午12:53:29 
 * @history:
 */
@Service
public class TravelApplyAOImpl implements ITravelApplyAO {

    @Autowired
    private ITravelApplyBO travelApplyBO;

    @Autowired
    private ITravelApplyDetailBO travelApplyDetailBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Override
    public String addTravelApply(XN632620Req req) {
        // 判断人事档案中是否存在
        archiveBO.doCheck(req.getApplyUser());

        TravelApply data = new TravelApply();
        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        long totalHour = 0;
        List<XN632620ReqChild> detailList = req.getDetailList();
        for (XN632620ReqChild child : detailList) {
            Date start = DateUtil.strToDate(child.getStartDatetime(),
                DateUtil.DATA_TIME_PATTERN_2);
            Date end = DateUtil.strToDate(child.getEndDatetime(),
                DateUtil.DATA_TIME_PATTERN_2);
            long time = (end.getTime() - start.getTime()) / (1000 * 60 * 60);
            totalHour += time;

        }
        data.setTotalHour(String.valueOf(totalHour));
        data.setReason(req.getReason());
        data.setStatus("0");
        data.setType(req.getType());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        String code = travelApplyBO.saveTravelApply(data);

        for (XN632620ReqChild child : detailList) {

            TravelApplyDetail detail = new TravelApplyDetail();

            detail.setTravelApplyCode(code);
            detail.setStartDatetime(child.getStartDatetime());
            detail.setEndDatetime(child.getEndDatetime());
            detail.setTotalHour(child.getTotalHour());
            detail.setRemark(child.getRemark());

            Date start = DateUtil.strToDate(child.getStartDatetime(),
                DateUtil.DATA_TIME_PATTERN_2);
            Date end = DateUtil.strToDate(child.getEndDatetime(),
                DateUtil.DATA_TIME_PATTERN_2);
            String time = String
                .valueOf((end.getTime() - start.getTime()) / (1000 * 60 * 60));

            detail.setTotalHour(time);
            detail.setRemark(child.getRemark());

            travelApplyDetailBO.saveTravelApplyDetail(detail);

        }

        return code;
    }

    @Override
    public void editTravelApply(TravelApply data) {
        if (!travelApplyBO.isTravelApplyExist(data.getCode())) {
            throw new BizException("xn0000", "出差申请不存在");
        }
        travelApplyBO.refreshTravelApply(data);
    }

    @Override
    public Paginable<TravelApply> queryTravelApplyPage(int start, int limit,
            TravelApply condition) {
        Paginable<TravelApply> paginable = travelApplyBO.getPaginable(start,
            limit, condition);
        List<TravelApply> list = paginable.getList();
        for (TravelApply travelApply : list) {
            initTravelApply(travelApply);
        }
        return paginable;
    }

    @Override
    public List<TravelApply> queryTravelApplyList(TravelApply condition) {
        return travelApplyBO.queryTravelApplyList(condition);
    }

    @Override
    public TravelApply getTravelApply(String code) {
        TravelApply data = travelApplyBO.getTravelApply(code);
        initTravelApply(data);
        return data;
    }

    private void initTravelApply(TravelApply travelApply) {
        // 申请人名称初始化
        String applyUser = travelApply.getApplyUser();
        SYSUser user = sysUserBO.getUser(applyUser);
        travelApply.setApplyUserName(user.getRealName());

        // 部门.岗位初始化
        Department department = departmentBO
            .getDepartment(user.getDepartmentCode());
        travelApply.setDepartmentName(department.getName());
        Department post = departmentBO.getDepartment(user.getPostCode());
        travelApply.setPostName(post.getName());

        Archive conditon = new Archive();
        conditon.setUserId(user.getUserId());
        List<Archive> archiveList = archiveBO.queryArchiveList(conditon);
        if (!archiveList.isEmpty()) {
            Archive archive = archiveList.get(0);
            travelApply.setJobNo(archive.getJobNo());
        }

        // 查询明细
        List<TravelApplyDetail> travelApplyDetailList = travelApplyDetailBO
            .queryTravelApplyDetailList(travelApply.getCode());
        travelApply.setTravelApplyDetailList(travelApplyDetailList);
    }
}
