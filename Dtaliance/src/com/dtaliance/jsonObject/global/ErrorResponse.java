package com.dtaliance.jsonObject.global;

public class ErrorResponse {
	private String request;
	private String result;
	private ErrorDetail detail;
	
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ErrorDetail getDetail() {
		return detail;
	}

	public void setDetail(ErrorDetail detail) {
		this.detail = detail;
	}
	
}
