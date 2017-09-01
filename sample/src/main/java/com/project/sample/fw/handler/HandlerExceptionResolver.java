package com.project.sample.fw.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

public class HandlerExceptionResolver extends AbstractHandlerExceptionResolver{

    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
	    Exception ex) {
	// TODO Auto-generated method stub
	LOGGER.debug("###########################################");
	return null;
    }

}
