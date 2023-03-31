package com.kishanseva.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

import org.hibernate.stat.internal.CategorizedStatistics;
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

import com.kishanseva.dto.CategoryDto;
import com.kishanseva.dto.UserDto;
import com.kishanseva.model.Category;
import com.kishanseva.model.User;
import com.kishanseva.services.IOrderDetailsService;
import com.kishanseva.services.UserService;
import com.kishanseva.util.Constant;
import com.kishanseva.util.Response;
import com.kishanseva.util.ResponseCode;

@RestController
@RequestMapping(value = "/category")
public class OrderDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private IOrderDetailsService orderDetailsService;

	// first create and sell records in db
	@PostMapping("/sell-products")
	public ResponseEntity<?> sellProducts(@RequestBody CategoryDto reqbody) {
		logger.info("Inside Sell product API");
		
//		logger.info("inside login api ");
//		response = .getByUserNameAndPassword(reqbody);
//		return new ResponseEntity<>(response, HttpStatus.OK);
		return null;
	}

}
