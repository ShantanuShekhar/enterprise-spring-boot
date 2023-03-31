package com.kishanseva.dto;

import java.util.Date;

import javax.validation.constraints.*;

public class UserDto {

	private String usrID;

	@NotNull(message = "name shouldn't empty")
	@NotEmpty(message = "name shouldn't empty")
	@NotBlank(message = "name should not blank")
	private String name;

	@NotNull(message = "username shouldn't empty")
	@NotEmpty(message = "username shouldn't empty")
	@NotBlank(message = "username should not blank")
	@Email(message = "Email should be valid")
	private String userName;

	private String role;
	
	@NotNull(message = "password shouldn't empty")
	@NotEmpty(message = "password shouldn't empty")
	@NotBlank(message = "password should not blank")
	@Size(min = 5, max = 10, message = "password must be betweeen 5 and 10 character")
	private String password;

	private String createdBy;

	private Date createdOn;

	private String updatedBy;

	private Date updatedOn;

	public UserDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsrID() {
		return usrID;
	}

	public void setUsrID(String usrID) {
		this.usrID = usrID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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

}
