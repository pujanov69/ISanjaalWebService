/**
 * 
 */
package com.ishani.isanjaalwebservice.dto;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ishani.isanjaalwebservice.utilities.UserDtoDeserializer;

/**
 * @author Pujan K.C. <pujanov69@gmail.com>
 *
 * Created on Dec 3, 2019
 */
@JsonDeserialize(using = UserDtoDeserializer.class)
public class UserDTO implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int userId;
    private String username;
    private String password;
    private String fName;
    private String mName;
    private String lName;
    private String email;
    private long phone;
    private String authority;
    private int roleId;
    private String token;
    private String address; 
    private boolean enabled;
    
    private Collection<? extends GrantedAuthority> authorities;
    
    
    
    
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", username=" + username + ", password=" + password + ", fName=" + fName
				+ ", mName=" + mName + ", lName=" + lName + ", email=" + email + ", phone=" + phone + ", authority="
				+ authority + ", roleId=" + roleId + ", token=" + token + ", address=" + address + "]";
	}
	
	public UserDTO() {}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
    
    

}
