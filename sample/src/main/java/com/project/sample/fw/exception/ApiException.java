package com.project.sample.fw.exception;

import com.project.sample.api.constant.ErrorCodes;

public class ApiException extends Exception{

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    protected String errorCode = null;
    protected String errorMessage = null;
    protected boolean isMessage = false;
    protected Exception wrappedException = null;

    public ApiException() {
	super(ErrorCodes.E10001.getMessage() + " - " + ErrorCodes.E10001.getCode());
	this.errorCode = ErrorCodes.E10001.getCode();
	this.errorMessage  = ErrorCodes.E10001.getMessage();
    }

    public ApiException(Throwable cause) {
	super(cause);
    }

    public ApiException(String errorCode, String errorMessage) {
   	super(errorCode + " - " + errorMessage);
   	this.errorCode = errorCode;
   	this.errorMessage  = errorMessage;
    }

    public ApiException(String errorCode, String errorMessage, Throwable cause) {
	super(cause);
	this.errorCode = ErrorCodes.E10001.getCode();
	this.errorMessage  = ErrorCodes.E10001.getMessage();
	this.wrappedException = this;
    }

    public ApiException(String errorCode) {
	this(errorCode, ErrorCodes.getMessage(errorCode));
    }

    public ApiException(String errorCode, Throwable cause) {
	this(errorCode, null, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isMessage() {
        return isMessage;
    }

    public void setMessage(boolean isMessage) {
        this.isMessage = isMessage;
    }

    public Exception getWrappedException() {
        return wrappedException;
    }

    public void setWrappedException(Exception wrappedException) {
        this.wrappedException = wrappedException;
    }

    @Override
    public String toString() {
	return "ApiException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", isMessage=" + isMessage
		+ ", wrappedException=" + wrappedException + "]";
    }

}