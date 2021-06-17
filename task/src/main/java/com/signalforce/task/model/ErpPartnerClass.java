package com.signalforce.task.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the erp_partner_classes database table.
 * 
 */
@Entity
@Table(name="erp_partner_classes")
@NamedQuery(name="ErpPartnerClass.findAll", query="SELECT e FROM ErpPartnerClass e")
public class ErpPartnerClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PARTNER_CLASS_ID")
	private String partnerClassId;

	@Column(name="ACTIVE_FLAG")
	private byte activeFlag;

	@Column(name="CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="CURRANCY_ID")
	private BigInteger currancyId;

	private String description;

	@Column(name="LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name="PARTNER_CLASS_CODE")
	private String partnerClassCode;

	//bi-directional many-to-one association to SysLookupValue
	@ManyToOne
	@JoinColumn(name="PARTNER_TYPE_ID")
	private SysLookupValue sysLookupValue1;

	//bi-directional many-to-one association to ErpTaxSchedule
	@ManyToOne
	@JoinColumn(name="TAX_SCHEDULE_ID")
	private ErpTaxSchedule erpTaxSchedule;

	//bi-directional many-to-one association to SysLookupValue
	@ManyToOne
	@JoinColumn(name="PAYMENT_METHOD_ID")
	private SysLookupValue sysLookupValue2;

	//bi-directional many-to-one association to SalCustomer
	@OneToMany(mappedBy="erpPartnerClass")
	private List<SalCustomer> salCustomers;

	public ErpPartnerClass() {
	}

	public String getPartnerClassId() {
		return this.partnerClassId;
	}

	public void setPartnerClassId(String partnerClassId) {
		this.partnerClassId = partnerClassId;
	}

	public byte getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(byte activeFlag) {
		this.activeFlag = activeFlag;
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

	public BigInteger getCurrancyId() {
		return this.currancyId;
	}

	public void setCurrancyId(BigInteger currancyId) {
		this.currancyId = currancyId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPartnerClassCode() {
		return this.partnerClassCode;
	}

	public void setPartnerClassCode(String partnerClassCode) {
		this.partnerClassCode = partnerClassCode;
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

	public List<SalCustomer> getSalCustomers() {
		return this.salCustomers;
	}

	public void setSalCustomers(List<SalCustomer> salCustomers) {
		this.salCustomers = salCustomers;
	}

	public SalCustomer addSalCustomer(SalCustomer salCustomer) {
		getSalCustomers().add(salCustomer);
		salCustomer.setErpPartnerClass(this);

		return salCustomer;
	}

	public SalCustomer removeSalCustomer(SalCustomer salCustomer) {
		getSalCustomers().remove(salCustomer);
		salCustomer.setErpPartnerClass(null);

		return salCustomer;
	}

}