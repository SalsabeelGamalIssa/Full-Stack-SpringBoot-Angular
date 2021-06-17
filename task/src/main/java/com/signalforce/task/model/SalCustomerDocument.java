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
 * The persistent class for the sal_customer_documents database table.
 * 
 */
@Entity
@Table(name = "sal_customer_documents")
@NamedQuery(name = "SalCustomerDocument.findAll", query = "SELECT s FROM SalCustomerDocument s")
public class SalCustomerDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID")
	private String docId;

	@Column(name = "COUNTRY_ID")
	private BigInteger countryId;

	@Column(name = "CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "DOCUMENT_PHOTO_PATH")
	private String documentPhotoPath;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ISSUE_DATE")
	private Date issueDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ISSUE_END_DATE")
	private Date issueEndDate;

	@Column(name = "LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	private String remarks;

	// bi-directional many-to-one association to SalCustomer
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "CUSTOMER_ID")
	private SalCustomer salCustomer;

	// bi-directional many-to-one association to SysLookupValue
	@ManyToOne
	@JoinColumn(name = "DOC_TYPE_ID")
	private SysLookupValue sysLookupValue;

	public SalCustomerDocument() {
	}

	public String getDocId() {
		return this.docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public BigInteger getCountryId() {
		return this.countryId;
	}

	public void setCountryId(BigInteger countryId) {
		this.countryId = countryId;
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

	public String getDocumentPhotoPath() {
		return this.documentPhotoPath;
	}

	public void setDocumentPhotoPath(String documentPhotoPath) {
		this.documentPhotoPath = documentPhotoPath;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getIssueEndDate() {
		return this.issueEndDate;
	}

	public void setIssueEndDate(Date issueEndDate) {
		this.issueEndDate = issueEndDate;
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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@JsonBackReference
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