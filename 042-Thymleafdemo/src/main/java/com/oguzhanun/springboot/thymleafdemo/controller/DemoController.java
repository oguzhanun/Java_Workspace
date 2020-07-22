package com.oguzhanun.springboot.thymleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {

	@RequestMapping("/hello")
	public String helloWorld(Model model) {
		model.addAttribute("theDate", new java.util.Date());
		return "helloworld";
	}
}
