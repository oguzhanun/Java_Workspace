package com.oguzhanun.spring.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.oguzhanun.spring.annotations")
public class SportConfig {
	
	public void bosMethod() {
		System.out.println("SportConfig sınıfına hoş geldiniz...");
	}
}
