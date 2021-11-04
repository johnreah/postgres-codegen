/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.manual;

import com.johnreah.accounts.telosysjpa.generated.data.record.AccountTypeRecord;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.JpaMapper;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.record.AccountTypeJpaRecord;

/**
 * Manual mapping for "AccountType" 
 *
 * @author Telosys
 *
 */
public class AccountTypeManualMapper implements JpaMapper<AccountTypeJpaRecord, AccountTypeRecord> {

	@Override
	public AccountTypeRecord mapEntityToRecord(AccountTypeJpaRecord entity) {
		if ( entity == null ) return null ;
		AccountTypeRecord pojo = new AccountTypeRecord();
		pojo.setId(entity.getId()); 
		pojo.setDescription(entity.getDescription()); 
		pojo.setReference(entity.getReference()); 
		return pojo;
	}

	@Override
	public AccountTypeJpaRecord mapRecordToEntity(AccountTypeRecord pojo) {
		if ( pojo == null ) return null ;
		AccountTypeJpaRecord entity = new AccountTypeJpaRecord();
		entity.setId(pojo.getId()); 
		entity.setDescription(pojo.getDescription()); 
		entity.setReference(pojo.getReference()); 
		return entity;
	}

}
