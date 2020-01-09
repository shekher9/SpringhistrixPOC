package com.ri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class HystrixController {
	
	@GetMapping("/get")
	@HystrixCommand(fallbackMethod = "fallback_method",commandProperties = {
			@HystrixProperty(name="executation.isolation.thread.timeoutInMillisecond",value = "1000")
	})
	public String getMessage() {
		
		return null;
	}
	
	public String fallback_method() {
		return "Request failed,takes long time to responce";
	}

}
