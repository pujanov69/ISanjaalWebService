/**
 * 
 */
package com.ishani.isanjaalwebservice.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import com.ishani.isanjaalwebservice.dto.PostDTO;

/**
 * @author Pujan K.C. <pujanov69@gmail.com>
 *
 * Created on Dec 4, 2019
 */
public interface PostDAO {

	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO posts(post_by, post) VALUES(:postBy, :post)")
	public int addPost(@BindBean PostDTO postDTO);
	
	@SqlQuery("SELECT p.*, u.username as poster_name FROM posts p INNER JOIN user u ON p.post_by = u.user_id ORDER BY(p.created_at) DESC")
	public List<PostDTO> getallPosts();
}
