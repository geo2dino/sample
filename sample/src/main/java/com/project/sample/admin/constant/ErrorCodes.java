package com.project.sample.admin.constant;

public enum ErrorCodes {

    E00000("00000", "unknown", "unknown"),
    E10000("10000", "성공", "성공"),
    E10001("10001", "처리중 오류가 발생하였습니다.", "내부 서버 오류"),
    E10002("10002", "요청 파라메터에 오류가 발생하였습니다.", "요청 파라메터 오류"),
    E10003("10003", "요청 파라메터에 필수항목이 누락되었습니다.", "필수 파라메터 오류"),
    E10004("10004", "요청 파라메터가 현재 존재합니다.", "중복 파라메터 오류"),

    E10010("10010", "로그인 성공", "로그인 성공"),
    E10011("10011", "로그아웃 성공", "로그아웃 성공"),
    E10012("10012", "아이디와 비밀번호를 정확히 입력해주세요!!", "로그인 실패"),
    E10013("10013", "로그인 타임아웃", "세션 오류"),
    E10015("10015", "다른사람이 로그인을 하였습니다.", "중복 로그인"),

    E10100("10100", "요청정보가 없습니다.", "요청정보 오류"),

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
