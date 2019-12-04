package com.ishani.isanjaalwebservice.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ishani.isanjaalwebservice.dto.Response;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		objectMapper.writeValue(response.getWriter(), Response.ok(new ArrayList<>(), HttpStatus.FORBIDDEN.value(), "Access Denied!"));
		
	}

}
