package com.project.sample.comm.utils;

public class CommonUtil {

    public static String getSystemProperty(String key){
   	return System.getProperty(key, "");
    }
}
