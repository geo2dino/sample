package com.project.sample.api.controller;

import com.project.sample.api.constant.ErrorCodes;
import com.project.sample.api.params.ResBaseDTO;
import com.project.sample.api.params.ResErrorDTO;
import com.project.sample.fw.common.AbstractController;
import com.project.sample.fw.exception.ApiException;

public class ApiBaseController extends AbstractController{

    protected ResBaseDTO getResError() {
	return getResError(null);
    }

    protected ResBaseDTO getResError(Object obj) {
	ResErrorDTO resErrorDTO = new ResErrorDTO();
	String errorCd = ErrorCodes.E10001.getCode();
	if(obj == null){
	    errorCd = ErrorCodes.E10001.getCode();

	} else if(obj instanceof ApiException){
	    errorCd = ((ApiException) obj).getErrorCode();

	} else if(obj instanceof Exception){
	    errorCd = ErrorCodes.E10001.getCode();
	}
	resErrorDTO.setErrorCd(errorCd);
	return resErrorDTO;
    }
}
