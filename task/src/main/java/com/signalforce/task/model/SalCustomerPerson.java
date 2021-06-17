package com.signalforce.task.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the sal_customer_persons database table.
 * 
 */
@Entity
@Table(name = "sal_customer_persons")
@NamedQuery(name = "SalCustomerPerson.findAll", query = "SELECT s FROM SalCustomerPerson s")
public class SalCustomerPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	private Long personId;

	@Column(name = "CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "TITLE")
	private String title;

	// bi-directional many-to-one association to SalCustomer
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "CUSTOMER_ID")
	private SalCustomer salCustomer;

	// bi-directional many-to-one association to SysLookupValue
	@ManyToOne
	@JsonBackReference(value = "sysLookupValue")
	@JoinColumn(name = "PERSON_TYPE_ID")
	private SysLookupValue sysLookupValue;

	public SalCustomerPerson() {
	}

	public SalCustomerPerson(Long personId, String email, String fullName, String phoneNo, String title) {
		super();
		this.personId = personId;
		this.email = email;
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.title = title;
	}

	public SalCustomerPerson(String email, String fullName, String phoneNo, String title, SalCustomer salCustomer) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.title = title;
		this.salCustomer = salCustomer;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public BigInteger getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BigInteger getLastUpdateBy() {
		return this.lastUpdateBy;
	}

	public void setLastUpdateBy(BigInteger lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SalCustomer getSalCustomer() {
		return this.salCustomer;
	}

	public void setSalCustomer(SalCustomer salCustomer) {
		this.salCustomer = salCustomer;
	}

	public SysLookupValue getSysLookupValue() {
		return this.sysLookupValue;
	}

	public void setSysLookupValue(SysLookupValue sysLookupValue) {
		this.sysLookupValue = sysLookupValue;
	}

}