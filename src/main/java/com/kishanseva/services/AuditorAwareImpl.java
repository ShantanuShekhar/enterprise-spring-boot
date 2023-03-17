package com.kishanseva.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuditorAwareImpl implements AuditorAware<String> {
	private static final Logger logger = LoggerFactory.getLogger(AuditorAwareImpl.class);

//	@Autowired
//	private CustomUserDetailService customUserDetailService;
//	
	
	@Override
	public Optional<String> getCurrentAuditor() {
		logger.info("Inside getCurrentAuditor ");
//		logger.info("Inside AuditorAwareImpl::");

		final String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("current userNAme is " + currentUser);
		String currentUserName = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			currentUserName = authentication.getName();
			return Optional.of(currentUserName);
		} else {
			logger.info("current user is " + currentUserName);
			return Optional.of("noUser");
		}

//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		logger.info("authentication username is " + username);
//		List<User> list = userService.findByUserName(username);
//		logger.info("UserName is " + username);
//		if (!list.isEmpty() && list.size() > 0) {
//			logger.info("list size is " + list.size());
//			return Optional.of(list.get(0).toString());
//		} else {
//			throw new IllegalArgumentException();
//		}
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
//		String username = null;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		logger.info("principale is " + principal);
//		if (principal instanceof UserDetails) {
//			username = ((UserDetails) principal).getUsername();
//		} else {
//			username = principal.toString();
//		}
//		logger.info("optional data is " + username);
//		return Optional.of(username);
		
//		customUserDetailService.loadUserByUsername(currentUserName);
	}

}
