package com.kishanseva.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuditorAwareImpl implements AuditorAware<String> {
	private static final Logger logger = LoggerFactory.getLogger(AuditorAwareImpl.class);

	@Override
	public Optional<String> getCurrentAuditor() {
		logger.info("Inside getCurrentAuditor ");
//		logger.info("Inside AuditorAwareImpl::");
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		logger.info("context is " + authentication);
//		if (authentication == null || !authentication.isAuthenticated()) {
//			logger.info("Inside authentication : " + authentication);
//			return null;
//		}
//		logger.info("succefully Authenticated");
//		return Optional.of("Vikash");
//		String username = ((User) authentication.getPrincipal()).getUsername();
//		logger.info("optional data is " + username);
//		return Optional.of(username);
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		logger.info("optional data is " + username);
		return Optional.of(username);
	}

}
