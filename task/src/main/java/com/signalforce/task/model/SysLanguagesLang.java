package com.signalforce.task.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sys_languages_lang database table.
 * 
 */
@Entity
@Table(name="sys_languages_lang")
@NamedQuery(name="SysLanguagesLang.findAll", query="SELECT s FROM SysLanguagesLang s")
public class SysLanguagesLang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LANGUAGE_LANG_ID")
	private short languageLangId;

	@Column(name="LANG_DESCRIPTION")
	private String langDescription;

	@Column(name="LANGUAGE_ID")
	private short languageId;

	//bi-directional many-to-one association to SysLanguage
	@ManyToOne
	@JoinColumn(name="LANGUAGE_CODE")
	private SysLanguage sysLanguage;

	public SysLanguagesLang() {
	}

	public short getLanguageLangId() {
		return this.languageLangId;
	}

	public void setLanguageLangId(short languageLangId) {
		this.languageLangId = languageLangId;
	}

	public String getLangDescription() {
		return this.langDescription;
	}

	public void setLangDescription(String langDescription) {
		this.langDescription = langDescription;
	}

	public short getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(short languageId) {
		this.languageId = languageId;
	}

	public SysLanguage getSysLanguage() {
		return this.sysLanguage;
	}

	public void setSysLanguage(SysLanguage sysLanguage) {
		this.sysLanguage = sysLanguage;
	}

}