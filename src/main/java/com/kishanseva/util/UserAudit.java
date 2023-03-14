package com.kishanseva.util;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UserAudit {
	@CreatedBy
	private String createdBy;

	@Temporal(value = TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createOn;

	@org.springframework.data.annotation.LastModifiedBy
	private String LastModifiedBy;

	@Temporal(value = TemporalType.TIMESTAMP)
	@org.springframework.data.annotation.LastModifiedDate
	private Date LastModifiedDate;

	@PrePersist
	public void prePersist() {
		String createdByUser = getUsernameOfAuthenticatedUser();
		this.createdBy = createdByUser;
		this.LastModifiedBy = createdByUser;
	}

	@PreUpdate
	public void preUpdate() {
		String modifiedByUser = getUsernameOfAuthenticatedUser();
		this.LastModifiedBy = modifiedByUser;
	}

	private String getUsernameOfAuthenticatedUser() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println("Inside User UserAudit Authentticating "+authentication);
//		if (authentication == null || !authentication.isAuthenticated()) {
//			return null;
//		}
//		System.out.println("authentication success");
//		String username = ((User) authentication.getPrincipal()).getUsername();
//		System.out.println("validated username is " + username);
//		return username;

		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println("validated username is " + username);
		return username;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public String getLastModifiedBy() {
		return LastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}

}
