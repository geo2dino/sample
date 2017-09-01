package com.project.sample.api.constant;

public enum ErrorCodes {

    //그룹(1)+일반(4)
    E00000("00000", "unknown", "unknown"),
    E10000("10000", "success", "성공"),
    E10001("10001", "", "내부 서버 오류"),
    E10002("10002", "", "요청 파라메터 오류"),

    E99999("99999","","");

    private final String code;
    private final String message;
    private final String desc;

    private ErrorCodes(String code, String message, String desc){
	this.code = code;
	this.message = message;
	this.desc = desc;
    }

    public static String getMessage(final String code){
	String result = "";
	ErrorCodes[] errorCodes = ErrorCodes.values();
	for(ErrorCodes ec : errorCodes){
		if(ec.getCode().equals(code)){
			result = ec.getMessage();
			break;
		}
	}
	return result;
    }

    public static String getDesc(final String code){
	String result = "";
	ErrorCodes[] errorCodes = ErrorCodes.values();
	for(ErrorCodes ec : errorCodes){
		if(ec.getCode().equals(code)){
			result = ec.getDesc();
			break;
		}
	}
	return result;
    }

    public String getCode(){
	return code;
    }

    public String getMessage(){
    	return message;
    }

    public String getDesc(){
    	return desc;
    }
}
