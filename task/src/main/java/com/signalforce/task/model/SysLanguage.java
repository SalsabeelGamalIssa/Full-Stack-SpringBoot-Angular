package com.signalforce.task.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the sys_languages database table.
 * 
 */
@Entity
@Table(name="sys_languages")
@NamedQuery(name="SysLanguage.findAll", query="SELECT s FROM SysLanguage s")
public class SysLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LANGUAGE_CODE")
	private String languageCode;

	@Column(name="CREATED_BY")
	private BigInteger createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="LAST_UPDATE_BY")
	private BigInteger lastUpdateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name="LAST_UPDATE_LOGIN")
	private BigInteger lastUpdateLogin;

	//bi-directional many-to-one association to SysLanguagesLang
	@OneToMany(mappedBy="sysLanguage")
	private List<SysLanguagesLang> sysLanguagesLangs;

	public SysLanguage() {
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
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

	public BigInteger getLastUpdateLogin() {
		return this.lastUpdateLogin;
	}

	public void setLastUpdateLogin(BigInteger lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public List<SysLanguagesLang> getSysLanguagesLangs() {
		return this.sysLanguagesLangs;
	}

	public void setSysLanguagesLangs(List<SysLanguagesLang> sysLanguagesLangs) {
		this.sysLanguagesLangs = sysLanguagesLangs;
	}

	public SysLanguagesLang addSysLanguagesLang(SysLanguagesLang sysLanguagesLang) {
		getSysLanguagesLangs().add(sysLanguagesLang);
		sysLanguagesLang.setSysLanguage(this);

		return sysLanguagesLang;
	}

	public SysLanguagesLang removeSysLanguagesLang(SysLanguagesLang sysLanguagesLang) {
		getSysLanguagesLangs().remove(sysLanguagesLang);
		sysLanguagesLang.setSysLanguage(null);

		return sysLanguagesLang;
	}

}