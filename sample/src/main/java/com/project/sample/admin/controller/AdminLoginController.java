package com.project.sample.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.project.sample.admin.constant.ErrorCodes;
import com.project.sample.admin.params.AjaxParams;
import com.project.sample.admin.params.BaseParams;
import com.project.sample.admin.params.MainParams;
import com.project.sample.admin.params.ResJson;
import com.project.sample.admin.service.AdminLoginService;
import com.project.sample.comm.utils.LogUtil;
import com.project.sample.comm.utils.StringUtil;
import com.project.sample.fw.exception.AdminException;

@Controller
@RequestMapping(value="admin")
public class AdminLoginController extends AdminBaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminLoginController.class);

    @Resource
    private AdminLoginService adminLoginService;

    @RequestMapping({"/","/index"})
    public String index() throws Exception{
	LOGGER.debug("[main]");
	return "/index";
    }

    @RequestMapping(value="/main")
    public String main(MainParams mainParams,
	    	ModelMap model,
	    	HttpServletRequest request
	    ) throws Exception, AdminException{
	BaseParams baseParams = null;
	LOGGER.debug("[REQ_PARAMS]:" + mainParams);
	try {
	    Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
	    if(flashMap != null){
		//
	    }
	} catch (Exception e) {
	    LOGGER.error("[ADMIN][UID:"+LogUtil.getUID()+"][Exception:"+e.getMessage()+"]",e);
	    throw new AdminException(e);
	} finally {
	    model.put("var", baseParams);
	}
	LOGGER.debug("[RES_PARAMS]:" + mainParams);
	return "main/main";
    }

    @RequestMapping(value="/ajax",
	    	method=RequestMethod.POST,
	    	produces = MediaType.APPLICATION_JSON_UTF8_VALUE
	    )
    @ResponseBody
    public ResJson ajax(AjaxParams ajaxParams) throws Exception{
	ResJson resJson = null;
	LOGGER.debug("[REQ_PARAMS]:" + ajaxParams);
	try {
	    resJson = new ResJson();
	} catch (Exception e) {
	    LOGGER.error("[ADMIN][UID:"+LogUtil.getUID()+"][Exception:"+e.getMessage()+"]",e);
	    resJson = new ResJson(ErrorCodes.E10001.getCode(), ErrorCodes.E10001.getMessage());
	} finally {
	    LOGGER.debug("[RES_PARAMS]:" + ajaxParams);
	}
	return resJson;
    }

    @RequestMapping(value="/login")
    public String login() throws Exception{
	LOGGER.debug("[login]");
	return "login/login";
    }

    @RequestMapping(value="/login_success")
    public String loginSuccess(RedirectAttributes redirectAttributes) throws Exception{
	LOGGER.debug("[login_success]");
	redirectAttributes.addFlashAttribute("error_code", ErrorCodes.E10010.getCode());//1개만가능
	return "redirect:/admin/main";
    }

    @RequestMapping(value="/login_fail")
    public String loginFail(RedirectAttributes redirectAttributes) throws Exception{
	LOGGER.debug("[login_fail]");
	redirectAttributes.addFlashAttribute("error_code", ErrorCodes.E10012.getCode());
	return "redirect:/admin/login";
    }

    @RequestMapping(value="/login_duplicate")
    public String loginDuplicate(BaseParams baseParams,
	    	RedirectAttributes redirectAttr
	    ) throws Exception{
	LOGGER.debug("[login_duplicate]");
	SecurityContextHolder.getContext().setAuthentication(null);
	redirectAttr.addFlashAttribute("error_code", ErrorCodes.E10015.getCode());
	return "redirect:/admin/login";
    }

    @RequestMapping(value="/logout")
    public String logout(BaseParams baseParams,
	    	RedirectAttributes redirectAttr
	    ) throws Exception{
	LOGGER.debug("[logout]");
	SecurityContextHolder.getContext().setAuthentication(null);
	if(StringUtil.isEmpty(baseParams.getError_code())){
	    baseParams.setError_code(ErrorCodes.E10011.getCode());
	}
	redirectAttr.addFlashAttribute("error_code", baseParams.getError_code());
	return "redirect:/admin/login";
    }

    @RequestMapping(value="/logout_success")
    public String logoutSuccess(BaseParams baseParams,
	    	RedirectAttributes redirectAttr
	    ) throws Exception, AdminException{
	LOGGER.debug("[logout_success]");
	redirectAttr.addFlashAttribute("error_code", ErrorCodes.E10011.getCode());
	return "redirect:/admin/login";
    }

}
