package com.kishanseva.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishanseva.model.User;
import com.kishanseva.services.UserService;

@RestController
@RequestMapping(value = "/user-details")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/create-user")
	public ResponseEntity<?> createRecord(@RequestBody String request) {
		try {
			User user = userService.saveUserRecords(request);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	@PostMapping(value = "/get-user")
	public ResponseEntity<?> getRecordList(@RequestBody String request) {
		try {
			List<User> list = userService.getRecordList(request);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}

	}

}
