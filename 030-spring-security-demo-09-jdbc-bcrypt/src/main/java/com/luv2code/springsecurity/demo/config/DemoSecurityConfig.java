package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private DataSource comboPooledDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
									 .withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
									 .withUser(users.username("adam").password("test123").roles("EMPLOYEE", "ADMIN"));
		*/
		
		auth.jdbcAuthentication().dataSource(comboPooledDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
					//.anyRequest().authenticated()
					.antMatchers("/").hasRole("EMPLOYEE")
					.antMatchers("/leaders/**").hasRole("MANAGER")
					.antMatchers("/systems/**").hasRole("ADMIN")
					.and().formLogin()
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll().and().logout().permitAll()
					.and().exceptionHandling().accessDeniedPage("/accessDenied-page");
	}
	
	
	

}
