package com.signalforce.task.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the erp_tax_schedules database table.
 * 
 */
@Entity
@Table(name="erp_tax_schedules")
@NamedQuery(name="ErpTaxSchedule.findAll", query="SELECT e FROM ErpTaxSchedule e")
public class ErpTaxSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TAX_SCHEDULE_ID")
	private String taxScheduleId;

	@Column(name="ACTIVE_FLAG")
	private byte activeFlag;

	@Column(name="CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	private String description;

	@Column(name="LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	//bi-directional many-to-one association to ErpPartnerClass
	@OneToMany(mappedBy="erpTaxSchedule")
	private List<ErpPartnerClass> erpPartnerClasses;

	//bi-directional many-to-one association to SalCustomer
	@OneToMany(mappedBy="erpTaxSchedule")
	private List<SalCustomer> salCustomers;

	public ErpTaxSchedule() {
	}

	public String getTaxScheduleId() {
		return this.taxScheduleId;
	}

	public void setTaxScheduleId(String taxScheduleId) {
		this.taxScheduleId = taxScheduleId;
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

	public List<ErpPartnerClass> getErpPartnerClasses() {
		return this.erpPartnerClasses;
	}

	public void setErpPartnerClasses(List<ErpPartnerClass> erpPartnerClasses) {
		this.erpPartnerClasses = erpPartnerClasses;
	}

	public ErpPartnerClass addErpPartnerClass(ErpPartnerClass erpPartnerClass) {
		getErpPartnerClasses().add(erpPartnerClass);
		erpPartnerClass.setErpTaxSchedule(this);

		return erpPartnerClass;
	}

	public ErpPartnerClass removeErpPartnerClass(ErpPartnerClass erpPartnerClass) {
		getErpPartnerClasses().remove(erpPartnerClass);
		erpPartnerClass.setErpTaxSchedule(null);

		return erpPartnerClass;
	}

	public List<SalCustomer> getSalCustomers() {
		return this.salCustomers;
	}

	public void setSalCustomers(List<SalCustomer> salCustomers) {
		this.salCustomers = salCustomers;
	}

	public SalCustomer addSalCustomer(SalCustomer salCustomer) {
		getSalCustomers().add(salCustomer);
		salCustomer.setErpTaxSchedule(this);

		return salCustomer;
	}

	public SalCustomer removeSalCustomer(SalCustomer salCustomer) {
		getSalCustomers().remove(salCustomer);
		salCustomer.setErpTaxSchedule(null);

		return salCustomer;
	}

}