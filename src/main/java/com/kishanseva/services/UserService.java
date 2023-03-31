package com.kishanseva.services;

import java.util.List;

import org.json.JSONException;

import com.kishanseva.dto.CategoryDto;
import com.kishanseva.dto.UserDto;
import com.kishanseva.model.User;
import com.kishanseva.util.Response;

public interface UserService {

	Response saveUserRecords(String request) throws JSONException;

	List<User> getRecordList(String request);

	User updateUserRecords(String request);

//	List<User> findByUserName(String userName);

	User findByUserName(String userName);

	Response deleteUserRecord(String request) throws JSONException;

//	List<User> getByUserNameAndPassword(String userName, String password);

	Response getByUserNameAndPassword(String reqbody);

	Response verifyUserNameAndPassword(UserDto reqbody);

}
