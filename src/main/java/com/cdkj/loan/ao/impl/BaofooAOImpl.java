package com.cdkj.loan.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBaofooAO;
import com.cdkj.loan.baofoo.BaofooResult;
import com.cdkj.loan.baofoo.CompanyChannel;
import com.cdkj.loan.bo.IBaofooBO;
import com.cdkj.loan.bo.IBaofooWithholdBO;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.BaofooWithhold;
import com.cdkj.loan.exception.BizException;

@Service
public class BaofooAOImpl implements IBaofooAO {

    @Autowired
    IBaofooBO baofooBO;

    @Autowired
    IBaofooWithholdBO baofooWithholdBO;

    @Override
    @Transactional
    public boolean withhold(String bankCode, String accountNo, String idNo,
            String realName, String mobile, Long transAmount, String refNo,
            String companyCode, String systemCode) {

        boolean isSuccess = false;

        String transId = OrderNoGenerater.generate("BFDK");
        // 代扣记录
        BaofooWithhold data = new BaofooWithhold();
        data.setTransId(transId);
        data.setBankCode(bankCode);
        data.setBankcardNumber(accountNo);
        data.setIdNo(idNo);
        data.setRealName(realName);
        data.setMobile(mobile);
        data.setTransAmount(transAmount);
        data.setRefNo(refNo);

        // TODO 获取渠道配置
        CompanyChannel companyChannel = new CompanyChannel();

        // 调用宝付代扣
        BaofooResult baofooResult = baofooBO.withhold(transId, bankCode,
            accountNo, idNo, realName, mobile, transAmount, companyChannel);
        if (baofooResult == null) {
            throw new BizException("xn000000", "宝付代扣发生异常");
        }

        // 代扣结果解析
        if (baofooResult.getResp_code().equals("0000")) {
            isSuccess = true;
            data.setRespCode(baofooResult.getResp_code());
            data.setRespMsg(baofooResult.getResp_msg());
            data.setMemberId(baofooResult.getMember_id());
            data.setTerminalId(baofooResult.getTerminal_id());
            data.setTxnType(baofooResult.getTxn_type());
            data.setTxnSubType(baofooResult.getTxn_sub_type());
            data.setBizType(baofooResult.getBiz_type());
            data.setTradeDate(DateUtil.strToDate(baofooResult.getTrade_date(),
                DateUtil.DATA_TIME_PATTERN_5));
            data.setTransNo(baofooResult.getTrans_no());
            data.setSuccAmt(Long.valueOf(baofooResult.getSucc_amt()) * 10);
            data.setTransSerialNo(baofooResult.getTrans_serial_no());
        } else {
            isSuccess = false;
            data.setRespCode(baofooResult.getResp_code());
            data.setRespMsg(baofooResult.getResp_msg());
            data.setMemberId(baofooResult.getMember_id());
            data.setTerminalId(baofooResult.getTerminal_id());
            data.setTxnType(baofooResult.getTxn_type());
            data.setTxnSubType(baofooResult.getTxn_sub_type());
            data.setBizType(baofooResult.getBiz_type());
            data.setTradeDate(DateUtil.strToDate(baofooResult.getTrade_date(),
                DateUtil.DATA_TIME_PATTERN_5));
            data.setTransSerialNo(baofooResult.getTrans_serial_no());
        }

        baofooWithholdBO.saveBaofooWithhold(data);

        return isSuccess;
    }

}
