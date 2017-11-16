/**
 * @Title TencentBOImpl.java 
 * @Package com.cdkj.coin.bo.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月16日 下午5:05:31 
 * @version V1.0   
 */
package com.cdkj.coin.bo.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.ITencentBO;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.dto.res.XN625000Res;
import com.cdkj.coin.enums.EConfigType;
import com.cdkj.coin.enums.EUserPwd;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.tencent.tls_sigcheck;
import com.google.gson.JsonObject;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月16日 下午5:05:31 
 * @history:
 */
public class TencentBOImpl implements ITencentBO {

    public static final String TENXUN_CHAT_TUOGUAN_URL = "https://console.tim.qq.com/v4/registration_service/register_account_v1";

    public static final String TENXUN_CHAT_DULI_URL = "https://console.tim.qq.com/v4/im_open_login_svc/account_import";

    @Autowired
    private ISYSConfigBO sysConfigBO;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader()
            .getResource("config.properties"));
    }

    /** 
     * @see com.cdkj.coin.bo.ITencentBO#register(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void register(String userId, String companyCode, String systemCode) {
        Map<String, String> sysConfigMap = sysConfigBO.getConfigsMap(
            EConfigType.TENCENT_IM.getCode(), companyCode, systemCode);
        String txAppCode = sysConfigMap.get(SysConstants.TX_APP_CODE);
        String txAppAdmin = sysConfigMap.get(SysConstants.TX_APP_ADMIN);
        String accessKey = sysConfigMap.get(SysConstants.TX_ACCESS_KEY);
        String secretKey = sysConfigMap.get(SysConstants.TX_SECRET_KEY);
        String accountType = sysConfigMap.get(SysConstants.TX_ACCOUNT_TYPE);

        if (StringUtils.isBlank(txAppCode)) {
            throw new BizException("xn0000", "应用编号不能为空");
        }
        if (StringUtils.isBlank(txAppAdmin)) {
            throw new BizException("xn0000", "管理员不能为空");
        }
        if (StringUtils.isBlank(accessKey)) {
            throw new BizException("xn0000", "公钥不能为空");
        }
        if (StringUtils.isBlank(secretKey)) {
            throw new BizException("xn0000", "密钥不能为空");
        }
        if (StringUtils.isBlank(accountType)) {
            throw new BizException("xn0000", "账号类型不能为空");
        }
        tls_sigcheck demo = new tls_sigcheck();
        // 使用前请修改动态库的加载路径
        // demo.loadJniLib("C:\\Users\\asus\\Desktop\\ww\\jnisigcheck.dll");
        demo.loadJniLib("/mnt/www/coin/jnisigcheck.so");
        int ret = demo.tls_gen_signature_ex2(txAppCode, txAppAdmin, secretKey);
        if (0 != ret) {
            throw new BizException("xn0000", "发送失败");
        }
        ret = demo.tls_check_signature_ex2(demo.getSig(), accessKey, txAppCode,
            txAppAdmin);
        if (14 == ret) {
            throw new BizException("xn0000", "应用编号不符合");
        }

        try {
            sendChildSms(TENXUN_CHAT_TUOGUAN_URL + "?usersig=" + demo.getSig()
                    + "&apn=1&identifier=" + txAppAdmin + "&sdkappid="
                    + txAppCode + "&contenttype=json", userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * @see com.cdkj.coin.bo.ITencentBO#getSign(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public XN625000Res getSign(String userId, String companyCode,
            String systemCode) {
        Map<String, String> sysConfigMap = sysConfigBO.getConfigsMap(
            EConfigType.TENCENT_IM.getCode(), companyCode, systemCode);
        String txAppCode = sysConfigMap.get(SysConstants.TX_APP_CODE);
        String txAppAdmin = sysConfigMap.get(SysConstants.TX_APP_ADMIN);
        String accessKey = sysConfigMap.get(SysConstants.TX_ACCESS_KEY);
        String secretKey = sysConfigMap.get(SysConstants.TX_SECRET_KEY);
        String accountType = sysConfigMap.get(SysConstants.TX_ACCOUNT_TYPE);

        if (StringUtils.isBlank(txAppCode)) {
            throw new BizException("xn0000", "应用编号不能为空");
        }
        if (StringUtils.isBlank(txAppAdmin)) {
            throw new BizException("xn0000", "管理员不能为空");
        }
        if (StringUtils.isBlank(accessKey)) {
            throw new BizException("xn0000", "公钥不能为空");
        }
        if (StringUtils.isBlank(secretKey)) {
            throw new BizException("xn0000", "密钥不能为空");
        }
        if (StringUtils.isBlank(accountType)) {
            throw new BizException("xn0000", "账号类型不能为空");
        }
        tls_sigcheck demo = new tls_sigcheck();
        // 使用前请修改动态库的加载路径
        // demo.loadJniLib("C:\\Users\\asus\\Desktop\\ww\\jnisigcheck.dll");
        demo.loadJniLib("/mnt/www/coin/jnisigcheck.so");
        int ret = demo.tls_gen_signature_ex2(txAppCode, userId, secretKey);
        if (0 != ret) {
            throw new BizException("xn0000", "发送失败");
        }
        XN625000Res res = new XN625000Res();
        res.setTxAppCode(txAppCode);
        res.setTxAppAdmin(txAppAdmin);
        res.setAccountType(accountType);
        res.setAccessKey(accessKey);
        res.setSecretKey(secretKey);
        res.setSign(demo.getSig());
        return res;
    }

    private static String sendChildSms(String url, String account) {
        String codingType = "UTF-8";
        String backEncodType = "UTF-8";
        try {
            JsonObject smsParams = new JsonObject();
            smsParams.addProperty("Identifier",
                URLEncoder.encode(account, codingType));
            smsParams.addProperty("Password",
                URLEncoder.encode(EUserPwd.Beicoin.getCode(), codingType));
            smsParams.addProperty("IdentifierType", 3);
            String sendSms = smsParams.toString();
            return doAccessHTTPPostJson(url, sendSms, backEncodType);
        } catch (Exception e) {
            e.printStackTrace();
            return "未发送，编码异常";
        }
    }

    /**
     * POSTJson访问方法
     * @param sendUrl ：访问URL        
     * @param paramStr ：参数串  
     * @param backEncodType  ：返回的编码         
     * @return
     */
    public static String doAccessHTTPPostJson(String sendUrl, String sendParam,
            String backEncodType) {
        StringBuffer receive = new StringBuffer();
        BufferedWriter wr = null;
        try {
            if (backEncodType == null || backEncodType.equals("")) {
                backEncodType = "UTF-8";
            }

            URL url = new URL(sendUrl);
            HttpURLConnection URLConn = (HttpURLConnection) url
                .openConnection();

            URLConn.setDoOutput(true);
            URLConn.setDoInput(true);
            ((HttpURLConnection) URLConn).setRequestMethod("POST");
            URLConn.setUseCaches(false);
            URLConn.setAllowUserInteraction(true);
            HttpURLConnection.setFollowRedirects(true);
            URLConn.setInstanceFollowRedirects(true);

            URLConn.setRequestProperty("Content-Type",
                "application/json;charset=UTF-8");
            URLConn.setRequestProperty("Content-Length",
                String.valueOf(sendParam.getBytes().length));

            DataOutputStream dos = new DataOutputStream(
                URLConn.getOutputStream());
            dos.writeBytes(sendParam);

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                URLConn.getInputStream(), backEncodType));
            String line;
            while ((line = rd.readLine()) != null) {
                receive.append(line).append("\r\n");
            }
            rd.close();
        } catch (java.io.IOException e) {
            receive.append("访问产生了异常-->").append(e.getMessage());
            e.printStackTrace();
        } finally {
            if (wr != null) {
                try {
                    wr.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                wr = null;
            }
        }
        System.out.println(receive);
        return receive.toString();
    }

}
