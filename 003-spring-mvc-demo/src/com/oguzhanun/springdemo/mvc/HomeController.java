package com.oguzhanun.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {

	@RequestMapping("/")
	public String showMeThePage() {
		return "main-menu";
	}
}
