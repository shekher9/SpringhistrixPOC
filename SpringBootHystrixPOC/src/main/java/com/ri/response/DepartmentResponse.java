package com.ri.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DepartmentResponse {
	
	@JsonIgnore
	private int deptid;
	private HttpStatus status;
	private String message;


}
