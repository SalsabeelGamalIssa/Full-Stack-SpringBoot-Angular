package com.signalforce.task.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the sys_lookup_values_lang database table.
 * 
 */
@Entity
@Table(name="sys_lookup_values_lang")
@NamedQuery(name="SysLookupValuesLang.findAll", query="SELECT s FROM SysLookupValuesLang s")
public class SysLookupValuesLang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LOOKUP_VALUE_LANG_ID")
	private String lookupValueLangId;

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

	@Column(name="LOOKUP_ID")
	private BigInteger lookupId;

	public SysLookupValuesLang() {
	}

	public String getLookupValueLangId() {
		return this.lookupValueLangId;
	}

	public void setLookupValueLangId(String lookupValueLangId) {
		this.lookupValueLangId = lookupValueLangId;
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

	public BigInteger getLookupId() {
		return this.lookupId;
	}

	public void setLookupId(BigInteger lookupId) {
		this.lookupId = lookupId;
	}

}