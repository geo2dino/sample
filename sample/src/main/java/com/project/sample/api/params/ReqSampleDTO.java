package com.project.sample.api.params;

import java.io.Serializable;

public class ReqSampleDTO extends ReqBaseDTO implements Serializable {

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
	return super.toString()+"ReqSampleDTO []";
    }

    @Override
    public Object parseParameter() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isValidation() {
	// TODO Auto-generated method stub
	return false;
    }

}
