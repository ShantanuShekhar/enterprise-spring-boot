package com.kishanseva.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "User")
@Audited
public class User implements Serializable {

	private static final long serialVersionUID = 5468607267229292043L;

	@Id
	@Column(name = "UserID")
	private String usrID;

	@Column(name = "Name", unique = true)
	private String name;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "Role")
	private String role;

	@Column(name = "Password")
	private String password;

	@Column(name = "CreatedBy")
	private String createdBy;

	@LastModifiedBy
	@Column(name = "UpdatedBy")
	private String updatedBy;

	@LastModifiedDate
	@Column(name = "UpdatedOn")
	private Date updatedOn;

	@Column(name = "CreatedOn")
	private Date createdOn;

	public String getUsrID() {
		return usrID;
	}

	public void setUsrID(String usrID) {
		this.usrID = usrID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
