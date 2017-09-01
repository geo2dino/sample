package com.project.sample.fw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.sample.comm.utils.LogUtil;

public class AdminInterceptor extends HandlerInterceptorAdapter{

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
	LOGGER.debug("###########################################");
	// controller 호출전
	LogUtil.setUID();
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
	LOGGER.debug("###########################################");
	// controller 호출후
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
	LOGGER.debug("###########################################");
	// view 호출후
	long startTime = System.currentTimeMillis();
	long endTime = startTime;
	String uid = LogUtil.getUID();
	if(uid != null){
	    startTime = Long.parseLong(uid);
	    LogUtil.removeUID();
	}
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
	LOGGER.debug("###########################################");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
