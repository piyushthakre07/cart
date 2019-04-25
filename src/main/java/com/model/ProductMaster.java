package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@NamedQueries({
    @NamedQuery(
        name = "findAllProduct",
        query = "from ProductMaster"
        ),
    @NamedQuery(
            name = "findProductById",
            query = "from ProductMaster where productId=:productId"
            ),
})
	
@Entity
@Table(name = "product_master")
public class ProductMaster implements Serializable {

	private static final long serialVersionUID = 6771968678873149222L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pm_Id")
	private Long productId;

	@Column(name = "pm_product_name")
	private String productName;
	
	@Column(name = "pm_product_brand")
	private String productBrand;
	
	@Column(name = "pm_product_mrp")
	private Long mrp;
	
	@Column(name = "pm_product_prise")
	private Long prise;
	
	@Column(name = "pm_product_discount_amount")
	private Long discountAmount;
	
	@Column(name = "pm_product_description")
	private String description;
	
	@Column(name = "pm_product_is_stock")
	private Boolean isInStock;
	
	@Column(name = "pm_product_stock_quantity")
	private Long stockQuantity;
	
	@Column(name = "pm_product_offer")
	private Long offerId;
	
	@Column(name = "pm_product_category")
	private Long categoryId;
	
	@Column(name = "pm_product_expire_date")
	private String expireDate;
	
	@Column(name = "pm_product_warrenty_days")
	private Long warrentyInDays;
	
	@Column(name = "pm_product_replacement_days")
	private Long replacementInDays;
	
	@Column(name = "pm_product_delivery_days")
	private Long deliveryInDays;
	
	@Column(name = "pm_product_delivery_cost")
	private Long deliveryCost; 
	
	@Column(name = "pm_product_active")
	private Boolean isActive;
	
	@Column(name = "pm_product_hide")
	private Boolean isHide;
	
	@Column(name = "pm_created_by")
	private Long createdBy;

	@Column(name = "pm_created_date")
	private Date createdDate;

	@Column(name = "pm_modify_by")
	private Long modifyBy;

	@Column(name = "pm_modify_date")
	private Date modifyDate;

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		modifyDate = new Date();
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public Long getMrp() {
		return mrp;
	}
	public void setMrp(Long mrp) {
		this.mrp = mrp;
	}
	public Long getPrise() {
		return prise;
	}
	public void setPrise(Long prise) {
		this.prise = prise;
	}
	public Long getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Long discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsInStock() {
		return isInStock;
	}
	public void setIsInStock(Boolean isInStock) {
		this.isInStock = isInStock;
	}
	public Long getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public Long getOfferId() {
		return offerId;
	}
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public Long getWarrentyInDays() {
		return warrentyInDays;
	}
	public void setWarrentyInDays(Long warrentyInDays) {
		this.warrentyInDays = warrentyInDays;
	}
	public Long getReplacementInDays() {
		return replacementInDays;
	}
	public void setReplacementInDays(Long replacementInDays) {
		this.replacementInDays = replacementInDays;
	}
	public Long getDeliveryInDays() {
		return deliveryInDays;
	}
	public void setDeliveryInDays(Long deliveryInDays) {
		this.deliveryInDays = deliveryInDays;
	}
	public Long getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(Long deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsHide() {
		return isHide;
	}
	public void setIsHide(Boolean isHide) {
		this.isHide = isHide;
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
	
}
