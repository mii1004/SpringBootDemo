package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StringService;

@RestController
public class DemoSpringAppController {

	@Autowired
	StringService stringService;

	@RequestMapping("/")
	public String demoSpringApi () {
		return "HelloWorld!";
	}

	@RequestMapping("/StringCompareTo")
	public int stringCompareTo
	(@RequestParam(name="param1") String param1, @RequestParam(name="param2") String param2) {
		return stringService.stringCompareTo(param1, param2);
	}
}
