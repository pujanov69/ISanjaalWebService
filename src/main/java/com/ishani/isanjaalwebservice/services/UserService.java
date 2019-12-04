package com.ishani.isanjaalwebservice.services;



import java.util.List;

import com.ishani.isanjaalwebservice.dto.UserDTO;


public interface UserService {
    int addUser (UserDTO userDTO);
    UserDTO getUserByUsername (String username);
    UserDTO getUserByEmailAddress(String email);
    boolean checkUserName(String username);
	boolean checkEmail(String email);
	List<UserDTO> findAll(Integer pageNo, Integer limitSize);
	long getTotalUser();
	UserDTO getUserByEmail(String email);
	UserDTO getUserByUserId(Integer userId);
	Integer updateUser(Integer userId, UserDTO userDTO);
}
