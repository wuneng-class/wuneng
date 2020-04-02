package edu.nf.wuneng;

import java.util.Calendar;
import java.util.Random;

/**
 * @author YXD
 * @date 2020/4/2
 */
public class CodeUtil {

    private static Random r = new Random();

    /**
     * 随机生成固定长度的验证码
     */
    public static String randomCode(int length) {
        double number = (1 + r.nextDouble()) * Math.pow(10, length);
        String str = String.valueOf(number);
        return str.substring(1, length + 1);
    }

    /**
     * sj单位：分钟
     * @param sj
     * @return
     */
    public static long date(int sj) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE)+sj);
        return c.getTime().getTime();//失效时间
    }

}