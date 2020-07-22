package com.oguzhanun.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	
	private String favoriteLanguage;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	private String[] operatingSystem;
	
	
	//LinkedHashSet sınıfı da kullanılabilirdi. İki formda aynı ülkeler farklı isimler ile çağrılmak isteniyorsa
	//LinkedHashSet kullanılabilir. Bu durumda key value çiftinden value değeri ilk jsp sayfasında key kısmı controller ün
	//çağırdığı jsp sayfasında gösteriliyor...
	//private LinkedList<String> countryOptions; 
	/*public LinkedList<String> getCountryOptions() {
		return countryOptions;
	}
	 */
	
	public Student() {
		
		// populate favorite language options
        favoriteLanguageOptions = new LinkedHashMap<>();

        // parameter order: value, display label
        //
        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C#", "C#");
        favoriteLanguageOptions.put("PHP", "PHP");
        favoriteLanguageOptions.put("Ruby", "Ruby");   
		/*countryOptions = new LinkedList<String>();
		countryOptions.add( "Turkey");
		countryOptions.add( "Brasil");
		countryOptions.add( "United States");
		countryOptions.add( "Germany");
		*/
	}
	
	
	
	public String[] getOperatingSystem() {
		return operatingSystem;
	}



	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}



	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
	    return favoriteLanguageOptions;
	}
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
