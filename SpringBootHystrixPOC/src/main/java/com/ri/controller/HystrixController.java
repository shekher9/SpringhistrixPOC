package com.ri.controller;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ri.service.EmployeeService;

@RestController
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class HystrixController {
	@Autowired(required = true)
	private EmployeeService empservice;
	
	@GetMapping("/get/{id}")
	@HystrixCommand(fallbackMethod = "fallback_method",commandProperties = {
			@HystrixProperty(name="executation.isolation.thread.timeoutInMillisecond",value = "1000")
	})
	public String getMessage(@PathParam(value = "id") int id) {
		String msg=null;
		if(id==15) {
			try {
				Thread.sleep(3000);
				msg=empservice.departmentExist(id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			msg=empservice.departmentExist(id);
		}
		
		return msg;
	}
	
	public String fallback_method() {
		return "Request failed,takes long time to responce";
	}

}
