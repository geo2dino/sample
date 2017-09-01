package com.project.sample.fw.handler;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component
public class StaticContext implements ApplicationContextAware, ServletContextAware{

    private static final StaticContext staticContext = new StaticContext();

    private ApplicationContext applicationContext;
    private ServletContext servletContext;

    public static <T> T getBean(Class<T> cls){
	return staticContext.applicationContext.getBean(cls);
    }

    public static Object getBean(String name){
	return staticContext.applicationContext.getBean(name);
    }

    public static ServletContext getServletContext(){
   	return staticContext.servletContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
	// TODO Auto-generated method stub
	this.servletContext = servletContext;
    }

    public static ApplicationContext getApplicationContext(){
	return staticContext.applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	// TODO Auto-generated method stub
	this.applicationContext = applicationContext;
    }

}
