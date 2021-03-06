/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */

package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa;


import java.util.List;

import javax.inject.Named;

import com.johnreah.accounts.telosysjpa.generated.data.record.CustomerRecord; // "Neutral Record" class 
import com.johnreah.accounts.telosysjpa.generated.persistence.CustomerPersistence; // Persistence service interface
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.commons.GenericJpaService;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.JpaMapper;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.JpaMapping;

import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.record.CustomerJpaRecord; // "JPA Record" class (with JPA mapping) 

/**
 * Customer persistence service - JPA implementation 
 * 
 * @author Telosys 
 *
 */
@Named("CustomerPersistence")
public class CustomerPersistenceJpa extends GenericJpaService<CustomerJpaRecord, Long> implements CustomerPersistence {

	private final JpaMapper<CustomerJpaRecord,CustomerRecord> mapper = JpaMapping.getMapperProvider().getMapper(CustomerJpaRecord.class,CustomerRecord.class);

	/**
	 * Constructor
	 */
	public CustomerPersistenceJpa() {
		super(CustomerJpaRecord.class);
	}

	@Override
	public CustomerRecord findById( Long id ) {
		CustomerJpaRecord entity = super.find( id );
		return mapper.mapEntityToRecord(entity);	
	}

	@Override
	public List<CustomerRecord> findAll() {
		List<CustomerJpaRecord> entities = super.loadAll() ;
		List<CustomerRecord> records = new java.util.LinkedList<CustomerRecord>();
		for ( CustomerJpaRecord entity : entities ) {
			records.add( mapper.mapEntityToRecord(entity) ) ;
		}
		return records ;
	}

	@Override
	public CustomerRecord create(CustomerRecord record) {
		CustomerJpaRecord entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
		// Auto-incremented key : set the generated id in the original record
		record.setId( entity.getId() ) ;
		//record.setId(entity.getId());
		return record ;
	}
	
	@Override
	public boolean update(CustomerRecord record) {
		Long pk = record.getId() ;
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			CustomerJpaRecord entity = mapper.mapRecordToEntity(record);
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

	@Override
	public CustomerRecord save(CustomerRecord record) {
		CustomerJpaRecord entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
		return record ;
	}

	@Override
	public boolean deleteById( Long id ) {
		return super.remove( id );
	}

	@Override
	public boolean delete(CustomerRecord record) {
		if ( record != null ) {
			return super.remove( record.getId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countAll") ) ;
		return count.longValue();
	}

	public long countById(Long id) {
		Long count = (Long) super.execNamedQueryWithSingleResult( buildQueryName("countById"), id ) ;
		return count.longValue();
	}
	
	@Override
	public boolean exists(Long id) {
		long count = countById(id) ;
		return count > 0 ;
	}


	@Override
	public boolean exists(CustomerRecord record) {
		if ( record != null ) {
			return exists( record.getId() );
		}
		return false ;
	}

	@SuppressWarnings("unchecked")
	public List<CustomerJpaRecord> queryExample() {
		List<?> list = super.execNamedQuery(buildQueryName("theNamedQueryToBeUsed")) ;
		return (List<CustomerJpaRecord>) list ;
	}

}
