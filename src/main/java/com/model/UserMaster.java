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
		@NamedQuery(name = "findUserMasterByUsernamePassword", query = "from UserMaster where loginId=:loginId and password=:password"), })

@Entity
@Table(name = "user_master")
public class UserMaster implements Serializable {

	private static final long serialVersionUID = 1684907057174985100L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "um_user_Id")
	private Long userId;

	@Column(name = "um_login_name")
	private String loginId;

	@Column(name = "um_password")
	private String password;

	@Column(name = "um_first_name")
	private String firstName;

	@Column(name = "um_last_name")
	private String lastName;

	@Column(name = "um_user_street_name1")
	private String street1;

	@Column(name = "um_user_street_name2")
	private String street2;

	@Column(name = "um_user_locality")
	private String locality;

	@Column(name = "um_user_city_id")
	private Long cityId;

	@Column(name = "um_user_state_id")
	private Long stateId;

	@Column(name = "um_user_country_id")
	private Long countryId;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "um_token")
	private String token;

	@Column(name = "sm_created_by")
	private Long createdBy;

	@Column(name = "sm_created_date")
	private Date createdDate;

	@Column(name = "sm_modify_by")
	private Long modifyBy;

	@Column(name = "sm_modify_date")
	private Date modifyDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginId;
	}

	public void setLoginName(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
	}

	@PreUpdate
	protected void onUpdate() {
		modifyDate = new Date();
	}
}
