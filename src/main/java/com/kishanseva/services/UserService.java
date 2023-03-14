package com.kishanseva.services;

import java.util.List;

import org.json.JSONException;

import com.kishanseva.model.User;

public interface UserService {

	User saveUserRecords(String request) throws JSONException;

	List<User> getRecordList(String request);

	User updateUserRecords(String request);

}
