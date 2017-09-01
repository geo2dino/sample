package com.project.sample.comm.utils;

import org.slf4j.Logger;

public class LogUtil {

    private static final int BODY_SIZE = 1000;
    public static final String TAB = ",";

    private ThreadLocal<String> logUID;

    private static LogUtil logUtil;

    static {
	logUtil = new LogUtil();
	logUtil.logUID = new ThreadLocal<String>();
    }

    public static String getUID(){
	return logUtil.logUID.get();
    }

    public static void setUID(){
	logUtil.logUID.set(Long.toString(System.currentTimeMillis()));
    }

    public static void removeUID(){
	logUtil.logUID.remove();
    }

    public static void info(Logger l, String uid, String... v){
	l.info("UID="+uid+getBody(v));
    }

    public static void error(Logger l, String uid, String... v){
	l.error("UID="+uid+getBody(v));
    }

    public static void error(Logger l, Throwable t, String uid, String... v){
	l.error("UID="+uid+getBody(v), t);
    }

    public static String getBody(String... v) {
	StringBuffer sb = new StringBuffer(BODY_SIZE);
	for(int i=0; i<v.length; i++){
	    String val = StringUtil.isNull(v[i]) ? "" : v[i].trim();
	    if(i%2 == 0){
		sb.append(TAB).append(val).append("=");
	    } else {
		sb.append(val);
	    }
	}
//	if(sb.capacity()>0){
//		sb.replace(0, 1, "§");
//	}
	return sb.toString();
    }
}
