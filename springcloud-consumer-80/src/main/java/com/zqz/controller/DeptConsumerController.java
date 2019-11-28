package com.zqz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zqz.entity.Dept;

@RestController
public class DeptConsumerController {
	
	private static final String REST_URL_PREFIX = "http://localhost:8081";
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/consumer/dept/list")
	public List<Dept> findAll() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findAll", List.class);
	}
	
	@RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/discovery",
                Object.class);
    }
}
