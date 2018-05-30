package com.tcs.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Value("${spring.application.name}")
	private String name;
	
	@Autowired
	TestFeignClient testFeignClient;

	@RequestMapping(value = "/testping", method = RequestMethod.GET)
	public String testPing() {
		logger.info("Original microservice " + name);
		logger.info("Feign Client microservice " + testFeignClient.testPing());
		return "Inside " + name;
	}
}
