package com.gateranker.dto;

import java.io.Serializable;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String responseStatus;
	private String responseMessage;
	private Object responseContent;

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Object getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(Object responseContent) {
		this.responseContent = responseContent;
	}

	@Override
	public String toString() {
		return "Response [responseStatus=" + responseStatus + ", responseMessage=" + responseMessage
				+ ", responseContent=" + responseContent + "]";
	}

}
