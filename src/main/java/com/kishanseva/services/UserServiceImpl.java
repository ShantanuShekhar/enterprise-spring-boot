package com.kishanseva.services;

import java.util.ArrayList;
import java.util.List;

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
	public User saveUserRecords(String request) {
		logger.info("Inside UserServiceImpl::saveUserRecords");
		try {

			JSONObject obj = new JSONObject(request);
			String name = obj.getString("k1");
			String password = obj.getString("k2");
			String role = obj.getString("k3");
			logger.info("name {}", name);
			logger.info("password {} ", password);
			logger.info("role is {} ", role);

			User user = new User();
			user.setUsrID(uniqueID("USER"));
			user.setUserName(name);
			user.setUserPassword(password);
			user.setRole(role);
			userDao.save(user);
			return user;
		} catch (Exception e) {
			logger.info("Error " + e.getMessage());
			return null;
		}

	}
	private String uniqueID(String id) {
		logger.info("generating unique id");
		String num = id + System.currentTimeMillis();
		return num;
	}
	
	
	@Override
	public List<User> getRecordList(String request) {
		try {
			JSONObject obj = new JSONObject(request);
			String name = obj.getString("k1");
			logger.info("name is " + name);
			List<String> data = new ArrayList<>();
			data.add("Shantanu Shekhar");
			data.add("Mohan Kumar");
			data.add("Raj Kumar");
			List<User> list = userDao.findAllByUserNameIn(data);
			logger.info("list from dao is " + list.size());
			return list;

		} catch (Exception e) {
			return null;
		}
	}
}
