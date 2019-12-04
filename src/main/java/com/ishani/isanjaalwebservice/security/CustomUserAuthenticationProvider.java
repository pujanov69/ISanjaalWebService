package com.ishani.isanjaalwebservice.security;

import com.ishani.isanjaalwebservice.dto.UserDTO;
import com.ishani.isanjaalwebservice.serviceImpl.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		UserDTO userLoadedFromDatabase = (UserDTO) customUserDetailsService.loadUserByEmailAddress(token.getName());

		// user following code if you want to validate user with username
		// (UserDTO) customUserDetailsService.loadUserByUsername(token.getName());

		if (userLoadedFromDatabase != null
				&& (passwordEncoder.matches(token.getCredentials().toString(), userLoadedFromDatabase.getPassword()))) {
			userLoadedFromDatabase.setPassword(" ");
			authentication = new UsernamePasswordAuthenticationToken(userLoadedFromDatabase,
					userLoadedFromDatabase.getPassword(), new ArrayList<>());

			SecurityContextHolder.getContext().setAuthentication(authentication);
			return authentication;
		}

		throw new BadCredentialsException("Bad Credentials.");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}
}
