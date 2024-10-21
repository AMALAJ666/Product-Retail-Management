package com.customer.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse {
	private String message;
	private Integer code;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public ApiResponse(String message, Integer code) {
		super();
		this.message = message;
		this.code = code;
	}
	public ApiResponse() {
		super();
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", code=" + code + "]";
	}
	
	
}
