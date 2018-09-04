package com.loan.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Angel on 2017/5/20.
 */
public class DateUtil {

    public static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String getTimeFromStamp(Long timestamp,String formatStr){
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = new Date(timestamp);
        return format.format(date);
    }

    public static Date getDateFromString(String dateString,String formatStr){

        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            logger.error("日期格式错误",e);
            throw new RuntimeException("日期格式错误");
        }
    }
}
