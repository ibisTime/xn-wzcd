package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.IRepointDetailBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632240Req;
import com.cdkj.loan.dto.req.XN632241Req;
import com.cdkj.loan.enums.ERepointDetailStatus;
import com.cdkj.loan.enums.ERepointStatus;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月18日 下午2:21:58 
 * @history:
 */
@Service
public class RepointAOImpl implements IRepointAO {

    @Autowired
    private IRepointBO repointBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    private IRepointDetailBO repointDetailBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addRepoint(XN632240Req req) {
        Repoint data = new Repoint();
        data.setCarDealerCode(req.getCarDealerCode());
        data.setBankcardCode(req.getBankcardCode());
        data.setTotalAmount(StringValidater.toLong(req.getTotalAmount()));
        data.setReason(req.getReason());
        data.setApplyUserId(req.getOperator());
        SYSUser user = sysUserBO.getUser(req.getOperator());
        data.setCompanyCode(user.getCompanyCode());
        data.setApplyDatetime(new Date());
        CarDealer carDealer = carDealerBO.getCarDealer(req.getCarDealerCode());
        data.setSettleType(carDealer.getSettleWay());
        data.setCurNodeCode(ERepointStatus.TODO.getCode());
        String repointCode = repointBO.saveRepoint(data);
        // 更改返点明细数据的状态为已制单待打款
        List<String> list = req.getRepointDetailCodeList();
        for (String code : list) {
            RepointDetail repointDetail = repointDetailBO
                .getRepointDetail(code);
            repointDetail.setCurNodeCode(ERepointDetailStatus.TODO_PAY
                .getCode());
            repointDetail.setRepointCode(repointCode);
            repointDetailBO.updateCurNodeCode(repointDetail);
        }

        return repointBO.saveRepoint(data);
    }

    @Override
    public Paginable<Repoint> queryRepointPage(int start, int limit,
            Repoint condition) {

        Paginable<Repoint> paginable = repointBO.getPaginable(start, limit,
            condition);
        List<Repoint> list = paginable.getList();
        for (Repoint data : list) {
            init(data);
        }

        return paginable;
    }

    @Override
    public List<Repoint> queryRepointList(Repoint condition) {
        return repointBO.queryRepointList(condition);
    }

    @Override
    public Repoint getRepoint(String code) {
        Repoint repoint = repointBO.getRepoint(code);
        RepointDetail condition = new RepointDetail();
        condition.setRepointCode(repoint.getCode());
        List<RepointDetail> list = repointDetailBO
            .queryRepointDetailList(condition);
        repoint.setRepointDetailList(list);

        init(repoint);

        return repoint;
    }

    @Override
    public void confirmLoan(XN632241Req req) {

        Repoint data = repointBO.getRepoint(req.getCode());
        data.setPayDatetime(DateUtil.strToDate(req.getPayDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setPayBankcardCode(req.getPayBankcardCode());
        data.setBillPdf(req.getBillPdf());
        data.setPayRemark(req.getPayRemark());
        data.setCurNodeCode(ERepointStatus.HANDLED.getCode());
        repointBO.confirmLoan(data);
        // 修改返点明细数据的状态为已打款
        RepointDetail condition = new RepointDetail();
        condition.setRepointCode(data.getCode());
        List<RepointDetail> list = repointDetailBO
            .queryRepointDetailList(condition);
        for (RepointDetail repointDetail : list) {
            repointDetail
                .setCurNodeCode(ERepointDetailStatus.HANDLED.getCode());
            repointDetailBO.updateCurNodeCode(repointDetail);
        }

    }

    private Repoint init(Repoint data) {

        if (StringUtils.isNotBlank(data.getCarDealerCode())) {
            CarDealer carDealer = carDealerBO.getCarDealer(data
                .getCarDealerCode());
            if (null != carDealer) {
                data.setCarDealerName(carDealer.getFullName());
            }

        }

        if (StringUtils.isNotBlank(data.getCompanyCode())) {
            Department department = departmentBO.getDepartment(data
                .getCompanyCode());
            if (null != department) {
                data.setCarDealerName(department.getName());
            }

        }

        if (StringUtils.isNotBlank(data.getApplyUserId())) {
            SYSUser user = sysUserBO.getUser(data.getApplyUserId());
            if (null != user) {
                data.setApplyUserName(user.getRealName());
            }

        }

        return data;

    }
}
