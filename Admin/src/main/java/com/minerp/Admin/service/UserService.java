package com.minerp.Admin.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.minerp.Admin.entity.User;
import com.minerp.Admin.response.ServiceResponse;

public interface UserService {

	ServiceResponse<User> saveUser(User user);

	ServiceResponse<String> validateLogin(String username, String password);

	ServiceResponse<List<User>> getActiveOrInactiveUsers(Boolean status, Pageable pageable);

	ServiceResponse<User> getUserById(String username);

}
