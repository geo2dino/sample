package com.project.sample.api.service;

import com.project.sample.api.params.ReqSampleDTO;
import com.project.sample.api.params.ResSampleDTO;
import com.project.sample.fw.exception.ApiException;

public interface ApiService {

    public ResSampleDTO sample(ReqSampleDTO reqSampleDTO) throws ApiException;

}
