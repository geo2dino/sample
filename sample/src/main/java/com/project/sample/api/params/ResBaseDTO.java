package com.project.sample.api.params;

public abstract class ResBaseDTO {

    public abstract String toParameters();

    private String errorCd;

    public String getErrorCd() {
        return errorCd;
    }

    public void setErrorCd(String errorCd) {
        this.errorCd = errorCd;
    }

    @Override
    public String toString() {
	return "ResBaseDTO [errorCd=" + errorCd + "]";
    }

}
