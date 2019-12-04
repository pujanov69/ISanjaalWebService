package com.ishani.isanjaalwebservice.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ishani.isanjaalwebservice.dao.UserDAO;
import com.ishani.isanjaalwebservice.dto.UserDTO;
import com.ishani.isanjaalwebservice.dto.VerificationTokenDTO;
import com.ishani.isanjaalwebservice.exception.model.ResourceNotFoundException;
import com.ishani.isanjaalwebservice.services.DbService;
import com.ishani.isanjaalwebservice.services.UserService;
import com.ishani.isanjaalwebservice.services.VerificationTokenService;

import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service
public class UserServiceImpl implements UserService {
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String ROLE_PREFIX = "ROLE_";
    private final DbService dbService;
    
    @Value("${webservice.host-url}")
    private String hostUrl;
    
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    public UserServiceImpl(DbService dbService){
        this.dbService = dbService;
    }

    @Override
    public int addUser(UserDTO userDTO) {
     UserDAO userDAO = dbService.getDao(UserDAO.class);
     System.out.println("The user information is: "+ userDTO);
        return userDAO.addUser(userDTO);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        UserDAO userDAO = dbService.getDao(UserDAO.class);
        UserDTO userDto = null;
        userDto = userDAO.getUserByUsername(username);
        userDto.setAuthorities(AuthorityUtils.createAuthorityList(ROLE_PREFIX + userDto.getAuthority()));
        return userDto;
    }

    @Override
    public UserDTO getUserByEmailAddress(String email) throws ResourceNotFoundException {
        UserDAO userDAO = dbService.getDao(UserDAO.class);
        UserDTO user = userDAO.getUserByEmail(email);
        if(user == null) {
        	throw new ResourceNotFoundException("No user found with email: " + email);
        }
        user.setAuthorities(AuthorityUtils.createAuthorityList(ROLE_PREFIX + user.getAuthority()));
        return user;
    }

    
    @Override
    public boolean checkUserName(String username) {
        UserDAO userDAO = dbService.getDao(UserDAO.class);
        UserDTO user = userDAO.getUserByUsername(username);
        return user != null ? true : false;
    }

    @Override
    public boolean checkEmail(String email) {
        UserDAO userDAO = dbService.getDao(UserDAO.class);
        UserDTO user = userDAO.getUserByEmail(email);
        return user != null ? true : false;
    }

	@Override
	public List<UserDTO> findAll(Integer pageNo, Integer limitSize) {
		UserDAO userDAO = dbService.getDao(UserDAO.class);
		return userDAO.findAll(pageNo, limitSize);
	}

	@Override
	public long getTotalUser() {
		UserDAO userDAO = dbService.getDao(UserDAO.class);
		return userDAO.countTotalNoOfUser();
	}

    @Override
    public UserDTO getUserByEmail(String email) {
        UserDAO userDAO = dbService.getDao(UserDAO.class);
        return userDAO.getUserByEmail(email);
    }

   

    @Override
    public UserDTO getUserByUserId(Integer userId) {
        UserDAO userDAO = dbService.getDao(UserDAO.class);
        UserDTO user = userDAO.getUserByUserId(userId);
        return user;
    }




	@Override
	public Integer updateUser(Integer userId, UserDTO userDTO) {
		UserDAO userDAO = dbService.getDao(UserDAO.class);
		return userDAO.updateUserDetails(userId, userDTO);
	}

}
