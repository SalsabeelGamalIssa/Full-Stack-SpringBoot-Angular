package com.signalforce.task.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the erp_partner_classes_lang database table.
 * 
 */
@Entity
@Table(name = "erp_partner_classes_lang")
@NamedQuery(name = "ErpPartnerClassesLang.findAll", query = "SELECT e FROM ErpPartnerClassesLang e")
public class ErpPartnerClassesLang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARTNER_CLASS_LANG_ID")
	private BigInteger partnerClassLangId;

	@Column(name = "CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	private String description;

	@Column(name = "LANGUAGE_CODE")
	private String languageCode;

	@Column(name = "LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name = "PARTNER_CLASS_ID")
	private BigInteger partnerClassId;

	public ErpPartnerClassesLang() {
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

	public BigInteger getPartnerClassId() {
		return this.partnerClassId;
	}

	public void setPartnerClassId(BigInteger partnerClassId) {
		this.partnerClassId = partnerClassId;
	}

	public BigInteger getPartnerClassLangId() {
		return this.partnerClassLangId;
	}

	public void setPartnerClassLangId(BigInteger partnerClassLangId) {
		this.partnerClassLangId = partnerClassLangId;
	}

}