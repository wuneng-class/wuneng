package edu.nf.wuneng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 创建订单编号
 * @author YXD
 * @date 2020/4/6
 */
public class CreateNo {

    public static String createTradeNo(){
        Random r=new Random();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");
        String subjectNo=sdf.format(new Date())+r.nextInt(10);
        String WIDout_trade_no=subjectNo+r.nextInt(10);
        return WIDout_trade_no;
    }

}