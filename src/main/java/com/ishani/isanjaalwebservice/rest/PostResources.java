/**
 * 
 */
package com.ishani.isanjaalwebservice.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ishani.isanjaalwebservice.dto.PostDTO;
import com.ishani.isanjaalwebservice.dto.Response;
import com.ishani.isanjaalwebservice.services.PostService;

/**
 * @author Pujan K.C. <pujanov69@gmail.com>
 *
 * Created on Dec 4, 2019
 */
@RestController
@RequestMapping("api/v1/post")
public class PostResources {
	
	private final Logger logger = LoggerFactory.getLogger(PostResources.class);
	
	private PostService postService;
	
	@Autowired
	public PostResources(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping
	public Response<?> addPost(@RequestBody PostDTO postDTO){
		Integer result = null;
		
		result = postService.addPost(postDTO);
		
		return Response.ok(result, HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	@GetMapping("/all")
	public Response<?> getAllPosts(){
		List<PostDTO> allPosts = postService.getAllPosts();
		return Response.ok(allPosts, HttpStatus.OK.value(), HttpStatus.OK.name());
	}
}
