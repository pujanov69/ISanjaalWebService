/**
 * 
 */
package com.ishani.isanjaalwebservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ishani.isanjaalwebservice.dto.Response;
import com.ishani.isanjaalwebservice.dto.UserDTO;
import com.ishani.isanjaalwebservice.services.PostService;
import com.ishani.isanjaalwebservice.services.UserService;

/**
 * @author Pujan K.C. <pujanov69@gmail.com>
 *
 * Created on Dec 5, 2019
 */
@RestController
@RequestMapping("api/v1/user")
public class UserResources {
	
	private UserService userService;
	
	@Autowired
	public UserResources(UserService userService) {
		this.userService = userService;
	}
	

	@GetMapping("/{id}")
	public Response<?> getUserById(@PathVariable("id") Integer userId){
		UserDTO user = userService.getUserByUserId(userId);
		return Response.ok(user, HttpStatus.OK.value(), HttpStatus.OK.name());
	}
	

}
