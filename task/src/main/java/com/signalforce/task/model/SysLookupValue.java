package com.signalforce.task.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the sys_lookup_values database table.
 * 
 */
@Entity
@Table(name="sys_lookup_values")
@NamedQuery(name="SysLookupValue.findAll", query="SELECT s FROM SysLookupValue s")
public class SysLookupValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LOOKUP_ID")
	private String lookupId;

	@Column(name="CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	private String description;

	@Column(name="ENABLE_FLAG")
	private byte enableFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_DATE_ACTIVE")
	private Date endDateActive;

	@Column(name="LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name="LOOKUP_CODE")
	private String lookupCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_DATE_ACTIVE")
	private Date startDateActive;

	@Column(name="VIEW_APPLICATION_ID")
	private BigInteger viewApplicationId;

	//bi-directional many-to-one association to ErpPartnerClass
	@OneToMany(mappedBy="sysLookupValue1")
	private List<ErpPartnerClass> erpPartnerClasses1;

	//bi-directional many-to-one association to ErpPartnerClass
	@OneToMany(mappedBy="sysLookupValue2")
	private List<ErpPartnerClass> erpPartnerClasses2;

	//bi-directional many-to-one association to SalCustomerAddress
	@OneToMany(mappedBy="sysLookupValue1")
	private List<SalCustomerAddress> salCustomerAddresses1;

	//bi-directional many-to-one association to SalCustomerAddress
	@OneToMany(mappedBy="sysLookupValue2")
	private List<SalCustomerAddress> salCustomerAddresses2;

	//bi-directional many-to-one association to SalCustomerDocument
	@OneToMany(mappedBy="sysLookupValue")
	private List<SalCustomerDocument> salCustomerDocuments;

	//bi-directional many-to-one association to SalCustomerPerson
	@OneToMany(mappedBy="sysLookupValue")
	private List<SalCustomerPerson> salCustomerPersons;

	//bi-directional many-to-one association to SalCustomer
	@OneToMany(mappedBy="sysLookupValue1")
	private List<SalCustomer> salCustomers1;

	//bi-directional many-to-one association to SalCustomer
	@OneToMany(mappedBy="sysLookupValue2")
	private List<SalCustomer> salCustomers2;

	//bi-directional many-to-one association to SysLookupType
	@ManyToOne
	@JoinColumn(name="LOOKUP_TYPE")
	private SysLookupType sysLookupType;

	public SysLookupValue() {
	}

	public String getLookupId() {
		return this.lookupId;
	}

	public void setLookupId(String lookupId) {
		this.lookupId = lookupId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getEnableFlag() {
		return this.enableFlag;
	}

	public void setEnableFlag(byte enableFlag) {
		this.enableFlag = enableFlag;
	}

	public Date getEndDateActive() {
		return this.endDateActive;
	}

	public void setEndDateActive(Date endDateActive) {
		this.endDateActive = endDateActive;
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

	public String getLookupCode() {
		return this.lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public Date getStartDateActive() {
		return this.startDateActive;
	}

	public void setStartDateActive(Date startDateActive) {
		this.startDateActive = startDateActive;
	}

	public BigInteger getViewApplicationId() {
		return this.viewApplicationId;
	}

	public void setViewApplicationId(BigInteger viewApplicationId) {
		this.viewApplicationId = viewApplicationId;
	}

	public List<ErpPartnerClass> getErpPartnerClasses1() {
		return this.erpPartnerClasses1;
	}

	public void setErpPartnerClasses1(List<ErpPartnerClass> erpPartnerClasses1) {
		this.erpPartnerClasses1 = erpPartnerClasses1;
	}

	public ErpPartnerClass addErpPartnerClasses1(ErpPartnerClass erpPartnerClasses1) {
		getErpPartnerClasses1().add(erpPartnerClasses1);
		erpPartnerClasses1.setSysLookupValue1(this);

		return erpPartnerClasses1;
	}

	public ErpPartnerClass removeErpPartnerClasses1(ErpPartnerClass erpPartnerClasses1) {
		getErpPartnerClasses1().remove(erpPartnerClasses1);
		erpPartnerClasses1.setSysLookupValue1(null);

		return erpPartnerClasses1;
	}

	public List<ErpPartnerClass> getErpPartnerClasses2() {
		return this.erpPartnerClasses2;
	}

	public void setErpPartnerClasses2(List<ErpPartnerClass> erpPartnerClasses2) {
		this.erpPartnerClasses2 = erpPartnerClasses2;
	}

	public ErpPartnerClass addErpPartnerClasses2(ErpPartnerClass erpPartnerClasses2) {
		getErpPartnerClasses2().add(erpPartnerClasses2);
		erpPartnerClasses2.setSysLookupValue2(this);

		return erpPartnerClasses2;
	}

	public ErpPartnerClass removeErpPartnerClasses2(ErpPartnerClass erpPartnerClasses2) {
		getErpPartnerClasses2().remove(erpPartnerClasses2);
		erpPartnerClasses2.setSysLookupValue2(null);

		return erpPartnerClasses2;
	}

	public List<SalCustomerAddress> getSalCustomerAddresses1() {
		return this.salCustomerAddresses1;
	}

	public void setSalCustomerAddresses1(List<SalCustomerAddress> salCustomerAddresses1) {
		this.salCustomerAddresses1 = salCustomerAddresses1;
	}

	public SalCustomerAddress addSalCustomerAddresses1(SalCustomerAddress salCustomerAddresses1) {
		getSalCustomerAddresses1().add(salCustomerAddresses1);
		salCustomerAddresses1.setSysLookupValue1(this);

		return salCustomerAddresses1;
	}

	public SalCustomerAddress removeSalCustomerAddresses1(SalCustomerAddress salCustomerAddresses1) {
		getSalCustomerAddresses1().remove(salCustomerAddresses1);
		salCustomerAddresses1.setSysLookupValue1(null);

		return salCustomerAddresses1;
	}

	public List<SalCustomerAddress> getSalCustomerAddresses2() {
		return this.salCustomerAddresses2;
	}

	public void setSalCustomerAddresses2(List<SalCustomerAddress> salCustomerAddresses2) {
		this.salCustomerAddresses2 = salCustomerAddresses2;
	}

	public SalCustomerAddress addSalCustomerAddresses2(SalCustomerAddress salCustomerAddresses2) {
		getSalCustomerAddresses2().add(salCustomerAddresses2);
		salCustomerAddresses2.setSysLookupValue2(this);

		return salCustomerAddresses2;
	}

	public SalCustomerAddress removeSalCustomerAddresses2(SalCustomerAddress salCustomerAddresses2) {
		getSalCustomerAddresses2().remove(salCustomerAddresses2);
		salCustomerAddresses2.setSysLookupValue2(null);

		return salCustomerAddresses2;
	}

	public List<SalCustomerDocument> getSalCustomerDocuments() {
		return this.salCustomerDocuments;
	}

	public void setSalCustomerDocuments(List<SalCustomerDocument> salCustomerDocuments) {
		this.salCustomerDocuments = salCustomerDocuments;
	}

	public SalCustomerDocument addSalCustomerDocument(SalCustomerDocument salCustomerDocument) {
		getSalCustomerDocuments().add(salCustomerDocument);
		salCustomerDocument.setSysLookupValue(this);

		return salCustomerDocument;
	}

	public SalCustomerDocument removeSalCustomerDocument(SalCustomerDocument salCustomerDocument) {
		getSalCustomerDocuments().remove(salCustomerDocument);
		salCustomerDocument.setSysLookupValue(null);

		return salCustomerDocument;
	}

	public List<SalCustomerPerson> getSalCustomerPersons() {
		return this.salCustomerPersons;
	}

	public void setSalCustomerPersons(List<SalCustomerPerson> salCustomerPersons) {
		this.salCustomerPersons = salCustomerPersons;
	}

	public SalCustomerPerson addSalCustomerPerson(SalCustomerPerson salCustomerPerson) {
		getSalCustomerPersons().add(salCustomerPerson);
		salCustomerPerson.setSysLookupValue(this);

		return salCustomerPerson;
	}

	public SalCustomerPerson removeSalCustomerPerson(SalCustomerPerson salCustomerPerson) {
		getSalCustomerPersons().remove(salCustomerPerson);
		salCustomerPerson.setSysLookupValue(null);

		return salCustomerPerson;
	}

	public List<SalCustomer> getSalCustomers1() {
		return this.salCustomers1;
	}

	public void setSalCustomers1(List<SalCustomer> salCustomers1) {
		this.salCustomers1 = salCustomers1;
	}

	public SalCustomer addSalCustomers1(SalCustomer salCustomers1) {
		getSalCustomers1().add(salCustomers1);
		salCustomers1.setSysLookupValue1(this);

		return salCustomers1;
	}

	public SalCustomer removeSalCustomers1(SalCustomer salCustomers1) {
		getSalCustomers1().remove(salCustomers1);
		salCustomers1.setSysLookupValue1(null);

		return salCustomers1;
	}

	public List<SalCustomer> getSalCustomers2() {
		return this.salCustomers2;
	}

	public void setSalCustomers2(List<SalCustomer> salCustomers2) {
		this.salCustomers2 = salCustomers2;
	}

	public SalCustomer addSalCustomers2(SalCustomer salCustomers2) {
		getSalCustomers2().add(salCustomers2);
		salCustomers2.setSysLookupValue2(this);

		return salCustomers2;
	}

	public SalCustomer removeSalCustomers2(SalCustomer salCustomers2) {
		getSalCustomers2().remove(salCustomers2);
		salCustomers2.setSysLookupValue2(null);

		return salCustomers2;
	}

	public SysLookupType getSysLookupType() {
		return this.sysLookupType;
	}

	public void setSysLookupType(SysLookupType sysLookupType) {
		this.sysLookupType = sysLookupType;
	}

}