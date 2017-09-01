package com.project.sample.admin.params;

import java.io.Serializable;

public class ResJsonHeader implements Serializable{

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
	return "ResJsonHeader [code=" + code + "]";
    }

}
