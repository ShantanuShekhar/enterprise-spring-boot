package com.kishanseva.util;

import java.io.Serializable;
import java.util.function.Function;

import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtUtil implements Serializable {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	private String SECRET_KEY = "abcd";
	private static final long serialVersionUID = 1L;

	public String getUserNameFromToken(String token) {
		logger.info("Inside JwtUtil : getUserNameFromToken");
		return extractClaim(token, Claims::getSubject);
	}
	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaim(token);
		return claimResolver.apply(claims);
	}
	private Claims extractAllClaim(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

}
