package com.example.springbootmybatisgeneratortest.pojo;

public class Result {

	private String message;
	
	private Integer status ;
	
	private Object obj;

	
	public Result(String message, Integer status, Object obj) {
		super();
		this.message = message;
		this.status = status;
		this.obj = obj;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	
}
