package com.project.sample.fw.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest request) {
	super(request);
	// TODO Auto-generated constructor stub
    }

    @Override
    public String[] getParameterValues(String name) {
        // TODO Auto-generated method stub
	String[] values = super.getParameterValues(name);
	if(values != null){
	    for(int i=0; i<values.length; i++){
		values[i] = xssFilter(values[i]);
	    }
	}
	return values;
//        return super.getParameterValues(name);
    }

    @Override
    public String getParameter(String name) {
        // TODO Auto-generated method stub
	return xssFilter(super.getParameter(name));
//        return super.getParameter(name);
    }

    @Override
    public Map<String,String[]> getParameterMap() {
        // TODO Auto-generated method stub
        return super.getParameterMap();
    }

    @Override
    public String getHeader(String name) {
        // TODO Auto-generated method stub
	return xssFilter(super.getHeader(name));
//        return super.getHeader(name);
    }

    public String xssFilter(String value) {
	return (value != null ? value.replaceAll("<", "%3C").replaceAll(">", "%3E") : value);
    }

}
