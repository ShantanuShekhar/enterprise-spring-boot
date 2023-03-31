package com.kishanseva.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kishanseva.dto.CategoryDto;
import com.kishanseva.model.Category;
import com.kishanseva.services.ICategoryService;
import com.kishanseva.services.UserService;
import com.kishanseva.util.Constant;
import com.kishanseva.util.Response;
import com.kishanseva.util.ResponseCode;
import com.kishanseva.util.ResponseMessage;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ICategoryService categoryService;

	@PostMapping("/sell-item")
	public ResponseEntity<?> login(@RequestParam(value = "image") MultipartFile file,
			@RequestParam(value = "user_name") String username,
			@RequestParam(value = "category_name") String category_name,
			@RequestParam(value = "category_type") String category_type,
			@RequestParam(value = "varity_name") String varity_name,
			@RequestParam(value = "category_price") String category_price) {
		logger.info("Inside Sell item");
		Response response = new Response();

		boolean matcher = username.matches(Constant.EMAIL_REGEX);
		logger.info("matcher is " + matcher);
		if (!matcher) {
			logger.info("Inside Condititon matcher is " + matcher);

			response.setMessage(ResponseMessage.EmailMessage);
			response.setStatus(ResponseCode.VALIDATION_ERROR_API_CODE);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		response = categoryService.createCategorygorySellDetails(file, username, category_name, category_type,
				varity_name, category_price);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/search-filter-category")
	public ResponseEntity<?> getFilterCategory(@RequestBody CategoryDto reqbody) {
		logger.info("search-filter-category");
		Response response = new Response();
		response = categoryService.getFilteredCategory(reqbody);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
