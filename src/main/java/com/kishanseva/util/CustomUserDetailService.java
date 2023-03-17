package com.kishanseva.util;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kishanseva.dao.UserDao;
import com.kishanseva.model.User;
import com.kishanseva.services.UserDetailsImpl;
import com.kishanseva.services.UserService;
import com.kishanseva.services.UserServiceImpl;

@Service("CustomUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

//	@Autowired
//	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("loadUserByUsername is called::" + username);
		Optional<User> user = userDao.findByUserName(username);
		User u = user.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		return new UserDetailsImpl(u);

//			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//					new ArrayList<>());
	}
}
