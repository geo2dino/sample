package com.project.sample.comm.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class HttpUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

//    public static final int BUFFER_SIZE = 4096;

    public static String getIp(HttpServletRequest request) {
	String clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
	if(null == clientIp || clientIp.length() == 0
	   || clientIp.toLowerCase().equals("unknown")){
	  clientIp = request.getHeader("REMOTE_ADDR");
	}
	if(null == clientIp || clientIp.length() == 0
	   || clientIp.toLowerCase().equals("unknown")){
		clientIp = request.getRemoteAddr();
	}
	return clientIp;
    }

    public static boolean isValidation(HttpServletRequest request, String key, String regex) {
	return isValidation(request.getParameter(key), regex);
    }

    public static final boolean isValidation(String val, String regex) {
	if(val != null){
		try {
			return val.matches(regex);
		} catch (Exception e) {
		    LOGGER.error("isValidation", "val",val,"regex",regex);
		}
	}
	return false;
    }

    public static final HashMap<String, String> getHeaders(final HttpServletRequest request){
	HashMap<String, String> map = new HashMap<String, String>();
	if(request == null){
		return map;
	}
	try {
		String key = null;
		Enumeration<?> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			map.put(key, request.getHeader(key));
		}
	} catch (Exception e) {
	    LOGGER.error("getHeaders", "url",request.getRequestURI());
	}
	return map;
    }

    public static final HashMap<String, String> getQuery(final HttpServletRequest request){
	HashMap<String, String> map = new HashMap<String, String>();
	if(request == null || request.getQueryString() == null){
		return map;
	}
	try {
		String[] params = request.getQueryString().split("&");
		for(String val : params){
			String[] param = val.split("=", 2);
			if(param.length > 1){
				map.put(param[0], param[1]);//UrlEncoder
			} else {
				map.put(param[0], "");
			}
		}
	} catch (Exception e) {
	    LOGGER.error("getQuery", "url",request.getRequestURI());
	}
	return map;
    }

    public static final HashMap<String, Object> getParameters(final HttpServletRequest request){
	HashMap<String, Object> map = new HashMap<String, Object>();
	if(request == null){
		return map;
	}
	try {
		String key = null;
		Enumeration<?> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			String[] val = request.getParameterValues(key);
			if(val.length == 1){
				//LOGGER.debug(key+"="+val[0]);
				map.put(key, val[0]);
			} else if(val.length > 1){
				map.put(key, val);
			} else {
				map.put(key, "");
			}
		}
	} catch (Exception e) {
	    LOGGER.error("getParameters", "url", request.getRequestURI());
	}
	return map;
    }

    public static String getMultipartParameter(HttpServletRequest request, String paramName){
	String result = "";
	if(request == null){
		return result;
	}
	try {
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		if(multipart != null && !StringUtil.isEmpty(paramName)){
			Enumeration<?> e = multipart.getParameterNames();
			while(e.hasMoreElements()) {
				String name = (String) e.nextElement();
				if(paramName.equalsIgnoreCase(name)){
					result = multipart.getParameter(name);
					break;
				}
			}
		}
	} catch (Exception e) {
	    LOGGER.error("getMultipartParameter", "url",request.getRequestURI(),"paramName",paramName);
	}
	return result;
    }

    public static MultipartFile getMultipartFile(HttpServletRequest request, String fileName){
	if(request == null){
		return null;
	}
	MultipartFile mf = null;
	try {
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		if(multipart != null && !StringUtil.isEmpty(fileName)){
			Iterator<String> it = multipart.getFileNames();
			while(it.hasNext()){
				String name = it.next();
				if(fileName.equalsIgnoreCase(name)){
					mf = multipart.getFile(name);
					break;
				}
			}
		}
	} catch (Exception e) {
	    LOGGER.error("getMultipartFile", "url",request.getRequestURI(),"fileName",fileName);
	}
	return mf;
    }

    public static List<MultipartFile> getMultipartFile(HttpServletRequest request) {
	List<MultipartFile> mfs = new ArrayList<MultipartFile>();
	if(request == null){
		return mfs;
	}
	try {
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		if(multipart != null){
			Iterator<String> it = multipart.getFileNames();
			while(it.hasNext()){
				String name = it.next();
				mfs.add(multipart.getFile(name));
			}
		}
	} catch (Exception e) {
	    LOGGER.error("getMultipartFile", "url",request.getRequestURI());
	}
	return mfs;
    }

}
