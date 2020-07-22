package com.oguzhanun.springdemo.mvc;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private LinkedHashMap<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String goToForm(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student", student);
		model.addAttribute("countryOptions", countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String goToProcessForm(@ModelAttribute("student") Student student) {
		
		System.out.println(student.getFirstName() + "  " + student.getLastName());
		
		return "student-confirmation";
	}
}
