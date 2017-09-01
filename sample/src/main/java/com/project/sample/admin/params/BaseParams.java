package com.project.sample.admin.params;

import java.io.Serializable;

public class BaseParams implements Serializable{

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    private String error_code;

//    private String method;
//    private String mode;
//    private String type;
    /*
     * 페이지
     */
//    private String page;
//    private String page_size;
    /*
     * 검색
     */
//    private String s_key;
//    private String s_word;
//    private String s_sort;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
	return "BaseParams [error_code=" + error_code + "]";
    }

}
