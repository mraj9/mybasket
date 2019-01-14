package com.myproject.mybasket.user;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "CorporateScheduleDetails")
@EntityListeners(AuditingEntityListener.class)
public class CorporateScheduleDetailsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "corporate_schedule_id")
	private long id;
	@NotBlank
	@Column(name = "CompanyName")
	private String companyName;
	@NotBlank
	@Column(name = "ContactPersonName")
	private String contactPersonName;
	
	@Column(name = "MobileNo")
	private Long mobileNo;
	@NotBlank
	@Column(name = "EmailId")
	private String emailId;
	@NotBlank
	@Column(name = "Address")
	private String address;
	@NotBlank
	@Column(name = "Locality")
	private String locality;

	@Column(name = "Pincode")
	private int pincode;
	@NotBlank
	@Column(name = "City")
	private String city;
	@NotBlank
	@Column(name = "State")
	private String state;
	@NotBlank
	@Column(name = "ScrapType")
	private String scrapType;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "PickupDate")
	private String pickupDate;
	@NotBlank
	@Column(name = "PickupTime")
	private String pickupTime;
	
	@Column(name = "Weight")
	private int weight;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private Users user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getScrapType() {
		return scrapType;
	}

	public void setScrapType(String scrapType) {
		this.scrapType = scrapType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	 

}
