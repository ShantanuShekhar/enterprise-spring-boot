package com.kishanseva.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishanseva.model.User;
import com.kishanseva.services.UserService;
import com.kishanseva.util.Response;

@RestController
//@RequestMapping(value = "/user-details")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/create-user")
	public ResponseEntity<?> createRecord(@RequestBody String request) {
		try {
			Response response = new Response();
			JSONObject obj = new JSONObject(request);
			String userName = obj.getString("k1");
			User user = userService.findByUserName(userName);
			if (user != null) {
				return new ResponseEntity<>(userName + " all ready exist", HttpStatus.OK);
			}
			response = userService.saveUserRecords(request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping(value = "/get-user")
	public ResponseEntity<?> getRecordList(@RequestBody String request) {
		try {
			List<User> list = userService.getRecordList(request);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping(value = "/test-user")
	public ResponseEntity<?> testUser(@RequestBody String request) {
		try {
			JSONObject obj = new JSONObject(request);
			int number = obj.getInt("k1");
//			List<User> list = userService.getRecordList(request);
			return new ResponseEntity<>(number, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping(value = "/update-user")
	public ResponseEntity<?> updateRecord(@RequestBody String request) {
		try {
			User user = userService.updateUserRecords(request);
			logger.info("usert is " + user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping(value = "/delete-user")
	public ResponseEntity<?> deleteRecord(@RequestBody String request) {
		try {
			Response response = new Response();
			response = userService.deleteUserRecord(request);
			logger.info("usert is " + response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping(value = "/access")
	public ResponseEntity<?> deleteRecord() {
		logger.info("Authenticated ");
		return new ResponseEntity<>("Authenticated", HttpStatus.OK);
	}

}
