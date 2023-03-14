package com.kishanseva.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishanseva.dao.UserDao;
import com.kishanseva.model.User;

@Repository
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	public User saveUserRecords(String request) throws JSONException {
		logger.info("Inside UserServiceImpl::saveUserRecords");
//		try {

		JSONObject obj = new JSONObject(request);
		String name = obj.getString("k1");
		String password = obj.getString("k2");
		String role = obj.getString("k3");
		logger.info("name {}", name);
		logger.info("password {} ", password);
		logger.info("role is {} ", role);

		User user = new User();
		user.setUsrID(createUniqueID("USER"));
		user.setUserName(name);
		user.setUserPassword(password);
		user.setRole(role);
		User userObj = userDao.save(user);
		return userObj;
//		} catch (Exception e) {
//			logger.info("Error " + e.getMessage());
//			return null;
//		}

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
			List<User> list = userDao.findByUserNameAndUserName(name1, null);
//			List<User> list = userDao.findByUserNameIsNot(name1);
			logger.info("username is " + list);
//			userDao.fin
			logger.info("list from dao is " + list.size());
			return list;

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
			logger.info("name {}", username);
			logger.info("role is {} ", role);
			User user = userDao.findById(userId).get();
			user.setUserName(username);
			user.setRole(role);
			User userObj = userDao.save(user);
			return userObj;

		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}

	}
}
