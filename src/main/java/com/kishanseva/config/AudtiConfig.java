package com.kishanseva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import com.kishanseva.services.AuditorAwareImpl;

@Component
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AudtiConfig {
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

}
