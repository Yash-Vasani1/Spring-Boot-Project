//package com.config;
//
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.Entity.UserEntity;
//import com.Repository.UserRepository;
//
//@Configuration
//public class MyUserDetailsService implements UserDetailsService {
//	@Autowired
//	UserRepository userrepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		UserEntity user = userrepo.findByEmail(username);
//		if(user==null) {
//			throw new UsernameNotFoundException("Email not exists !!");
//		}
//		MyUserDetails userdetails = new MyUserDetails(user); 
//	
//		return null;
//	}
//
//}
