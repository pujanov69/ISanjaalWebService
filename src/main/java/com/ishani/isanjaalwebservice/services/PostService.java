/**
 * 
 */
package com.ishani.isanjaalwebservice.services;

import java.util.List;

import com.ishani.isanjaalwebservice.dto.PostDTO;

/**
 * @author Pujan K.C. <pujanov69@gmail.com>
 *
 * Created on Dec 4, 2019
 */
public interface PostService {

	public int addPost(PostDTO postDTO);
	public List<PostDTO> getAllPosts();
}
