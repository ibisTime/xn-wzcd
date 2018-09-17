package demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

/**
 * @Description:运营商报告
 * @author york
 * @version v1.0.0
 */
public class MobileReportDemo extends AbstractCredit {

    // 业务参数
    // 身份证实名认证请求参数
    public static final String identityCardNo = "14272719950821351X";// 查询用户的身份证号-必填

    public static final String identityName = "柴运来";// 查询用户的真实姓名-必填

    public static void main(String[] args) throws Exception {

        // 启动信服务
        MobileReportDemo service = new MobileReportDemo();
        service.process();

    }

    public void process() throws Exception {

        try {

            // 提交受理请求对象
            List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();

            reqParam.add(new BasicNameValuePair("apiKey", apiKey));
            reqParam.add(new BasicNameValuePair("method", method));
            reqParam.add(new BasicNameValuePair("version", version));
            reqParam.add(new BasicNameValuePair("identityNo", identityCardNo));
            reqParam.add(new BasicNameValuePair("name", identityName));
            reqParam.add(new BasicNameValuePair("sign", getSign(reqParam)));// 请求参数签名

            doProcess(reqParam);
        } catch (Exception ex) {
            System.out.println("开始获取运营商信息异常：" + ex);
        }
    }

}
