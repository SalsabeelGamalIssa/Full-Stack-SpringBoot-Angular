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
 * The persistent class for the sal_customer_address database table.
 * 
 */
@Entity
@Table(name = "sal_customer_address")
@NamedQuery(name = "SalCustomerAddress.findAll", query = "SELECT s FROM SalCustomerAddress s")
public class SalCustomerAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private String addressId;

	@Column(name = "ACTIVE_STATUS_ID")
	private byte activeStatusId;

	private String address;

	@Column(name = "CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name = "PRIMARY_FLAG")
	private byte primaryFlag;

	// bi-directional many-to-one association to SalCustomer
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "CUSTOMER_ID")
	private SalCustomer salCustomer;

	// bi-directional many-to-one association to SysLookupValue
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private SysLookupValue sysLookupValue1;

	// bi-directional many-to-one association to SysLookupValue
	@ManyToOne
	@JoinColumn(name = "CITY_ID")
	private SysLookupValue sysLookupValue2;

	public SalCustomerAddress() {
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public byte getActiveStatusId() {
		return this.activeStatusId;
	}

	public void setActiveStatusId(byte activeStatusId) {
		this.activeStatusId = activeStatusId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public byte getPrimaryFlag() {
		return this.primaryFlag;
	}

	public void setPrimaryFlag(byte primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

	@JsonBackReference
	public SalCustomer getSalCustomer() {
		return this.salCustomer;
	}

	public void setSalCustomer(SalCustomer salCustomer) {
		this.salCustomer = salCustomer;
	}

	public SysLookupValue getSysLookupValue1() {
		return this.sysLookupValue1;
	}

	public void setSysLookupValue1(SysLookupValue sysLookupValue1) {
		this.sysLookupValue1 = sysLookupValue1;
	}

	public SysLookupValue getSysLookupValue2() {
		return this.sysLookupValue2;
	}

	public void setSysLookupValue2(SysLookupValue sysLookupValue2) {
		this.sysLookupValue2 = sysLookupValue2;
	}

}