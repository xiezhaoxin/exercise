package cn.xiezhaoxin.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OperatorException extends RuntimeException {
	private static final long serialVersionUID = 6898132259600568537L;
	private String code;
	private String message;
	
	public OperatorException() {}

	public OperatorException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OperatorException [code=" + code + ", message=" + message + "]";
	}

	@Override
	@JsonIgnore
	public synchronized Throwable getCause() {
		return super.getCause();
	}

	@Override
	@JsonIgnore
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

	@Override
	@JsonIgnore
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}
	
	

}
