package com.loan.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Angel on 2017/4/19.
 */
public class RandomUtil {
    /**
     *  生成随机文件名：当前年月日时分秒+六位随机数
     *  @return
     *  */
    public static String getRandomTranSName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (999999 - 100000 + 1)) + 100000;// 获取6位随机数

        return "T" + rannum + str;// 当前时间
    }

    public static String getRandomOrderId(){
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String string = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (9999999 - 1000000 + 1)) + 1000000;// 获取7位随机数
        return "G" + rannum + string;//当前时间
    }

//    public static void main(String[] args) {
//
//        String fileName = RandomUtil.getRandomTranSName();
//
//        System.out.println(fileName);//8835920140307
//    }
}
