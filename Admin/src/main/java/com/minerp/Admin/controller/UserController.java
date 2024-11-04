package com.minerp.Admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minerp.Admin.entity.User;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.service.UserService;


@RestController
@RequestMapping("/admin")
public class UserController {

	Pageable pageable= PageRequest.of(0, 10);

	@Autowired
	private UserService userService;
	
	@PostMapping("/saveuser")
	public ResponseEntity<ServiceResponse<User>> saveUser(@RequestBody User user) {
        ServiceResponse<User> response = userService.saveUser(user);
        return new ResponseEntity<>(response, response.getStatusCode());
    }
	
	@PostMapping("/validatelogin")
	 public ResponseEntity<ServiceResponse<String>> validateLogin(@RequestParam String username, @RequestParam String password) {
        ServiceResponse<String> response = userService.validateLogin(username, password);
        return new ResponseEntity<>(response, response.getStatusCode());
    }
	
	@GetMapping("/getusers/{status}")
	public ResponseEntity<ServiceResponse<List<User>>> getActiveOrInactiveUsers(@PathVariable("status") Boolean status,
            @RequestHeader("Authorization") String token,
            Pageable pageable) {
				ServiceResponse<List<User>> response = userService.getActiveOrInactiveUsers(status, pageable);
				return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<ServiceResponse<User>> getUserById(@PathVariable("id") String username) {
        ServiceResponse<User> response = userService.getUserById(username);
        return new ResponseEntity<>(response, response.getStatusCode());
    }
	
}
