//package com.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//public class configration extends WebSecurityConfigurerAdapter{
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().withUser("ram").password("ram").roles("USER");
//		auth.inMemoryAuthentication().withUser("ram1").password("ram1").roles("ADMIN");
////		auth.authenticationProvider(authenticationManager());
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
////		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//		http.csrf().disable().authorizeRequests().antMatchers("/public/**").permitAll().anyRequest().authenticated().and().formLogin();
//	}
//	
//}
