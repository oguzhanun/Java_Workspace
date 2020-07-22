package com.kuryetaxi.kuryetaxibackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="restoran")
public class Restoran {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="token")
	private String token;
	

	
	public Restoran() {
		// TODO Auto-generated constructor stub
	}

	public Restoran(Integer id, String username, String password, String token) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.token = token;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Restoran [id=" + id + ", username=" + username + ", password=" + password + ", token=" + token + "]";
	}
	
	
	
}
