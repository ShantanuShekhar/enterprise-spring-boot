package com.kishanseva.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kishanseva.util.CustomUserDetailService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Autowired
	private UserDetailsService userDetailsServiceImpl;
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new CustomUserDetailService();
//	}

	@Autowired
	private CustomUserDetailService customUserDetailService;

//	@Autowired
//	private BCryptPasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("Inside Configue : going to authorize url");
		// disabling csrf since we won't use form login
		http.csrf().disable().
		// giving permission to every request for /create endpoint
				authorizeRequests().antMatchers("/create-user").

				// for everything else, the user has to be authenticated
				permitAll().antMatchers("/update-user").permitAll().antMatchers("/delete-user").permitAll().anyRequest()
				.authenticated().and().httpBasic();
		// .and().formLogin();
		// setting stateless session, because we choose to implement Rest API
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().cacheControl();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("Configuration auth is called");
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("P4ssword")).roles("user").and()
//				.withUser("user2").password(passwordEncoder.encode("P4ssword")).roles("user").and()
//				.passwordEncoder(passwordEncoder);
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(encoder());
	}

}
