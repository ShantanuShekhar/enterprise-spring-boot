package com.kishanseva.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.kishanseva.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String>, RevisionRepository<User, String, Integer> {

	List<User> findAllByUserNameIn(List<String> data);

//	List<User> findByUserNameIsNull(List<String> data);

	List<User> findByUserNameIsNot(String name1);

	List<User> findByUserNameIs(String name1);

	List<User> findByUserNameAndPassword(String name1, String string);

	List<User> findByUserNameAndUserName(String name1, String string);

	Optional<User> findByUserName(String userName);

//	List<User> findByUserNameOrUserName(String name1);

}
