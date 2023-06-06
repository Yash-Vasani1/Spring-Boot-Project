package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Entity.UserEntity;
import com.Repository.UserRepository;
import com.google.gson.Gson;

//@Component
public class authTokenFilter implements Filter{
	@Autowired
	UserRepository userrepo;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)(req);
		HttpServletResponse response = (HttpServletResponse)(resp);
		String token =  request.getHeader("token");
		String userJsonString = new Gson().toJson(token);
		
		if(token == null || token.trim().length() != 16)
		{
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			out.print(userJsonString);
			response.setStatus(0);
			out.flush();

		}
		else
		{
			UserEntity userExist = userrepo.findByToken(token).orElse(null);
//			= userrepo.findByToken(token).orElse(null);
			
			
			chain.doFilter(req, resp);
		}
	}

}
