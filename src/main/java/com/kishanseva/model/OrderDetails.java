package com.kishanseva.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderDetails() {
		super();
	}

	public OrderDetails(UUID orderID, Integer quantity, Boolean isUsed, String orderType, Date deliveryDate,
			String registeredDetails, String createdBy, Date createdOn, String updatedBy, Date updatedOn,
			String userName, String userID, String status) {
		super();
		this.orderID = orderID;
		this.quantity = quantity;
		this.isUsed = isUsed;
		this.orderType = orderType;
		this.deliveryDate = deliveryDate;
		this.registeredDetails = registeredDetails;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.userName = userName;
		this.userID = userID;
		this.status = status;
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "orderID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "order_id", columnDefinition = "VARCHAR(255)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID orderID;//

	@Column(name = "qantity", nullable = true)
	private Integer quantity;

	@Column(name = "is_used", nullable = true)
	private Boolean isUsed = false;

	@Column(name = "order_type", nullable = true)
	private String orderType;

	@Column(name = "delivery_Date", nullable = true)
	private Date deliveryDate;

	@Column(name = "registered_details", nullable = true)
	private String registeredDetails;

	@Column(name = "created_by", nullable = true)
	private String createdBy;

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

	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;

	public UUID getOrderID() {
		return orderID;
	}

	public void setOrderID(UUID orderID) {
		this.orderID = orderID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getRegisteredDetails() {
		return registeredDetails;
	}

	public void setRegisteredDetails(String registeredDetails) {
		this.registeredDetails = registeredDetails;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

}
