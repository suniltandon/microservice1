package com.tcs.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("microservice2")
public interface TestFeignClient {
	
    @RequestMapping(method = RequestMethod.GET, value = "/testping")
    String testPing();
}
