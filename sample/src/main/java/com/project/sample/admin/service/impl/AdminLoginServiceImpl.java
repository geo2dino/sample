package com.project.sample.admin.service.impl;

import javax.annotation.Resource;

import com.project.sample.admin.dao.AdminLoginDAO;
import com.project.sample.admin.service.AdminBaseService;
import com.project.sample.admin.service.AdminLoginService;

public class AdminLoginServiceImpl extends AdminBaseService implements AdminLoginService{

//  private static final Logger LOGGER = LoggerFactory.getLogger(AdminLoginServiceImpl.class);

    @Resource
    private AdminLoginDAO adminLoginDAO;

}
