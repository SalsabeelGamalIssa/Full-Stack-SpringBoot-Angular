package com.signalforce.task.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the sal_customers database table.
 * 
 */
@Entity
@Table(name = "sal_customers")
@NamedQuery(name = "SalCustomer.findAll", query = "SELECT s FROM SalCustomer s")
public class SalCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private BigInteger customerId;

	@Column(name = "ACTIVE_STATUS_ID")
	private byte activeStatusId;

	@Column(name = "COMM_RECORD")
	private String commRecord;

	@Column(name = "CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "CREDIT_LIMIT")
	private double creditLimit;

	@Column(name = "CUSTOMER_CODE")
	private String customerCode;

	@Column(name = "CUSTOMER_TYPE_ID")
	private BigInteger customerTypeId;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "FAX_NO")
	private String faxNo;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "TAX_CARD_NO")
	private String taxCardNo;

	@Column(name = "TAX_FILE_NO")
	private String taxFileNo;

	private String url;

	@Column(name = "USER_VERIFICATION_CODE")
	private String userVerificationCode;

	// bi-directional many-to-one association to SalCustomerAddress
	@OneToMany(mappedBy = "salCustomer")
	@JsonManagedReference
	@JsonIgnore
	private List<SalCustomerAddress> salCustomerAddresses;

	// bi-directional many-to-one association to SalCustomerDocument
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "salCustomer")
	private List<SalCustomerDocument> salCustomerDocuments;

	// bi-directional many-to-one association to SalCustomerPerson
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "salCustomer")
	private List<SalCustomerPerson> salCustomerPersons;

	// bi-directional many-to-one association to SalCustomerPhone

	@OneToMany(mappedBy = "salCustomer")
	@JsonIgnore
	private List<SalCustomerPhone> salCustomerPhones;

	// bi-directional many-to-one association to ErpPartnerClass
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "PARTNER_CLASS_ID")
	private ErpPartnerClass erpPartnerClass;

	// bi-directional many-to-one association to SysLookupValue
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "CURRANCY_ID")
	private SysLookupValue sysLookupValue1;

	// bi-directional many-to-one association to ErpTaxSchedule
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "TAX_SCHEDULE_ID")
	private ErpTaxSchedule erpTaxSchedule;

	// bi-directional many-to-one association to SysLookupValue
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "PAYMENT_METHOD_ID")
	private SysLookupValue sysLookupValue2;

	public SalCustomer() {
	}

	public SalCustomer(byte activeStatusId, String commRecord, BigInteger createdBy, Date creationDate,
			double creditLimit, String customerCode, BigInteger customerTypeId, String email, Date endDate,
			String faxNo, String firstName, String fullName, String lastName, BigInteger lastUpdateBy,
			Date lastUpdateDate, String middleName, Date startDate, String taxCardNo, String taxFileNo, String url,
			String userVerificationCode, List<SalCustomerAddress> salCustomerAddresses,
			List<SalCustomerDocument> salCustomerDocuments, List<SalCustomerPerson> salCustomerPersons,
			List<SalCustomerPhone> salCustomerPhones, ErpPartnerClass erpPartnerClass, SysLookupValue sysLookupValue1,
			ErpTaxSchedule erpTaxSchedule, SysLookupValue sysLookupValue2) {
		super();
		this.activeStatusId = activeStatusId;
		this.commRecord = commRecord;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.creditLimit = creditLimit;
		this.customerCode = customerCode;
		this.customerTypeId = customerTypeId;
		this.email = email;
		this.endDate = endDate;
		this.faxNo = faxNo;
		this.firstName = firstName;
		this.fullName = fullName;
		this.lastName = lastName;
		this.lastUpdateBy = lastUpdateBy;
		this.lastUpdateDate = lastUpdateDate;
		this.middleName = middleName;
		this.startDate = startDate;
		this.taxCardNo = taxCardNo;
		this.taxFileNo = taxFileNo;
		this.url = url;
		this.userVerificationCode = userVerificationCode;
		this.salCustomerAddresses = salCustomerAddresses;
		this.salCustomerDocuments = salCustomerDocuments;
		this.salCustomerPersons = salCustomerPersons;
		this.salCustomerPhones = salCustomerPhones;
		this.erpPartnerClass = erpPartnerClass;
		this.sysLookupValue1 = sysLookupValue1;
		this.erpTaxSchedule = erpTaxSchedule;
		this.sysLookupValue2 = sysLookupValue2;
	}

	public BigInteger getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public byte getActiveStatusId() {
		return this.activeStatusId;
	}

	public void setActiveStatusId(byte activeStatusId) {
		this.activeStatusId = activeStatusId;
	}

	public String getCommRecord() {
		return this.commRecord;
	}

	public void setCommRecord(String commRecord) {
		this.commRecord = commRecord;
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

	public double getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public BigInteger getCustomerTypeId() {
		return this.customerTypeId;
	}

	public void setCustomerTypeId(BigInteger customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFaxNo() {
		return this.faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTaxCardNo() {
		return this.taxCardNo;
	}

	public void setTaxCardNo(String taxCardNo) {
		this.taxCardNo = taxCardNo;
	}

	public String getTaxFileNo() {
		return this.taxFileNo;
	}

	public void setTaxFileNo(String taxFileNo) {
		this.taxFileNo = taxFileNo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserVerificationCode() {
		return this.userVerificationCode;
	}

	public void setUserVerificationCode(String userVerificationCode) {
		this.userVerificationCode = userVerificationCode;
	}

	@JsonManagedReference
	public List<SalCustomerAddress> getSalCustomerAddresses() {
		return this.salCustomerAddresses;
	}

	public void setSalCustomerAddresses(List<SalCustomerAddress> salCustomerAddresses) {
		this.salCustomerAddresses = salCustomerAddresses;
	}

	public SalCustomerAddress addSalCustomerAddress(SalCustomerAddress salCustomerAddress) {
		getSalCustomerAddresses().add(salCustomerAddress);
		salCustomerAddress.setSalCustomer(this);

		return salCustomerAddress;
	}

	public SalCustomerAddress removeSalCustomerAddress(SalCustomerAddress salCustomerAddress) {
		getSalCustomerAddresses().remove(salCustomerAddress);
		salCustomerAddress.setSalCustomer(null);

		return salCustomerAddress;
	}

	@JsonManagedReference
	public List<SalCustomerDocument> getSalCustomerDocuments() {
		return this.salCustomerDocuments;
	}

	public void setSalCustomerDocuments(List<SalCustomerDocument> salCustomerDocuments) {
		this.salCustomerDocuments = salCustomerDocuments;
	}

	public SalCustomerDocument addSalCustomerDocument(SalCustomerDocument salCustomerDocument) {
		getSalCustomerDocuments().add(salCustomerDocument);
		salCustomerDocument.setSalCustomer(this);

		return salCustomerDocument;
	}

	public SalCustomerDocument removeSalCustomerDocument(SalCustomerDocument salCustomerDocument) {
		getSalCustomerDocuments().remove(salCustomerDocument);
		salCustomerDocument.setSalCustomer(null);

		return salCustomerDocument;
	}

	@JsonManagedReference
	public List<SalCustomerPerson> getSalCustomerPersons() {
		return this.salCustomerPersons;
	}

	public void setSalCustomerPersons(List<SalCustomerPerson> salCustomerPersons) {
		this.salCustomerPersons = salCustomerPersons;
	}

	public SalCustomerPerson addSalCustomerPerson(SalCustomerPerson salCustomerPerson) {
		getSalCustomerPersons().add(salCustomerPerson);
		salCustomerPerson.setSalCustomer(this);

		return salCustomerPerson;
	}

	public SalCustomerPerson removeSalCustomerPerson(SalCustomerPerson salCustomerPerson) {
		getSalCustomerPersons().remove(salCustomerPerson);
		salCustomerPerson.setSalCustomer(null);

		return salCustomerPerson;
	}

	@JsonManagedReference
	public List<SalCustomerPhone> getSalCustomerPhones() {
		return this.salCustomerPhones;
	}

	public void setSalCustomerPhones(List<SalCustomerPhone> salCustomerPhones) {
		this.salCustomerPhones = salCustomerPhones;
	}

	public SalCustomerPhone addSalCustomerPhone(SalCustomerPhone salCustomerPhone) {
		getSalCustomerPhones().add(salCustomerPhone);
		salCustomerPhone.setSalCustomer(this);

		return salCustomerPhone;
	}

	public SalCustomerPhone removeSalCustomerPhone(SalCustomerPhone salCustomerPhone) {
		getSalCustomerPhones().remove(salCustomerPhone);
		salCustomerPhone.setSalCustomer(null);

		return salCustomerPhone;
	}

	public ErpPartnerClass getErpPartnerClass() {
		return this.erpPartnerClass;
	}

	public void setErpPartnerClass(ErpPartnerClass erpPartnerClass) {
		this.erpPartnerClass = erpPartnerClass;
	}

	public SysLookupValue getSysLookupValue1() {
		return this.sysLookupValue1;
	}

	public void setSysLookupValue1(SysLookupValue sysLookupValue1) {
		this.sysLookupValue1 = sysLookupValue1;
	}

	public ErpTaxSchedule getErpTaxSchedule() {
		return this.erpTaxSchedule;
	}

	public void setErpTaxSchedule(ErpTaxSchedule erpTaxSchedule) {
		this.erpTaxSchedule = erpTaxSchedule;
	}

	public SysLookupValue getSysLookupValue2() {
		return this.sysLookupValue2;
	}

	public void setSysLookupValue2(SysLookupValue sysLookupValue2) {
		this.sysLookupValue2 = sysLookupValue2;
	}

}