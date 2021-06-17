CREATE TABLE `erp_partner_classes` (
  `PARTNER_CLASS_ID` bigint NOT NULL,
  `PARTNER_CLASS_CODE` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `PARTNER_TYPE_ID` bigint NOT NULL,
  `DESCRIPTION` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `CURRANCY_ID` bigint DEFAULT NULL,
  `TAX_SCHEDULE_ID` bigint NOT NULL,
  `PAYMENT_METHOD_ID` bigint NOT NULL,
  `ACTIVE_FLAG` tinyint(1) DEFAULT '1',
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`PARTNER_CLASS_ID`),
  UNIQUE KEY `SYS_C0053560` (`PARTNER_CLASS_CODE`),
  KEY `SYS_C0053586` (`TAX_SCHEDULE_ID`),
  KEY `SYS_C0053587` (`PAYMENT_METHOD_ID`),
  KEY `SYS_C0053585` (`PARTNER_TYPE_ID`),
  CONSTRAINT `SYS_C0053585` FOREIGN KEY (`PARTNER_TYPE_ID`) REFERENCES `sys_lookup_values` (`LOOKUP_ID`),
  CONSTRAINT `SYS_C0053586` FOREIGN KEY (`TAX_SCHEDULE_ID`) REFERENCES `erp_tax_schedules` (`TAX_SCHEDULE_ID`),
  CONSTRAINT `SYS_C0053587` FOREIGN KEY (`PAYMENT_METHOD_ID`) REFERENCES `sys_lookup_values` (`LOOKUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `erp_partner_classes_lang` (
  `PARTNER_CLASS_LANG_ID` bigint NOT NULL,
  `PARTNER_CLASS_ID` bigint NOT NULL,
  `LANGUAGE_CODE` varchar(16) COLLATE utf8_bin NOT NULL,
  `DESCRIPTION` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `erp_tax_schedules` (
  `TAX_SCHEDULE_ID` bigint NOT NULL,
  `DESCRIPTION` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVE_FLAG` tinyint(1) DEFAULT '1',
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`TAX_SCHEDULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `erp_tax_schedules_lang` (
  `LANG_ID` bigint NOT NULL,
  `TAX_SCHEDULE_ID` bigint NOT NULL,
  `LANGUAGE_CODE` varchar(16) COLLATE utf8_bin NOT NULL,
  `DESCRIPTION` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`LANG_ID`),
  UNIQUE KEY `SYS_C0053535` (`TAX_SCHEDULE_ID`,`LANGUAGE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sal_customer_address` (
  `ADDRESS_ID` bigint NOT NULL,
  `CUSTOMER_ID` bigint NOT NULL,
  `COUNTRY_ID` bigint DEFAULT NULL,
  `CITY_ID` bigint DEFAULT NULL,
  `ADDRESS` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `PRIMARY_FLAG` tinyint(1) DEFAULT NULL,
  `ACTIVE_STATUS_ID` tinyint(1) DEFAULT '1',
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`),
  KEY `SYS_C0054046` (`CUSTOMER_ID`),
  KEY `SYS_C0054047` (`COUNTRY_ID`),
  KEY `SYS_C0054130` (`CITY_ID`),
  CONSTRAINT `SYS_C0054046` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `sal_customers` (`CUSTOMER_ID`),
  CONSTRAINT `SYS_C0054047` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `sys_lookup_values` (`LOOKUP_ID`),
  CONSTRAINT `SYS_C0054130` FOREIGN KEY (`CITY_ID`) REFERENCES `sys_lookup_values` (`LOOKUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sal_customer_documents` (
  `DOC_ID` bigint NOT NULL,
  `CUSTOMER_ID` bigint NOT NULL,
  `DOC_TYPE_ID` bigint NOT NULL,
  `COUNTRY_ID` bigint NOT NULL,
  `ISSUE_DATE` datetime DEFAULT NULL,
  `ISSUE_END_DATE` datetime DEFAULT NULL,
  `DOCUMENT_PHOTO_PATH` varchar(800) COLLATE utf8_bin DEFAULT NULL,
  `REMARKS` varchar(800) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`DOC_ID`),
  KEY `SYS_C0054095` (`CUSTOMER_ID`),
  KEY `SYS_C0054096` (`DOC_TYPE_ID`),
  CONSTRAINT `SYS_C0054095` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `sal_customers` (`CUSTOMER_ID`),
  CONSTRAINT `SYS_C0054096` FOREIGN KEY (`DOC_TYPE_ID`) REFERENCES `sys_lookup_values` (`LOOKUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sal_customer_persons` (
  `PERSON_ID` bigint NOT NULL,
  `CUSTOMER_ID` bigint NOT NULL,
  `PERSON_TYPE_ID` bigint NOT NULL,
  `FULL_NAME` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `TITLE` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `PHONE_NO` varchar(160) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `EMAIL` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`),
  KEY `SYS_C0054085` (`CUSTOMER_ID`),
  KEY `SYS_C0054086` (`PERSON_TYPE_ID`),
  CONSTRAINT `SYS_C0054085` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `sal_customers` (`CUSTOMER_ID`),
  CONSTRAINT `SYS_C0054086` FOREIGN KEY (`PERSON_TYPE_ID`) REFERENCES `sys_lookup_values` (`LOOKUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sal_customer_phones` (
  `PHONE_ID` bigint NOT NULL,
  `CUSTOMER_ID` bigint NOT NULL,
  `PHONE_NO` varchar(160) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`PHONE_ID`),
  KEY `SYS_C0054093` (`CUSTOMER_ID`),
  CONSTRAINT `SYS_C0054093` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `sal_customers` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sal_customers` (
  `CUSTOMER_ID` bigint NOT NULL,
  `CUSTOMER_CODE` varchar(40) COLLATE utf8_bin NOT NULL,
  `FIRST_NAME` varchar(240) COLLATE utf8_bin DEFAULT NULL,
  `MIDDLE_NAME` varchar(240) COLLATE utf8_bin DEFAULT NULL,
  `LAST_NAME` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `FULL_NAME` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `PARTNER_CLASS_ID` bigint DEFAULT NULL,
  `CURRANCY_ID` bigint DEFAULT NULL,
  `TAX_SCHEDULE_ID` bigint DEFAULT NULL,
  `PAYMENT_METHOD_ID` bigint DEFAULT NULL,
  `TAX_FILE_NO` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `TAX_CARD_NO` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `COMM_RECORD` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `FAX_NO` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `URL` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVE_STATUS_ID` tinyint(1) DEFAULT '1',
  `START_DATE` datetime DEFAULT NULL,
  `END_DATE` datetime DEFAULT NULL,
  `CREDIT_LIMIT` double(12,2) DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `CUSTOMER_TYPE_ID` bigint DEFAULT NULL,
  `USER_VERIFICATION_CODE` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`),
  UNIQUE KEY `SYS_C0053566` (`CUSTOMER_CODE`),
  KEY `SYS_C0053597` (`PARTNER_CLASS_ID`),
  KEY `SYS_C0053598` (`CURRANCY_ID`),
  KEY `SYS_C0053599` (`TAX_SCHEDULE_ID`),
  KEY `SYS_C0053600` (`PAYMENT_METHOD_ID`),
  CONSTRAINT `SYS_C0053597` FOREIGN KEY (`PARTNER_CLASS_ID`) REFERENCES `erp_partner_classes` (`PARTNER_CLASS_ID`),
  CONSTRAINT `SYS_C0053598` FOREIGN KEY (`CURRANCY_ID`) REFERENCES `sys_lookup_values` (`LOOKUP_ID`),
  CONSTRAINT `SYS_C0053599` FOREIGN KEY (`TAX_SCHEDULE_ID`) REFERENCES `erp_tax_schedules` (`TAX_SCHEDULE_ID`),
  CONSTRAINT `SYS_C0053600` FOREIGN KEY (`PAYMENT_METHOD_ID`) REFERENCES `sys_lookup_values` (`LOOKUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sal_customers_lang` (
  `LANG_ID` bigint NOT NULL,
  `CUSTOMER_ID` bigint NOT NULL,
  `LANGUAGE_CODE` varchar(16) COLLATE utf8_bin NOT NULL,
  `DESCRIPTION` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`LANG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sys_languages` (
  `LANGUAGE_CODE` varchar(16) COLLATE utf8_bin NOT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_LOGIN` bigint DEFAULT NULL,
  PRIMARY KEY (`LANGUAGE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sys_languages_lang` (
  `LANGUAGE_LANG_ID` smallint NOT NULL,
  `LANGUAGE_CODE` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `LANGUAGE_ID` smallint DEFAULT NULL,
  `LANG_DESCRIPTION` varchar(800) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`LANGUAGE_LANG_ID`),
  UNIQUE KEY `SYS_C0053550` (`LANGUAGE_CODE`,`LANGUAGE_ID`),
  KEY `SYS_C0053582` (`LANGUAGE_CODE`),
  CONSTRAINT `SYS_C0053582` FOREIGN KEY (`LANGUAGE_CODE`) REFERENCES `sys_languages` (`LANGUAGE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sys_lookup_type_lang` (
  `LOOKUP_TYPE_LANG_ID` bigint NOT NULL,
  `LOOKUP_TYPE` varchar(120) COLLATE utf8_bin NOT NULL,
  `LANGUAGE_CODE` varchar(16) COLLATE utf8_bin NOT NULL,
  `DESCRIPTION` varchar(960) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`LOOKUP_TYPE_LANG_ID`),
  UNIQUE KEY `SYS_C0053553` (`LOOKUP_TYPE`,`LANGUAGE_CODE`),
  KEY `SYS_C0053583` (`LOOKUP_TYPE`),
  CONSTRAINT `SYS_C0053583` FOREIGN KEY (`LOOKUP_TYPE`) REFERENCES `sys_lookup_types` (`LOOKUP_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sys_lookup_types` (
  `LOOKUP_TYPE` varchar(120) COLLATE utf8_bin NOT NULL,
  `APPLICATION_ID` bigint DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `LOOKUP_RANK` mediumint DEFAULT NULL,
  `USER_SYSTEM_FLAG` varchar(4) COLLATE utf8_bin DEFAULT NULL,
  `HAS_CHILD_FLAG` tinyint(1) DEFAULT '0',
  `PARENT_LOOKUP_TYPE` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`LOOKUP_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sys_lookup_values` (
  `LOOKUP_ID` bigint NOT NULL,
  `LOOKUP_TYPE` varchar(120) COLLATE utf8_bin NOT NULL,
  `LOOKUP_CODE` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION` varchar(800) COLLATE utf8_bin DEFAULT NULL,
  `ENABLE_FLAG` tinyint(1) DEFAULT NULL,
  `START_DATE_ACTIVE` datetime DEFAULT NULL,
  `END_DATE_ACTIVE` datetime DEFAULT NULL,
  `VIEW_APPLICATION_ID` bigint NOT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`LOOKUP_ID`),
  UNIQUE KEY `SYS_C0053555` (`LOOKUP_TYPE`,`LOOKUP_CODE`),
  CONSTRAINT `SYS_C0053584` FOREIGN KEY (`LOOKUP_TYPE`) REFERENCES `sys_lookup_types` (`LOOKUP_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sys_lookup_values_lang` (
  `LOOKUP_VALUE_LANG_ID` bigint NOT NULL,
  `LOOKUP_ID` bigint NOT NULL,
  `LANGUAGE_CODE` varchar(16) COLLATE utf8_bin NOT NULL,
  `DESCRIPTION` varchar(800) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_BY` bigint DEFAULT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `LAST_UPDATE_BY` bigint DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`LOOKUP_VALUE_LANG_ID`),
  UNIQUE KEY `SYS_C0053557` (`LOOKUP_ID`,`LANGUAGE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
