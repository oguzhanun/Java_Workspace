package com.oguzhanun.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processFormTwo(HttpServletRequest request, Model model) {
		
		String isim = (String) request.getParameter("studentName");
		
		isim = isim.toUpperCase();
		
		String mesaj = "Yo! " + isim;
		
		model.addAttribute("message", mesaj);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormTwo(@RequestParam("studentName") String isim, Model model) {
		
		isim = isim.toUpperCase();
		
		String mesaj = "Hello My Friend!..." + isim;
		
		model.addAttribute("message", mesaj);
		
		return "helloworld";
	}
}
