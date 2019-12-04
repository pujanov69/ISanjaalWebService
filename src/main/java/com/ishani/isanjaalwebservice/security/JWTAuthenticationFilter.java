package com.ishani.isanjaalwebservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ishani.isanjaalwebservice.dto.LoginDTO;
import com.ishani.isanjaalwebservice.dto.Response;
import com.ishani.isanjaalwebservice.dto.UserDTO;

import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		LoginDTO loginDTO = new LoginDTO();
		try {
			loginDTO = new ObjectMapper().readValue(request.getInputStream(), LoginDTO.class);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return authenticationManager.authenticate(
				// user userName parameter if you want to validate against username
				new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword(),
						new ArrayList<>()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		UserDTO user = (UserDTO) auth.getPrincipal();
		
		String token = Jwts.builder().setSubject(((UserDetails) auth.getPrincipal()).getUsername())
				.claim("authority", user.getAuthority())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes()).compact();
		response.setContentType("application/json");
		UserDTO userDTO = (UserDTO) auth.getPrincipal();
		userDTO.setToken(token);
		response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(
				Response.ok(userDTO, HttpStatus.OK.value(), "You have been successfully loggedin to the system.")));
		response.addHeader("Access-Control-Expose_Headers", "Authorization");
		response.addHeader("Authorization", "Bearer " + token);

	}
}
