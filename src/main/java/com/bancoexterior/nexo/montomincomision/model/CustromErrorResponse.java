package com.bancoexterior.nexo.montomincomision.model;

public class CustromErrorResponse {
	
	
	private String timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustromErrorResponse [timestamp=");
		builder.append(timestamp);
		builder.append(", status=");
		builder.append(status);
		builder.append(", error=");
		builder.append(error);
		builder.append(", message=");
		builder.append(message);
		builder.append(", path=");
		builder.append(path);
		builder.append("]");
		return builder.toString();
	}
	
	

	

}
