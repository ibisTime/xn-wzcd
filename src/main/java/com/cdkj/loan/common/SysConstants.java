package com.cdkj.loan.common;

public class SysConstants {

    public static final String admin = "admin";

    public static final String WITHDRAW_FEE = "withdraw_fee"; // 提现手续费

    // 信用分配置
    public static final String REGISTER_ADD = "register_add"; // 新用户注册初始信用分

    public static final String CAR_NORMAL = "car_normal"; // 车贷还款计划每正常执行一次

    public static final String PRODUCT_NORMAL = "product_normal"; // 商品还款计划每正常执行一次

    public static final String CAR_DELAY = "car_delay"; // 商品还款计划每延期执行一次

    public static final String PRODUCT_DELAY = "product_delay"; // 商品还款计划每延期执行一次

    // 七牛云图片配置
    public static String QINIU_ACCESS_KEY = "qiniu_access_key";

    public static String QINIU_SECRET_KEY = "qiniu_secret_key";

    public static String QINIU_BUCKET = "qiniu_bucket";

    public static String QINIU_DOMAIN = "qiniu_domain";

    // 取现规则配置
    public static String CUSERQXBS = "CUSERQXBS"; // C端用户取现倍数

    public static String CUSERQXFL = "CUSERQXFL"; // C端用户取现费率

    public static String CUSERQXSX = "CUSERQXSX"; // C端用户取现时效

    public static String CUSERMONTIMES = "CUSERMONTIMES"; // C端用户每月取现次数

    public static String TRANSAMOUNTBS = "TRANSAMOUNTBS"; // C端2C端转账金额倍数

    public static String QXDBZDJE = "QXDBZDJE"; // 取现单笔最大金额

    // 短信模板
    public static String ORDER_CONTACT = "您的广告刚刚被新用户关注，可能随时跟您聊天，赶紧去看看吧！"; // 有人开始聊天

    public static String ORDER_SUBMIT = "您发布的广告已经有新用户下单了噢，赶紧去处理吧！"; // 有人下单

    public static String ARBITRATE = "您有一个新的仲裁订单（编号：%s）需要处理！"; // 有人仲裁

    public static String WITHDRAW = "您有一个新的取现订单（编号：%s）需要处理！"; // 有人提现

    // 短信通知配置
    public static String ZC_SMS_NOTICE = "zc_sms_notice"; // 仲裁短信通知

    public static String QX_SMS_NOTICE = "qx_sms_notice";// 取现短信通知

}
