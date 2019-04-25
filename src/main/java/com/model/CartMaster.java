package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({ @NamedQuery(name = "findCartById", query = "from CartMaster where cartId=:cartId"), })

@Entity
@Table(name = "cart_master")
public class CartMaster implements Serializable {

	private static final long serialVersionUID = 1770100630045170893L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crt_Id")
	private Long cartId;

	@Column(name = "crt_quantity")
	private Long quantity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "crt_product_id")
	private ProductMaster productMaster;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "crt_user_id")
	private UserMaster userMaster;

	@Column(name = "crt_cart_date")
	private Date cartAddedDate;

	@Column(name = "crt_isactive")
	private Boolean isActive;
	
	@Column(name = "crt_created_by")
	private Long createdBy;

	@Column(name = "crt_created_date")
	private Date createdDate;

	@Column(name = "crt_modify_by")
	private Long modifyBy;

	@Column(name = "crt_modify_date")
	private Date modifyDate;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Date getCartAddedDate() {
		return cartAddedDate;
	}

	public void setCartAddedDate(Date cartAddedDate) {
		this.cartAddedDate = cartAddedDate;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public ProductMaster getProductMaster() {
		return productMaster;
	}

	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
		cartAddedDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyDate = new Date();
	}
}
