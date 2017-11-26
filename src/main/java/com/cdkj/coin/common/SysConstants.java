package com.cdkj.coin.common;

public class SysConstants {

    public static final String admin = "admin";

    public static final String COLLECTION_LIMIT = "collection_limit"; // 账户余额大于等于该值时，进行归集

    public static final String TRADE_FEE_RATE = "trade_fee_rate"; // 交易手续费

    public static final String WITHDRAW_FEE = "withdraw_fee"; // 提现手续费

    public static final String FEN_CHENG_FEE = "fen_cheng_fee"; //分成手续费

    // 七牛云图片配置
    public static String QINIU_ACCESS_KEY = "qiniu_access_key";

    public static String QINIU_SECRET_KEY = "qiniu_secret_key";

    public static String QINIU_BUCKET = "qiniu_bucket";

    public static String QINIU_DOMAIN = "qiniu_domain";

    // 腾讯云配置
    public static String TX_APP_CODE = "tx_app_code";// 应用编号

    public static String TX_APP_ADMIN = "tx_app_admin";// 应用编号

    public static String TX_ACCESS_KEY = "tx_access_key";// 公钥

    public static String TX_SECRET_KEY = "tx_secret_key";// 私钥

    public static String TX_ACCOUNT_TYPE = "tx_account_type";// 账号类型

    // C端用户取现倍数
    public static String CUSERQXBS = "CUSERQXBS";

    // C端用户取现费率
    public static String CUSERQXFL = "CUSERQXFL";

    // C端用户取现时效
    public static String CUSERQXSX = "CUSERQXSX";

    // C端用户每月取现次数
    public static String CUSERMONTIMES = "CUSERMONTIMES";

    // C端2C端转账金额倍数
    public static String TRANSAMOUNTBS = "TRANSAMOUNTBS";

    // 取现单笔最大金额
    public static String QXDBZDJE = "QXDBZDJE";

}
