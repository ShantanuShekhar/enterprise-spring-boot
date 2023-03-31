package com.kishanseva.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Category")
public class Category {

	public Category() {
		super();
	}

	public Category(UUID categoryID, String categoryName, String categoryType, String varityName, String categoryPrice,
			String description, String createdBy, byte[] imageData, String fileTyoe, String fileName, Date createdOn,
			String updatedBy, Date updatedOn, String userName, String userID, String status) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.varityName = varityName;
		this.categoryPrice = categoryPrice;
		this.description = description;
		this.createdBy = createdBy;
		this.imageData = imageData;
		this.fileTyoe = fileTyoe;
		this.fileName = fileName;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.userName = userName;
		this.userID = userID;
		this.status = status;
	}

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "Id", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "category_id", columnDefinition = "VARCHAR(255)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID categoryID;//

	@Column(name = "category_name", nullable = true)
	private String categoryName;

	@Column(name = "category_type", nullable = true)
	private String categoryType;

	@Column(name = "varity_name", nullable = true)
	private String varityName;

	@Column(name = "category_price", nullable = true)
	private String categoryPrice;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "created_by", nullable = true)
	private String createdBy;

	@Lob
	@Column(name = "imagedata")
	private byte[] imageData;

	@Column(name = "file_type", nullable = true)
	private String fileTyoe;

	@Column(name = "file_name", nullable = true)
	private String fileName;

	@Column(name = "created_on", nullable = false)
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "updated_by", nullable = true)
	private String updatedBy;

	@Column(name = "updated_on", nullable = false)
	@UpdateTimestamp
	private Date updatedOn;

	@Column(name = "user_name", nullable = true)
	private String userName;

	@Column(name = "user_id", nullable = true)
	private String userID;

	@Column(name = "status", nullable = true)
	private String status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	private List<OrderDetails> order;

	public UUID getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(UUID categoryID) {
		this.categoryID = categoryID;
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

	public String getVarityName() {
		return varityName;
	}

	public void setVarityName(String varityName) {
		this.varityName = varityName;
	}

	public List<OrderDetails> getOrder() {
		return order;
	}

	public void setOrder(List<OrderDetails> order) {
		this.order = order;
	}
}
