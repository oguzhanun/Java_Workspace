package com.oguzhanun.spring.annotations;



public class SadFortuneServices implements FortuneService {

	@Override
	public String getFortune() {
		
		return "I'm sorrry. Today you got nothing...";
	}

}
