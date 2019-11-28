package com.zqz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zqz.entity.Dept;
import com.zqz.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@GetMapping("/dept/findAll")
	public List<Dept> findAll() {
		return deptService.findAll();
	}
	
	/**
    * 增加自己服务描述的接口
    * @return
    */
   @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
   public Object discovery(){
       List<String> list = discoveryClient.getServices();
       System.out.println("总共有多少个微服务"+list.size());

       //查询STUDY-SPRINGCLOUD-DEPT 服务
       List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-dept");

       //打印STUDY-SPRINGCLOUD-DEPT服务信息
       for (ServiceInstance element :instances){
           System.out.println(element.getServiceId());
           System.out.println(element.getHost());
           System.out.println(element.getPort());
           System.out.println(element.getUri());
       }
       return this.discoveryClient;

   }

}
