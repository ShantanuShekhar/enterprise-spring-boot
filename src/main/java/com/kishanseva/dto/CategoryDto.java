package com.kishanseva.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;

public class CategoryDto {

	private UUID categoryID;

	private String categoryName;

	private String categoryType;

	private String categoryPrice;

	private String description;

	private String createdBy;

	private String varityName;

	private byte[] imageData;

	private String fileTyoe;

	private String fileName;

	private Date createdOn;

	private String updatedBy;

	private Date updatedOn;

	private String userName;

	private String userID;

	private String status;

	public UUID getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(UUID categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryPrice() {
		return categoryPrice;
	}

	public void setCategoryPrice(String categoryPrice) {
		this.categoryPrice = categoryPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public String getFileTyoe() {
		return fileTyoe;
	}

	public void setFileTyoe(String fileTyoe) {
		this.fileTyoe = fileTyoe;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getVarityName() {
		return varityName;
	}

	public void setVarityName(String varityName) {
		this.varityName = varityName;
	}
}
