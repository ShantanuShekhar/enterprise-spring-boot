package com.kishanseva.services;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kishanseva.model.User;

public class UserDetailsImpl implements UserDetails {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

	private final User u;

	public UserDetailsImpl(User u) {
		logger.info("Inside UserDetailsImpl :constructor called user is " + u.getUserName());
		this.u = u;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		logger.info("grantAuthority Called");
		return List.of(() -> "read");
	}

	@Override
	public String getPassword() {
		logger.info("password is " + u.getPassword());
		return u.getPassword();
	}

	@Override
	public String getUsername() {
		return u.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
