package com.project.sample.admin.params;

import java.io.Serializable;

import com.project.sample.admin.constant.ErrorCodes;

public class ResJson implements Serializable{

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    private ResJsonHeader header = new ResJsonHeader();

    private Object body = null;

    public ResJson() {
	this.header.setCode(ErrorCodes.E10000.getCode());
    }

    public ResJson(String code, Object body) {
	this.header.setCode(code);
	this.body = body;
    }

    public ResJsonHeader getHeader() {
        return header;
    }

    public void setHeader(ResJsonHeader header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
	return "ResJson [header=" + header + ", body=" + body + ", getClass()=" + getClass() + ", hashCode()="
		+ hashCode() + ", toString()=" + super.toString() + "]";
    }

}
