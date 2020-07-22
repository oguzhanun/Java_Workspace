package com.example.springbootwithreact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringbootwithreactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithreactApplication.class, args);
	}
	
	@RestController
	@CrossOrigin("http://localhost:3000")
	class HomeController
	{
		@RequestMapping("/isimler")
		public List<String> homePage() 
		{
			List<String> list = new ArrayList<>();
			list.add("oğuzhan");
			list.add("melahat");
			list.add("metehan");
			list.add("meryem");
			list.add("zeynep");
			
			return list;
			
		}
	}

}
