package com.signalforce.task.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the sys_lookup_type_lang database table.
 * 
 */
@Entity
@Table(name="sys_lookup_type_lang")
@NamedQuery(name="SysLookupTypeLang.findAll", query="SELECT s FROM SysLookupTypeLang s")
public class SysLookupTypeLang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LOOKUP_TYPE_LANG_ID")
	private String lookupTypeLangId;

	@Column(name="CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	private String description;

	@Column(name="LANGUAGE_CODE")
	private String languageCode;

	@Column(name="LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	//bi-directional many-to-one association to SysLookupType
	@ManyToOne
	@JoinColumn(name="LOOKUP_TYPE")
	private SysLookupType sysLookupType;

	public SysLookupTypeLang() {
	}

	public String getLookupTypeLangId() {
		return this.lookupTypeLangId;
	}

	public void setLookupTypeLangId(String lookupTypeLangId) {
		this.lookupTypeLangId = lookupTypeLangId;
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

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
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

	public SysLookupType getSysLookupType() {
		return this.sysLookupType;
	}

	public void setSysLookupType(SysLookupType sysLookupType) {
		this.sysLookupType = sysLookupType;
	}

}