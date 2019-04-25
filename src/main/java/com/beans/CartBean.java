package com.beans;

import java.io.Serializable;

public class CartBean implements Serializable {

	private static final long serialVersionUID = -9206691549647980499L;
	
	private Long cartId;
	
	private Long quantity;
	
	private Long productId;
	
	private Long userId;
	
	private String description;
	
	private Boolean isoutOfStock;
	
	private Long createdBy;
	
	private Long modifyBy;
	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsoutOfStock() {
		return isoutOfStock;
	}

	public void setIsoutOfStock(Boolean isoutOfStock) {
		this.isoutOfStock = isoutOfStock;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	

}
