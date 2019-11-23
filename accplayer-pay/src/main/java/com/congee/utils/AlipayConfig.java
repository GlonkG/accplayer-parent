package com.congee.utils;
import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101200670773";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC0uDwDG/2Aa7zPuSx4VF4A43yRlzRIK+0VQGJqGb8MMCrD3xHwwkl/ezCnn0bsj0BaKXHrvYxtC5uzhGt+UITYDRSZk5Y/06NfRe3rZalFCUWfXRwpZlnp87p3vTZ7O5lzMneI80yllMOR6MRyfda6qTic62ynjrD7IZ8UG4B7tslIeqTq0JBizmOseyH2s1oIriTIuSCnDOCv7nYOxTqPSMlLKTaNl/a4gtD4VHr9RVDT/NJHnlLTRUl/RljsAQazZs9/LG9KezTCqYO3bhx9U4dibUij5yZR8ZIi1JeCdHFJtbL1mhIvDnZNic9G/SJYX7Jr8Q2CzRhRca9tDRO/AgMBAAECggEAU91PVC4QFSFqLIeFQI3+VbE75KBjjb58tij7wrsR8okDv4PsYmr3CqbTbGY41pyfw3eKO1jqKsyBQ+yGqcaZ710amy5nQlVnclYUU/IIfFYSLiNaZ0ftH+mQNfLjrop46oGYAUDO5+RCYZrAV1VYaaUP9Zo3AQbx0IjItt8QX9gqaGjgdSlfU8nab7lhIbp6pLC6LNbjc6tMIRQJOYTovEYws9OmAmRqmNOoF5uhN1M/JmyaU4gxxBcC2BPvgdZzKV7emOXO3KnwDtGsyNy0lcCZsKuQHO2hjO5d/ImtaCCOS/ttlW5sCq30VGtzWsbsN9Ww9y/SETzrUwzb4dT1yQKBgQDiejQEtfYf1U7xEMNbbmaCrAmMjCDB4hT7cCW5xOP8trdZU9safHmIFVCfSIQlZllIOItFV+NLEGHDLtsuRNo41BNCIzWWpmLGQ7t2noeyDmiUUTGTImnc4hS910KJXkDfwOjBO+w04mreUv9M5O85OxT59lEglR+u4Y+vDZN4owKBgQDMRwwO67/HCEPO4kqV5T2TyP9pZbBMbnbbjri7O1MvvsTtWAbxAuGiDJsPNOeNGDf2paoXuOdAy6lgoOIGSHShyIPK+hl6SSnTDYHH4msN4ShrHWCjYQAMR4kIwxFJFynCMxaENP6rAz0nNx+RRYZ3JObqnr7qms7D943EwTYeNQKBgARzcmJFUTj+8DY8pho96TXYO7fPaTVmRBNM+PDVtcVZsfDHfR7gI2NRR+xZeH9jq42HzvTl7UmkYMd9PEGEiOVlBZvfJUZ4rqhG3IBQTUpqjhOcJOVHX90/dDjm6h/ZAl1jZS+nBdVkPcVwzCOuvCTbzGW9OYryY1UEidZe5e8RAoGBAKgznAcxMREmigbwp69zOdfVOhHD7H2Su4WfqBZrC90VfLtdryGGWNmA/bBwxHSWS4Zo9HxiAPCGgeoRruqzgG2yWGqqso3RboHc7k7y7WlZS1mfr/H3Lf3ubTRswm/nhbflLxYfOM8BdLo0lmac09KI7SalHdi5LaWI0g//c5s9AoGBAKEky7Ah66EfwqrGLsp2tEXrHxRSc9qbpn2f4RumDjnR8c54rqcjnS1MY2vHPMfsZOL5DiShroolxwd9fWfSPA/vt4jEYNB8xhprktRpBSUZ1gtEe9gq9mMbfIlcgq+KVWgOSDp8moZ4b01CREMJjQ4IwV4yecGoxwzry5QJzXbN";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxINUNXilqg1Y5PgKtuaVZwYPCbjGQ63JvDZddfM98fU7Az9YZCFRpNcNcLYqczoUnNVnIE5sXA/Qb9kPf/cQ6iB6YPA40bHWBEyiu98T/Ht7uG7Wq/4ig2hHRNdMgOnXwA8/5Dn1KApqWM+Xcy8MVphL6TXXjaoOqqUJfpAifD+eIhfSi/ZNRDvf4VEOSbP4sXc+SFFcE4xRveEyREzhltJhtJroLU5lpujGWrUvsBgJb5m29OxLOarU5C5WkQu7cpOpQabEVMsrDuj3hpQXww7PGjQqS5cVFf2Jod/anqtuA2NfZo9UBVys64B80A1vnSRQoOD9WoZjitsFSHhD+wIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/#/ShoppingCart";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/#/all";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path = "C:\\";
    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
