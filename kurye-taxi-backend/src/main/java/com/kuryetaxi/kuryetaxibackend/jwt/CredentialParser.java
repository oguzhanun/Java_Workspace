package com.kuryetaxi.kuryetaxibackend.jwt;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;




@Component
public class CredentialParser {
	
	
	private String username;
	private String password;
	

	public CredentialParser() {
		
	}

	public CredentialParser(Object credentials) {
		
		String[] s = credentials.toString().split(Pattern.quote(","));
		
		this.username = s[0].substring(10);
		System.out.println(this.username);
		
		this.password = s[1].substring(10, (s[1].length()-1) );
		System.out.println(this.password);
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CredentialParser [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
