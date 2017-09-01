package com.project.sample.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.sample.api.constant.ErrorCodes;
import com.project.sample.api.params.ReqSampleDTO;
import com.project.sample.api.params.ResBaseDTO;
import com.project.sample.api.params.ResSampleDTO;
import com.project.sample.api.service.ApiService;
import com.project.sample.comm.utils.LogUtil;
import com.project.sample.fw.exception.ApiException;

@Controller
@RequestMapping(value="api")
public class ApiController extends ApiBaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @Resource
    private ApiService apiService;

    @RequestMapping(value="/key/{val}/sample",
    	    	method=RequestMethod.POST,
    	    	consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
	    )
    @ResponseBody
    public ResBaseDTO sampleJson(@PathVariable("key") String val,
	    	@RequestBody ReqSampleDTO reqSampleDTO,
	    	HttpServletRequest request
	    ) throws Exception{
	ResBaseDTO resBaseDTO = null;
	ResSampleDTO resSampleDTO = null;
	LOGGER.info("["+LogUtil.getUID()+"][REQ]["+request.getServletPath()+"]: "+reqSampleDTO);
	try {
	    if(!reqSampleDTO.isValidation()){
		throw new ApiException(ErrorCodes.E10002.getCode());
	    }
	    resSampleDTO = apiService.sample(reqSampleDTO);
	    resBaseDTO = resSampleDTO;
	} catch (ApiException ae) {
	    LOGGER.error("[API][UID:"+LogUtil.getUID()+"][ApiException:"+ae.getErrorCode()+"]");
	    resBaseDTO = getResError(ae);
	} catch (Exception e) {
	    LOGGER.error("[API][UID:"+LogUtil.getUID()+"][Exception:"+e.getMessage()+"]",e);
	    resBaseDTO = getResError(null);
	} finally {
	    // TODO : finally
	}
	LOGGER.info("["+LogUtil.getUID()+"][RES]["+request.getServletPath()+"]: "+resBaseDTO);
	return resBaseDTO;
    }

    @RequestMapping(value="/key/{val}/sample",
	    	method=RequestMethod.POST,
	    	consumes={ MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.TEXT_PLAIN_VALUE }
	    )
    @ResponseBody
    public String sampleParams(@PathVariable("key") String val,
	    	@RequestBody ReqSampleDTO reqSampleDTO,
	    	HttpServletRequest request
	    ) throws Exception{
	ResBaseDTO resBaseDTO = null;
	ResSampleDTO resSampleDTO = null;
	LOGGER.info("["+LogUtil.getUID()+"][REQ]["+request.getServletPath()+"]: "+reqSampleDTO);
	try {
	    //validPathVariable(ReqSampleDTO, val);
	    if(!reqSampleDTO.isValidation()){
		throw new ApiException(ErrorCodes.E10002.getCode());
	    }
	    resSampleDTO = apiService.sample(reqSampleDTO);
	    resBaseDTO = resSampleDTO;
	} catch (ApiException ae) {
	    LOGGER.error("[API][UID:"+LogUtil.getUID()+"][ApiException:"+ae.getErrorCode()+"]");
	    resBaseDTO = getResError(ae);
	} catch (Exception e) {
	    LOGGER.error("[API][UID:"+LogUtil.getUID()+"][Exception:"+e.getMessage()+"]",e);
	    resBaseDTO = getResError(null);
	} finally {
	    // TODO : finally
	}
	LOGGER.info("["+LogUtil.getUID()+"][RES]["+request.getServletPath()+"]: "+resSampleDTO.toParameters());
	return resBaseDTO.toParameters();
    }

}
