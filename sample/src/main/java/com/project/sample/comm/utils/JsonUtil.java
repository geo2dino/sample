package com.project.sample.comm.utils;

import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    public static String jsonToObject(Object obj) throws Exception{
	String result = null;
	ObjectMapper om = new ObjectMapper();
	try {
	    result = om.writeValueAsString(obj);
	} catch (IOException e) {
	    LOGGER.error("jsonToObject", "obj","");
	}
	return result;
    }

    public static Object objToJson(String json, Class<?> cls) throws Exception{
	Object result = null;
	ObjectMapper om = new ObjectMapper();
	try {
	    result = om.readValue(json, cls);
	} catch (IOException e) {
	    LOGGER.error("objToJson", "json",json);

	}
	return result;
    }

    public static HashMap<String, String> mapToJson(String json) throws Exception{
	HashMap<String, String> map = null;
	ObjectMapper om = new ObjectMapper();
	try {
	    map = om.readValue(json, new TypeReference<HashMap<String, String>>(){});
	} catch (IOException e) {
	    LOGGER.error("mapToJson", "json",json);
	}
	return map;
    }

    public static void main(String[] args) {
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("product_id", "0");
	try {
	    System.out.println(JsonUtil.jsonToObject(map));
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
