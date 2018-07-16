package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IProvinceBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.dao.ICreditDAO;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Province;
import com.cdkj.loan.enums.EBankType;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBudgetOrderShopWay;
import com.cdkj.loan.exception.BizException;

/**
 * 征信单
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:40:05 
 * @history:
 */
@Component
public class CreditBOImpl extends PaginableBOImpl<Credit> implements ICreditBO {

    @Autowired
    private ICreditDAO creditDAO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IProvinceBO provinceBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Override
    public String saveCredit(Credit data) {
        String code = null;
        if (null != data) {
            Bank bank = bankBO.getBankBySubbranch(data.getLoanBankCode());
            // 业务归属公司
            String bizCompany = "H";
            if (EBankType.ZH.getCode().equals(bank.getBankCode())) {
                bizCompany = "B";
            }
            // 新车二手车
            String shopWay = "X";
            if (EBudgetOrderShopWay.OLD.getCode().equals(data.getShopWay())) {
                shopWay = "R";
            }
            Department company = departmentBO.getDepartment(data
                .getCompanyCode());
            Province provinceCondition = new Province();
            provinceCondition.setName(company.getProvinceNo());
            Province province = provinceBO.getProvince(provinceCondition);
            // 省份编号
            String provinceNo = "33";
            if (null != province) {
                provinceNo = province.getProvinceNo();
            }
            String today = DateUtil.getToday(DateUtil.DB_DATE_FORMAT_STRING);// yyyyMMdd
            String year = today.substring(2, 4);
            String month = today.substring(4, 6);
            String day = today.substring(6);

            Archive condition = new Archive();
            condition.setUserId(data.getSaleUserId());
            List<Archive> archiveList = archiveBO.queryArchiveList(condition);
            String jobNo = "000";
            if (!archiveList.isEmpty()) {
                jobNo = archiveList.get(0).getJobNo();// TODO
            }

            Credit creditCondition = new Credit();
            creditCondition.setApplyDatetimeStart(DateUtil.getTodayStart());
            creditCondition.setApplyDatetimeEnd(DateUtil.getTodayEnd());
            long count = creditDAO.selectTotalCount(creditCondition) + 1;
            String bizNO = String.valueOf(count);
            if (bizNO.length() == 1) {
                bizNO = "00" + bizNO;
            } else if (bizNO.length() == 2) {
                bizNO = "0" + bizNO;
            }
            code = bizCompany + shopWay + provinceNo + year + month + day
                    + jobNo + bizNO;
            data.setCode(code);
            creditDAO.insert(data);
        }
        return code;
    }

    @Override
    public Credit getCredit(String code) {
        Credit credit = null;
        if (StringUtils.isNotBlank(code)) {
            Credit condition = new Credit();
            condition.setCode(code);
            credit = creditDAO.select(condition);
            if (credit == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前征信单不存在");
            }
            CreditUser creditUser = new CreditUser();
            creditUser.setCreditCode(code);
            List<CreditUser> creditUserList = creditUserBO
                .queryCreditUserList(creditUser);
            credit.setCreditUserList(creditUserList);
        }
        return credit;
    }

    @Override
    public void refreshCredit(Credit data) {
        creditDAO.updateCredit(data);
    }

    @Override
    public Paginable<Credit> getPaginableByRoleCode(int start, int limit,
            Credit condition) {
        prepare(condition);

        long totalCount = creditDAO.selectTotalCountByRoleCode(condition);

        Paginable<Credit> page = new Page<Credit>(start, limit, totalCount);

        List<Credit> dataList = creditDAO.selectReqBudgetByRoleCodeList(
            condition, page.getStart(), page.getPageSize());

        page.setList(dataList);
        return page;
    }

    @Override
    public void refreshCreditNode(Credit credit) {

        creditDAO.updateNode(credit);

    }

}
