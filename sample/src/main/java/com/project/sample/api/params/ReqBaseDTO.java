package com.project.sample.api.params;

public abstract class ReqBaseDTO {

    public abstract Object parseParameter();

    public abstract boolean isValidation();

    private String no;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
	return "ReqBaseDTO [no=" + no + "]";
    }

}
