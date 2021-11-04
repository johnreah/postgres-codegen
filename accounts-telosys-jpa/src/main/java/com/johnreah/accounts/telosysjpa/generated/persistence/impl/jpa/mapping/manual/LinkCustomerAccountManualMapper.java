/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.manual;

import com.johnreah.accounts.telosysjpa.generated.data.record.LinkCustomerAccountRecord;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.JpaMapper;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.record.LinkCustomerAccountJpaRecord;

/**
 * Manual mapping for "LinkCustomerAccount" 
 *
 * @author Telosys
 *
 */
public class LinkCustomerAccountManualMapper implements JpaMapper<LinkCustomerAccountJpaRecord, LinkCustomerAccountRecord> {

	@Override
	public LinkCustomerAccountRecord mapEntityToRecord(LinkCustomerAccountJpaRecord entity) {
		if ( entity == null ) return null ;
		LinkCustomerAccountRecord pojo = new LinkCustomerAccountRecord();
		pojo.setCustomerId(entity.getCustomerId()); 
		pojo.setAccountId(entity.getAccountId()); 
		return pojo;
	}

	@Override
	public LinkCustomerAccountJpaRecord mapRecordToEntity(LinkCustomerAccountRecord pojo) {
		if ( pojo == null ) return null ;
		LinkCustomerAccountJpaRecord entity = new LinkCustomerAccountJpaRecord();
		entity.setCustomerId(pojo.getCustomerId()); 
		entity.setAccountId(pojo.getAccountId()); 
		return entity;
	}

}
