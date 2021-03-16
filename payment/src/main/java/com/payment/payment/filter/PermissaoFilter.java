package com.payment.payment.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.payment.payment.util.JwtUtil;

import io.jsonwebtoken.Claims;

public class PermissaoFilter implements Filter {
	
	List<String> claims;
	PermissaoFilter(List<String> claims) {
		this.claims = claims;
	}
	
	@Autowired
	JwtUtil jwtUtils;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String jwt = httpRequest.getHeader("Authorization");
		
		String token = jwt.substring(7, jwt.length());
		Claims claim = jwtUtils.extractAllClaims(token);
		
		return;
	}

}
