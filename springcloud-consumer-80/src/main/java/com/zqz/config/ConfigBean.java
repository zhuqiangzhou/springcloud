package com.zqz.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.zqz.entity.Dept;

@Configuration
public class ConfigBean {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
