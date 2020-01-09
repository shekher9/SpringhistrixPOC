package com.ri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class SpringBootHystrixPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHystrixPocApplication.class, args);
	}

}
