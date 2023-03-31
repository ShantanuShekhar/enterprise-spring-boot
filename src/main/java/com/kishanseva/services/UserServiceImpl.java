package com.kishanseva.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.bcel.Const;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kishanseva.dao.UserDao;
import com.kishanseva.dto.UserDto;
import com.kishanseva.model.User;
import com.kishanseva.util.Constant;
import com.kishanseva.util.Response;
import com.kishanseva.util.ResponseCode;
import com.kishanseva.util.ResponseMessage;

@Repository
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Response saveUserRecords(String request) throws JSONException {
		logger.info("Inside UserServiceImpl::saveUserRecords");

		Response response = new Response();
		JSONObject obj = new JSONObject(request);
		String userName = obj.getString("k1");
		String password = obj.getString("k2");
		logger.info("name {}", userName);
		logger.info("password {} ", password);

		// validating userName using rejex
		boolean matcher = true;
		matcher = userName.matches(Constant.EMAIL_REGEX);
		if (!matcher) {
			response.setMessage(ResponseMessage.EmailMessage);
			response.setStatus(ResponseCode.VALIDATION_ERROR_API_CODE);
			response.setList(Arrays.asList());
			return response;
		}
		User user = new User();
		user.setUsrID(createUniqueID("USER"));
		user.setUserName(userName);
		user.setPassword(encoder.encode(password));
		user.setRole(Constant.CUSTOMER_ROL);
		user.setCreatedBy(userName);
		user.setCreatedOn(new Date());
		User userObj = userDao.save(user);

		response.setMessage(ResponseMessage.DETAIL_RETRIEVE_SUCCESS);
		response.setStatus(ResponseCode.SUCCESS_API_CODE);
		response.setList(Arrays.asList(userObj));
		return response;

	}

	private String createUniqueID(String id) {
		logger.info("generating unique id");
		String num = id + System.currentTimeMillis();
		return num;
	}

	@Override
	public List<User> getRecordList(String request) {
		try {
			JSONObject obj = new JSONObject(request);
			String name = obj.getString("k1");
//			Integer data = obj.getInt("k2");
			logger.info("name is " + name);
			List<String> data = new ArrayList<>();
			data.add("Shantanu Shekhar");
			data.add("Mohan Kumar");
			data.add("Raj Kumar");
			String name1 = "Shantanu Shekhar";
//			List<User> list = userDao.findAllByUserNameIn(data);

//			List<User> list = 	userDao.findByUserNameIs(null);
//			List<User> list = userDao.findByUserNameAndUserName(name1, null);
//			List<User> list = userDao.findByUserNameIsNot(name1);
//			logger.info("username is " + list);
//			userDao.fin
//			logger.info("list from dao is " + list.size());
//			return list;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User updateUserRecords(String request) {
		logger.info("Inside UserServiceImpl : updateUserRecords");

		try {

			JSONObject obj = new JSONObject(request);
			String userId = obj.getString("k1");
			logger.info("userId is " + userId);
			String username = obj.getString("k2");
			String role = obj.getString("k3");
			logger.info("name {}", username);// USER1678885152686
			logger.info("role is {} ", role);
			User user = userDao.findById(userId).get();
			String userName = user.getUserName();
			logger.info("Username is " + userName);
			user.setUserName(username);
			user.setRole(role);
			user.setUpdatedBy(username);
			user.setUpdatedOn(new Date());
			User userObj = userDao.save(user);
			return userObj;

		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

//	@Override
//	public User findByUserName(String userName) {
//
//		logger.info("Inside Userservice Finding UserName " + userName);
//		return userDao.findByUserName(userName).get();
//	}

	@Override
	public Response deleteUserRecord(String request) throws JSONException {
		logger.info("inside deleteUserRecord");

		Response response = new Response();
		JSONObject obj = new JSONObject(request);
		String userID = obj.getString("k1");
		logger.info("userId is " + userID);
		User user = userDao.findById(userID).get();
		if (user == null) {
			response.setList(Arrays.asList());
			response.setMessage("user is not founr to this ID " + userID);
			response.setStatus("ERROR000");
			return response;
		}
		String username = user.getUserName();
		user.setUpdatedBy(username);
		user.setUpdatedOn(new Date());
		userDao.save(user);
		userDao.deleteById(userID);
		response.setList(Arrays.asList());
		response.setMessage("ID " + userID + " Record has been deleted succssfully ");
		response.setStatus(ResponseCode.SUCCESS_API_CODE);
		return response;
	}

	@Override
	public User findByUserName(String userName) {
		logger.info("Inside service");
		return userDao.findByUserName(userName).orElse(null);
//		logger.info("username ccc is {}", user);

	}

	@Override
	public Response getByUserNameAndPassword(String reqbody) {
		Response response = new Response();

		try {
			JSONObject obj = new JSONObject(reqbody);
			String userName = obj.getString("k1");
			String password = obj.getString("k2");

			List<User> list = userDao.findByUserNameAndPassword(userName, password);
			if (list.isEmpty()) {
				return null;
			} else {
				logger.info("list is " + list);

				response.setList(list);
				response.setMessage("Login Successfully");
				response.setStatus(ResponseCode.SUCCESS_API_CODE);
				return response;
			}

		} catch (JSONException e) {
			e.printStackTrace();
			response.setStatus("ERRORX000");
			response.setMessage(ResponseMessage.CATCH_ERROR_RESPONSE);
			return response;
		}
	}

	@Override
	public Response verifyUserNameAndPassword(UserDto reqbody) {
		Response response = new Response();
		String pass = reqbody.getPassword();
		User user = userDao.findByUserName(reqbody.getUserName()).get();
		if (encoder.matches(pass, user.getPassword())) {
			List<User> list = userDao.findByUserNameAndPassword(reqbody.getUserName(), user.getPassword());
			if (!list.isEmpty()) {
				response.setList(list);
				response.setMessage("Login Successfully");
				response.setStatus(ResponseCode.SUCCESS_API_CODE);
				return response;
			} else {
				response.setList(list);
				response.setMessage("Incorrect username or password please check");
				response.setStatus(ResponseCode.VALIDATION_ERROR_API_CODE);
				return response;

			}
		} else {
			response.setList(null);
			response.setMessage("Incorrect username or password please check");
			response.setStatus(ResponseCode.VALIDATION_ERROR_API_CODE);
			return response;

		}

	}
}
