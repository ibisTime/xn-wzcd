/**
 * @Title ADAOTest.java 
 * @Package com.ibis.pz.base 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 下午2:14:29 
 * @version V1.0   
 */
package com.cdkj.loan.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringApplicationContext;

import com.cdkj.loan.aliyun.util.HttpUtils;

/** 
 * 此类只供数据层测试使用，用于数据回滚
 * @author: miyb 
 * @since: 2015-2-6 下午2:14:29 
 * @history:
 */
@Transactional(transactionManagerName = "transactionManager", value = TransactionMode.COMMIT)
public abstract class ADAOTest extends UnitilsJUnit4 {
    @SpringApplicationContext({ "classpath:spring/applicationContext.xml" })
    protected ApplicationContext applicationContext;

    protected static final Logger logger = LoggerFactory
        .getLogger(ADAOTest.class);

    public static void main(String[] args) {
        String host = "http(s)://jisucxdq.market.alicloudapi.com/car/brand";
        String path = "ALIYUN_HOST_REST_CODE";
        String method = "GET";
        String appcode = "ALIYUN_APPCODE";
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
        // 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();

        try {
            /**
            * 重要提示如下:
            * HttpUtils请从
            * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
            * 下载
            *
            * 相应的依赖请参照
            * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
            */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers,
                querys);
            System.out.println(response.toString());
            // 获取response的body
            // System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
