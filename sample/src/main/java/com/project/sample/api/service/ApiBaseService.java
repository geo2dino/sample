package com.project.sample.api.service;

import javax.annotation.Resource;

import com.project.sample.comm.dao.CommDAO;
import com.project.sample.fw.common.AbstractService;

public class ApiBaseService extends AbstractService{

    @Resource
    protected CommDAO commDAO;

}
