package com.shop.common;

public class OsResult extends BaseResult {

	private static final long serialVersionUID = 1L;

	public OsResult(ReturnCode returnCode) {
        super(returnCode.getCode(), returnCode.getMessage());
	}
	
	public OsResult(ReturnCode returnCode, Object data) {
		super(returnCode.getCode(), returnCode.getMessage(), data);
	}
	
	public OsResult(Integer code, String message) {
		super(code, message);
	}
}
