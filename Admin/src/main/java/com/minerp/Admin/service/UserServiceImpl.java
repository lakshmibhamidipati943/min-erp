package com.minerp.Admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minerp.Admin.entity.User;
import com.minerp.Admin.exception.InternalServerErrorException;
import com.minerp.Admin.exception.UnauthorizedException;
import com.minerp.Admin.repository.UserRepository;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.security.JwtUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ServiceResponse<User> saveUser(User user) {
		// TODO Auto-generated method stub
		if(userRepository.existsByUsername(user.getUsername())) {
			throw new IllegalArgumentException("Username already exists");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("admin");
		user.setStatus(true);
		
		try {
			User savedUser=userRepository.save(user);
			return new ServiceResponse<User>(
					HttpStatus.CREATED, "User saved successfully",
					List.of(savedUser),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to create user.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the user.");
		}
	}

	@Override
	public ServiceResponse<String> validateLogin(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            String token = jwtUtil.generateToken(username);
            return new ServiceResponse<>(
                    HttpStatus.OK,
                    "Login successful",
                    List.of(token),
                    1L
            );
        }
        throw new RuntimeException("Invalid Credentials");
    }

	@Override
	public ServiceResponse<List<User>> getActiveOrInactiveUsers(Boolean status, Pageable pageable) {
	    List<User> users = userRepository.getActiveOrInactiveUsers(status, pageable);
	    
	    ServiceResponse<List<User>> response = new ServiceResponse(
	            HttpStatus.OK,
	            "Users returned successfully",
	            users,
	            (long) users.size() // Ensure this is a Long type
	    );
	    
	   return response;
	}

	@Override
	public ServiceResponse<User> getUserById(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return new ServiceResponse<>(
                    HttpStatus.OK,
                    "User retrieved successfully",
                    List.of(user),
                    1L
            );
        }
        throw new RuntimeException("User not found");
    }

}
