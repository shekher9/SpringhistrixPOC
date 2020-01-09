package com.ri.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ri.response.DepartmentResponse;


@Service(value = "empservice")
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Override
	public String departmentExist(int id) {
		URI uri;
		String msg;
		try {
			uri = new URI("http://localhost:4020/dept/getDepartment/"+id);
			RestTemplate templet=new RestTemplate();
			ResponseEntity<DepartmentResponse> response=templet.getForEntity(uri, DepartmentResponse.class);
			int statuscode=response.getStatusCodeValue();
			if(statuscode== 200) {
				return "Department is exist";			
			}
			else
				return "Department is not exist";
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * RestTemplate templet=new RestTemplate(); ResponseEntity<DepartmentResponse>
		 * response=templet.getForEntity(uri, DepartmentResponse.class); int
		 * statuscode=response.getStatusCodeValue(); if(statuscode== 200) { return
		 * "Department is exist"; } else return "Department is not exist";
		 */
		return null;
	}
}
