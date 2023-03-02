package com.kishanseva.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
	@Id
	@Column(name = "UserID")
	private String usrID;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "Role")
	private String role;
	
	@Column(name = "UserPassword")
	private String userPassword;

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	

}
