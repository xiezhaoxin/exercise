package cn.xiezhaoxin.common.util;

public class ReturnMessage {
	private String errCode;
	private String errMessage;
	private Object Data;

	public ReturnMessage() {
		super();
	}

	public ReturnMessage(Object data) {
		super();
		errCode = "";
		errMessage = "no error";
		Data = data;
	}
	
	public ReturnMessage(String errCode, Object data) {
		super();
		this.errCode = errCode;
		errMessage = "no error";
		Data = data;
	}

	public ReturnMessage(String errCode, String errMessage) {
		super();
		this.errCode = errCode;
		this.errMessage = errMessage;
		Data = null;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

}
