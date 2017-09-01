package com.project.sample.api.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.sample.api.dao.ApiDAO;
import com.project.sample.api.params.ReqSampleDTO;
import com.project.sample.api.params.ResSampleDTO;
import com.project.sample.api.service.ApiBaseService;
import com.project.sample.api.service.ApiService;
import com.project.sample.fw.exception.ApiException;

@Service
public class ApiServiceImpl extends ApiBaseService implements ApiService {

//    private static final Logger LOGGER = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Resource
    private ApiDAO apiDAO;

    @Transactional(readOnly=false,
	    isolation=Isolation.READ_COMMITTED,
	    propagation=Propagation.REQUIRED,
	    rollbackFor=Exception.class)
    @Override
    public ResSampleDTO sample(ReqSampleDTO reqSampleDTO) throws ApiException {
	ResSampleDTO resSampleDTO = new ResSampleDTO();
	// TODO Auto-generated method stub
	return resSampleDTO;
    }
}
