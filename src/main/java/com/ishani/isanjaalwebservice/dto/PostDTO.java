/**
 * 
 */
package com.ishani.isanjaalwebservice.dto;

/**
 * @author Pujan K.C. <pujanov69@gmail.com>
 *
 * Created on Dec 4, 2019
 */
public class PostDTO {
	
	private int postId;
	private int postBy;
	private String posterName;
	private String post;
	private String createdAt;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getPostBy() {
		return postBy;
	}
	public void setPostBy(int postBy) {
		this.postBy = postBy;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	@Override
	public String toString() {
		return "PostDTO [postId=" + postId + ", postBy=" + postBy + ", post=" + post + ", createdAt=" + createdAt + "]";
	}
	public String getPosterName() {
		return posterName;
	}
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}
	
	
	
	

}
