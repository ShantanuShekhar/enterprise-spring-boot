package com.kishanseva.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishanseva.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

	List<User> findAllByUserNameIn(List<String> data);

}
