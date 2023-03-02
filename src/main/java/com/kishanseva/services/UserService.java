package com.kishanseva.services;

import java.util.List;

import com.kishanseva.model.User;

public interface UserService {

	User saveUserRecords(String request);

	List<User> getRecordList(String request);

}
