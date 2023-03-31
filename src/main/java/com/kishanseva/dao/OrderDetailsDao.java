package com.kishanseva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.kishanseva.model.User;

@Repository
public interface OrderDetailsDao extends JpaRepository<User, String>, RevisionRepository<User, String, Integer> {

}
