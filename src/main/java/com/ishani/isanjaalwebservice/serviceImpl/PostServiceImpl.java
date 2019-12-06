/**
 * 
 */
package com.ishani.isanjaalwebservice.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ishani.isanjaalwebservice.dao.PostDAO;
import com.ishani.isanjaalwebservice.dto.PostDTO;
import com.ishani.isanjaalwebservice.services.DbService;
import com.ishani.isanjaalwebservice.services.PostService;

/**
 * @author Pujan K.C. <pujanov69@gmail.com>
 *
 * Created on Dec 4, 2019
 */
@Service
public class PostServiceImpl implements PostService {

	private DbService dbService;
	
	public PostServiceImpl(DbService dbService) {
		this.dbService = dbService;
	}
	
	private Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);
	
	@Override
	public int addPost(PostDTO postDTO) {
		PostDAO postDAO = dbService.getDao(PostDAO.class);
		return postDAO.addPost(postDTO);
		
	}

	@Override
	public List<PostDTO> getAllPosts() {
		PostDAO postDAO = dbService.getDao(PostDAO.class);
		return postDAO.getallPosts();
	}

}
