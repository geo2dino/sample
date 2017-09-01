package com.project.sample.comm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

    public static final String YYYYMMDD ="yyyyMMdd";
    public static final String MMDD ="MMdd";
    public static final String HHMMSS ="HHmmss";
    public static final String HHMM ="HHmm";

    public static String getDateTime(long date){
	SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD+HHMMSS);
	return sdf.format(new Date(date));
    }

    public static String getCurrentDate(){
	return getCurrentDateTime(YYYYMMDD);
    }

    public static String getCurrentTime(){
	return getCurrentDateTime(HHMMSS);
    }

    public static String getCurrentDateTime(){
	return getCurrentDateTime(YYYYMMDD+HHMMSS);
    }

    public static String getCurrentDateTime(String pattern){
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	String dt = sdf.format(new Date());
	return dt;
    }

}
