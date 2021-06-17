package com.signalforce.task.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the sys_lookup_types database table.
 * 
 */
@Entity
@Table(name="sys_lookup_types")
@NamedQuery(name="SysLookupType.findAll", query="SELECT s FROM SysLookupType s")
public class SysLookupType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LOOKUP_TYPE")
	private String lookupType;

	@Column(name="APPLICATION_ID")
	private BigInteger applicationId;

	@Column(name="CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="HAS_CHILD_FLAG")
	private byte hasChildFlag;

	@Column(name="LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name="LOOKUP_RANK")
	private int lookupRank;

	@Column(name="PARENT_LOOKUP_TYPE")
	private String parentLookupType;

	@Column(name="USER_SYSTEM_FLAG")
	private String userSystemFlag;

	//bi-directional many-to-one association to SysLookupTypeLang
	@OneToMany(mappedBy="sysLookupType")
	private List<SysLookupTypeLang> sysLookupTypeLangs;

	//bi-directional many-to-one association to SysLookupValue
	@OneToMany(mappedBy="sysLookupType")
	private List<SysLookupValue> sysLookupValues;

	public SysLookupType() {
	}

	public String getLookupType() {
		return this.lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public BigInteger getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(BigInteger applicationId) {
		this.applicationId = applicationId;
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

	public byte getHasChildFlag() {
		return this.hasChildFlag;
	}

	public void setHasChildFlag(byte hasChildFlag) {
		this.hasChildFlag = hasChildFlag;
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

	public int getLookupRank() {
		return this.lookupRank;
	}

	public void setLookupRank(int lookupRank) {
		this.lookupRank = lookupRank;
	}

	public String getParentLookupType() {
		return this.parentLookupType;
	}

	public void setParentLookupType(String parentLookupType) {
		this.parentLookupType = parentLookupType;
	}

	public String getUserSystemFlag() {
		return this.userSystemFlag;
	}

	public void setUserSystemFlag(String userSystemFlag) {
		this.userSystemFlag = userSystemFlag;
	}

	public List<SysLookupTypeLang> getSysLookupTypeLangs() {
		return this.sysLookupTypeLangs;
	}

	public void setSysLookupTypeLangs(List<SysLookupTypeLang> sysLookupTypeLangs) {
		this.sysLookupTypeLangs = sysLookupTypeLangs;
	}

	public SysLookupTypeLang addSysLookupTypeLang(SysLookupTypeLang sysLookupTypeLang) {
		getSysLookupTypeLangs().add(sysLookupTypeLang);
		sysLookupTypeLang.setSysLookupType(this);

		return sysLookupTypeLang;
	}

	public SysLookupTypeLang removeSysLookupTypeLang(SysLookupTypeLang sysLookupTypeLang) {
		getSysLookupTypeLangs().remove(sysLookupTypeLang);
		sysLookupTypeLang.setSysLookupType(null);

		return sysLookupTypeLang;
	}

	public List<SysLookupValue> getSysLookupValues() {
		return this.sysLookupValues;
	}

	public void setSysLookupValues(List<SysLookupValue> sysLookupValues) {
		this.sysLookupValues = sysLookupValues;
	}

	public SysLookupValue addSysLookupValue(SysLookupValue sysLookupValue) {
		getSysLookupValues().add(sysLookupValue);
		sysLookupValue.setSysLookupType(this);

		return sysLookupValue;
	}

	public SysLookupValue removeSysLookupValue(SysLookupValue sysLookupValue) {
		getSysLookupValues().remove(sysLookupValue);
		sysLookupValue.setSysLookupType(null);

		return sysLookupValue;
	}

}