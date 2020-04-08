package edu.nf.wuneng.conf;

/**
 * @author YXD
 * @date 2020/4/6
 */
public class AlipayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String app_id = "2016101100663145";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDum38YpP4a+3sQdY9BhYJ17khCla4Gra2jzlPGvAOKZCNXrzp9cL74fvU7dqFsyMpvIHWI8QcmnujJkDx4eDtiSEk25nR+ncdDO+TF681KEpwfZv2/PrX88yfrOmj23448GjVs6wzHa1gZ7PIy3CoIDeh4ohhAWjylaaWtZEHY2Xt17QSOn6zmjjZ0NdNNnAqLAs1WAJcLhwYSxRIimWpObWgaQpeENeeP7NUQNKnLT6C5jV1zFc6qyal7+K+utejxxav1ABz138p4VJNy6gMIHWxCvzHF1lwe6/wLzkJwzfUVEVK0ihyL6HLDaPN6Lj6f6TZHMJbIsO7TcVhXUNUNAgMBAAECggEBAOpXI3sjyEDdzd67ZsfWBOwn6yYh9Tmv54KiiFr9moiXkrJycYJzccuCfP06pI2/ojmD6otlFT3UAhK8KveyNbhwACAANFeKRAJ/V08fKI7gOh8JOptSTtAwS3tV8XLM2teicegX7YQJpAxKTxCudEVWy4N2x1Skiz11xfbGKXl7MY+NeXeiyf58TC/f6Djvsb5FsZbZVDpNvjKwFCQZ6pBor7TY7LgBgD6hxLWoflDqIiwhW4MKZ3yhqd+jM2YzpkoJao9aeTiz4QMru6+dyBh4+n1WS7b9vVvG03XiV0Vfe5m1tYG3E/QxZTo7iJNeQJL9OGSAcdqx6bcO5HPbcgECgYEA/RyrAWAdSemRxfgf/oRERJHdJ0hn4SXz1gzlvxqcrigro0uJZJKSWRwyIcmhDrj6sPiTI2UjN9EDYHKh5pvGR74aVwvuohG4B8EI7jsM6j64TQi5CF3hb5PG4BmclrnZzTuTaP72v8b/r1tIoLsheHo/63fXRLHPVUuQ0u16S40CgYEA8VR2CSCYfHIpITxpe1NI1PKtnymIlQusfUG51LLvoo/jtGw+GEW04XI61ATtGnq29Qjei8tyfFmEdW0V+ZRo0hB9tqVcvpeowAbyPWahjbX6Ok6UZv5ij7Lv8YRnq5CNwHVdmrTGHDtukANp4WezZFoVSWtDrLhOOPxJZaCxj4ECgYEAsX7XFKHYKCrZBOEZXpxWW1eGpLOL1UGOGr70pez9jsuwvlSMRrDaXA7/wN3qSa7CbjQCysFzzwKNwabhjhwTEeBoDD7b219dlGJz5swWJHZTPAIv74QWQO56elC7lJ9D8z4iA3E4jAf66Xe0GLLhp+Dizjc+CHhAkuno52GNb0kCgYEAoNdZAAZQewifLv6TktVUQlEntF+7HxMzuBu5HfDQU/kwmwxValnzDxrR6IML/8zv6Woq4OMMf6It7RFyRvBJ2E+TacrWgFSV7L30b0XawJcbmgbLU8WRrRJmZwKHEcp7H11ZsIVxUFmv+5260LcL0gNUEqXB6fjAcax7wpcSIIECgYEA7Sy/bEyTAomcEJgJ+5Zn0lQdcfd+O2pcZTNhRV0oFHz0DL+1hf0jy+MfrHJf/pnqfzReZuwF8sj7+DpuCbv6eklphTEpJXmH6gqBmsx/ee3QMDJlDkgvwGWdEg3mGcG2Jfiv/5Etb9u2dERzOl5aJfmgcaDDfcjsodkosTERqNI=";
    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApYPjeM8HBwDDgCIEcojzbbYgBGFBTs/dMWD/1Fb6jaiIQzwVpKZvmgET9yc1+un7DvFwFaKMlTa2p/oaA45sm635x0oF1+31Vc1xyhN40lxPUi7AEcWjggbeoaV3eYBqH26h+bOlM53Pz4lmrTsfOG63DSAKn4HDFP9WLm2oWUR4dhhUxj1eYArM+go1QtZru9uQNEUIzsTk6ejB7ghyjadwSZTm8T18PFgMcpqfBivu5FmmLMJ6f4AvhPbhsX5wkjWiTeuymCq6vqoKqEfrIq9Qhz18ZB1GUhbTwag2yas6i0yEjxJStBswml6gx8UrQ6R9qNIykhwT2250dgP4DwIDAQAB";
    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String notify_url = "http://localhost:8080/kec/notify_url.jsp";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String return_url = "http://localhost:8080/wuneng/paySuccess";

    /**
     *  签名方式
     */
    public static String sign_type = "RSA2";

    /**
     * 字符编码格式
     */
    public static String charset = "utf-8";

    /**
     * 支付宝网关
     */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


}