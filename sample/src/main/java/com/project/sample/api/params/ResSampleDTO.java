package com.project.sample.api.params;

import java.io.Serializable;

public class ResSampleDTO extends ResBaseDTO implements Serializable {

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
	return super.toString()+"ReqSampleDTO []";
    }

    @Override
    public String toParameters() {
	// TODO Auto-generated method stub
	StringBuffer sb = new StringBuffer();
	//
	return sb.toString();
    }

}
