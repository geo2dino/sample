package com.project.sample.fw.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.commons.configuration.CompositeConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.project.sample.comm.dao.CommDAO;

@Component(value="globalCfg")
public class GlobalCfg {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalCfg.class);

    private ConcurrentHashMap<String, Object> globalConf;

    @Resource
    private CommDAO commDAO;

    /**
     * Global 설정 : global-config.xml + tb_db_config => 환경설정
     * 동기화
     * XML <-> DB <-> FRONT(key)
     */
    @Resource(name="globalConfig")
    public CompositeConfiguration config;

    //GLOBAL_CFG + DB_CFG
    public Map<String, Object> getMap(){

//	LOGGER.info("key="+config.getString("key"));
//	LOGGER.info("list="+config.getList("list"));
//	LOGGER.info("test="+config.getKeys("test"));

//	Iterator<String> it = config.getKeys("test");
//	while(it.hasNext()){
//	    String key = it.next();
//	    LOGGER.info(key+"="+config.getString(key));
//	}
//	for (Iterator<String> it = sysConfig.getKeys("test"); it.hasNext();){
//	    String key = it.next();
//	    LOGGER.info(key+"="+sysConfig.getString(key));
//	}

	LOGGER.info("Number="+config.getNumberOfConfigurations());
	Iterator<String> it = config.getKeys();
	while(it.hasNext()){
	    String key = it.next();
	    LOGGER.info(key+"="+config.getString(key));
	}

	//Object getArray
	//<T> Collection <T> getCollection
	//List < Object > getList - <name>OK,Cancel,Help</name>
	//String [] getStringArray
	//HierarchicalConfiguration sub = config.configurationAt("tables.table(0)");
	//CompositeConfiguration
//	config.getSource(key);
	return new HashMap<String,Object>();
    }

}
