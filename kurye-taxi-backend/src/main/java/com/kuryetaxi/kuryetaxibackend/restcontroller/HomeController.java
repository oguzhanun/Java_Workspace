package com.kuryetaxi.kuryetaxibackend.restcontroller;


import java.util.Date;
import java.util.Objects;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuryetaxi.kuryetaxibackend.entity.Restoran;
import com.kuryetaxi.kuryetaxibackend.jwt.CredentialParser;
import com.kuryetaxi.kuryetaxibackend.jwt.JWTGeneratorandDecoder;
import com.kuryetaxi.kuryetaxibackend.service.RestoranService;

import io.jsonwebtoken.Claims;




@RestController
@CrossOrigin("http://localhost:3000")
public class HomeController {
	
	
	@Autowired
	JWTGeneratorandDecoder jwt;
	
	@Autowired
	RestoranService restoranService;
	
	CredentialParser credentialParser;
	
	
	@PostMapping("/login")
	public Object login(@RequestBody Object credentials) {
	
		// KULLANICI ADI VE ŞİFRE BİRBİRİNDEN AYRILARAK GET KOMUTLARININ ERİŞİMİNE SUNULUYOR.
		credentialParser = new CredentialParser(credentials);
		
		String password = credentialParser.getPassword();
		
		System.out.println("password :" + credentialParser.getPassword());
		
		
		// BURADA VERİ TABANINDAN KULLANICI ADI VE ŞİFRENİN GERÇEKLİĞİ KONTROL EDİLECEK...
		Restoran restoran = restoranService.findRestoran(credentialParser.getUsername());
		
		if(!Objects.isNull(restoran)) {
			
			String dbPassword = restoran.getPassword();
			
			System.out.println("db password : " + restoran.getPassword());
			
			
			 if(password.equals(dbPassword)) {
				 
				// TOKEN ÜRETİCİDEN KARŞILIK OLARAK BİR TOKEN ELDE EDİLİYOR. 
				// NORMALDE BUNU YAPMADAN ÖNCE VERİ TABANINDAN KONTROL YAPILARAK KULLANICI ADI
				// VE ŞİFRENİN KONTROL EDİLMESİ GEREKİYOR...
				
				String token = jwt.createJWT(credentialParser.getUsername(), credentialParser.getUsername(),
							credentialParser.getUsername(), 1000); //24l*60*60*1000
					
				return token;
			}
		} 
		return null;
	}


	@PostMapping("/kuryeCagrisi")
	public String kuryeCagir(@RequestBody Object token) {
		
		//String tokenString = (String) token.getString("data");
		
		String s = JSONObject.valueToString(token);
		
		JSONObject json = new JSONObject(s);
		
		String tokenStr = json.getJSONObject("data").getString("token");
		
		Claims claims = jwt.parseJWT(tokenStr);
		String issuer = claims.getIssuer();
		
		Date date = new Date(System.currentTimeMillis());
		
		boolean bool = date.after(claims.getExpiration());
		
		if(bool) {
			return "LÜTFEN TEKRAR SİSTEME GİRİŞ YAPINIZ";
		}
		
		return "sorun yok";
	}



}
