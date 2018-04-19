package com.loan.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
    public static final String DATEPATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String getDateString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DATEPATTERN);
		return sdf.format(date.getTime());
    }
}
