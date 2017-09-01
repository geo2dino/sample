package com.project.sample.comm.utils;

import java.util.List;
import java.util.Map;

public class StringUtil {

    //문자 공간 제거 - getUnspace
    //숫자 -> , 문자 - getComma, getUncomma
    //문자 -> 숫자   - getInt, getFloat

    public static boolean matches(String val, String regex){
	if(isNull(val)){
	    return false;
	}
	return val.matches(regex);
    }

    public static int getSize(Object o){
	if(o == null){
		return -1;
	}
	if(o instanceof String) {
		return ((String) o).length();
	} if(o instanceof String[]) {
		return ((String[]) o).length;
	} if(o instanceof List) {
		return ((List<?>) o).size();
	} if(o instanceof Map) {
		return ((Map<?,?>) o).size();
	}
	return 0;
    }

    public static boolean isEmpty(String s){
	return isEmpty(s);
    }

    public static boolean isEmpty(Object o){
	if(o != null){
		if(o instanceof Integer) {
			if((Integer) o == 0){
				return true;
			}
		} else if(o instanceof String) {
			if(((String) o).length() == 0){
				return true;
			}
		} else if(o instanceof String[]) {
			if(((String[]) o).length == 0){
				return true;
			}
		} else if(o instanceof List) {
			if(((List<?>) o).size() == 0){
				return true;
			}
		} else if(o instanceof Map) {
			if(((Map<?,?>) o).size() == 0){
				return true;
			}
		}
		return false;
	}
	return true;
    }

    public static boolean isNull(Object o){
	return o == null ? true : false;
    }

    public static void main(String[] args) {
	//테스트
    }

}
