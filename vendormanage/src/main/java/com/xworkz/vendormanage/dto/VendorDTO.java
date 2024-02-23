package com.xworkz.vendormanage.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "vendordetails")
@NamedQuery(name = "isExist", query = "SELECT ve FROM VendorDTO ve WHERE ve.gstNo = :gstNo OR ve.contactNo = :cNumber OR ve.email = :vMail OR ve.website = :vWebsite")
@NamedQuery(name="findAll" , query = "select et FROM VendorDTO et")
public class VendorDTO {
	@Id
	@Column(name = "vendor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer vendorId;

	@NotNull(message = "vendorName must not be empty...")
	@Size(min = 3, max = 30, message = "Please enter valid vendorName")
	@Column(name = "vendorName")
	private String vendorName;

	@NotNull(message = "Location must not be empty...")
	@Size(min = 3, max = 30, message = "Please enter valid Location")
	@Column(name = "location")
	private String location;

	@NotNull(message = "gstNo must not be empty...")
	@Size(min = 3, max = 20, message = "please enter valid gstNo")
	@Column(name = "gstNo")
	private String gstNo;

	@NotNull
	@Column(name = "companyStartDate")
	private String companyStartDate;

	@NotNull(message = "ownerName must not be empty...")
	@Size(min = 3, max = 20, message = "please enter valid ownerName")
	@Column(name = "ownerName")
	private String ownerName;

	@NotNull
	@Column(name = "serviceType")
	private String serviceType;

	@NotNull(message = "contactNo must not be empty...")
	@Min(value = 10)
	@Column(name = "contactNo")
	private Long contactNo;

	@NotNull(message = "alternativeNo must not be empty...")
	@Min(value = 10)
	@Column(name = "alternativeNo")
	private Long alternativeNo;

	@NotNull(message = "email must not be empty...")
	@Size(min = 3, max = 30, message = "please enter valid email")
	@Column(name = "vendorEmail")
	private String email;

	@NotNull(message = "website must not be empty...")
	@Size(min = 3, max = 50, message = "please enter valid websiteName")
	@Column(name = "website")
	private String website;

	@Column(name = "createdBY")
	private String createdBy;

	@Column(name = "createdDate")
	private LocalDate createdDate;

	@Column(name = "updatedBy")
	private String updatedBy;

	@Column(name = "updatedDate")
	private LocalDate updatedDate;

}