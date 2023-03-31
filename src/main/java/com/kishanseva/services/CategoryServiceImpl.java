package com.kishanseva.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kishanseva.dao.CategoryDao;
import com.kishanseva.dto.CategoryDto;
import com.kishanseva.model.Category;
import com.kishanseva.model.OrderDetails;
import com.kishanseva.model.User;
import com.kishanseva.util.Constant;
import com.kishanseva.util.ImageUtil;
import com.kishanseva.util.Response;
import com.kishanseva.util.ResponseCode;
import com.kishanseva.util.ResponseMessage;

@Service
public class CategoryServiceImpl implements ICategoryService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private UserService userService;

	@Override
	public Response getFilteredCategory(CategoryDto reqbody) {

		Response response = new Response();

		String user_name = reqbody.getUserName();
		logger.info("username is " + user_name);
		String category_name = reqbody.getCategoryName();
		String category_type = reqbody.getCategoryType();
		String varity_name = reqbody.getVarityName();

		if (category_name == null || category_name.isEmpty() || category_name == "") {
			category_name = null;
		}
		if (category_type == null || category_type.isEmpty() || category_type == "") {
			category_type = null;
		}
		if (varity_name == null || varity_name.isEmpty() || varity_name == "") {
			varity_name = null;
		}

		List<Category> categoryList = categoryDao.fecthRecordByFilterCategory(category_name, category_type,
				varity_name);
		response.setMessage("Details Retrived Successfully!!");
		response.setStatus(ResponseCode.SUCCESS_API_CODE);
		response.setList(categoryList);
		return response;
	}

	@Override
	public Response createCategorygorySellDetails(MultipartFile file, String username, String category_name,
			String category_type, String varity_name, String category_price) {
		logger.info("Inside createCategorygorySellDetails");
		Response response = new Response();
		try {
			User user = userService.findByUserName(username);
			if (user == null) {
				logger.error("Inside createCategorygorySellDetails :: User_not Found");
				response.setStatus(ResponseCode.NOT_fOUND_CODE);
				response.setMessage(ResponseMessage.USER_NOT_FOUND_MESSAGE);
				return response;
			}
			String userID = user.getUsrID();
			logger.info("user id is:: " + userID);
			Category category = new Category();
			String categoryName = category_name;
			String categoryType = category_type;
			String varityName = varity_name;
			String fileName = file.getName();
			String fileType = file.getContentType();
			byte[] fileImage = file.getBytes();//

			category.setCategoryName(categoryName);
			category.setCategoryType(categoryType);
			category.setVarityName(varityName);
			category.setFileName(fileName);
			category.setFileTyoe(fileType);
			category.setCategoryPrice(category_price);
			category.setImageData(ImageUtil.compressImage(fileImage));
			category.setCreatedBy(username);
			category.setUserName(username);
			category.setUserID(userID);

			OrderDetails order = new OrderDetails();
			order.setCreatedOn(new Date());
			order.setCreatedBy(username);
			order.setUserName(username);
			order.setUserID(userID);
			order.setCategory(category);

			category.setOrder(Arrays.asList(order));
			
			
			categoryDao.save(category);
			response.setStatus(ResponseCode.SUCCESS_API_CODE);
			response.setMessage("your post is Published ");
//			response.setList(Arrays.asList(categoryID));
			return response;
		} catch (IOException e) {
			response.setStatus(ResponseCode.VALIDATION_ERROR_API_CODE);
			response.setMessage(ResponseMessage.CATCH_ERROR_RESPONSE);
			return response;
		}
	}

}
