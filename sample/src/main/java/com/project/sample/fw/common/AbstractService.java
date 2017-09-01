package com.project.sample.fw.common;

import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.configuration.CompositeConfiguration;

import com.project.sample.comm.dao.CommDAO;

public class AbstractService {

    /**
     * System 프로퍼티 : system-property.xml
     */
    @Resource(name="systemProperty")
    private Properties properties;

    /**
     * System 설정 : system-config.xml
     */
    @Resource(name="systemConfig")
    public CompositeConfiguration sysCfg;

    @Resource
    protected CommDAO commDAO;

}
