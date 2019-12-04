package com.ishani.isanjaalwebservice.serviceImpl;

import com.ishani.isanjaalwebservice.dto.UserDTO;
import com.ishani.isanjaalwebservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by fan.jin on 2016-10-31.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService usersService;

    @Autowired
    public CustomUserDetailsService(UserService usersService) {
        this.usersService = usersService;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        UserDTO userDTO =  usersService.getUserByUsername(username);
        if (userDTO == null) {
            throw new UsernameNotFoundException(String.format("No userDTO found with username '%s'.", username));
        } else {
            return userDTO;
        }
    }

    public UserDetails loadUserByEmailAddress(String email){
        UserDTO userDTO = usersService.getUserByEmailAddress(email);
        if(userDTO == null) {
            throw new UsernameNotFoundException(String.format("No user with email address '%s' is found", email));
        } else {
            return userDTO;
        }
    }
}
