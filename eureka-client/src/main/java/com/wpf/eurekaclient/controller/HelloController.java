package com.wpf.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${server.port}")
	String port;

	@RequestMapping("/hello")
	public String home(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {
		return "Hello " + name + " ,your port is:" + port;
	}
	
	@RequestMapping("/")
  public String index(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {
    return "Hello " + name + " ,your port is:" + port;
  }
}
