/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.persistence.impl.fake;

import java.util.List;


import javax.inject.Named;

import com.johnreah.accounts.telosysjpa.generated.data.record.AccountHistoryRecord;
import com.johnreah.accounts.telosysjpa.generated.persistence.AccountHistoryPersistence;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.fake.commons.GenericFakeDAO;

/**
 * AccountHistory persistence service - FAKE implementation 
 * 
 * @author Telosys
 *
 */
@Named("AccountHistoryPersistence")
public class AccountHistoryPersistenceFake extends GenericFakeDAO<AccountHistoryRecord> implements AccountHistoryPersistence {

	/**
	 * Constructor
	 */
	public AccountHistoryPersistenceFake() {
		super(AccountHistoryRecord.class);
	}

	/**
	 * Creates a new bean instance and set its primary key value(s)
	 * 
	 * @param id
	 * @return the new instance
	 */
	private AccountHistoryRecord newInstanceWithPrimaryKey(Long id) {
		AccountHistoryRecord record = new AccountHistoryRecord();
        record.setId(id); 
		return record;
	}

	//-------------------------------------------------------------------------------------
	// Generic DAO abstract methods implementations
	//-------------------------------------------------------------------------------------
	@Override
	protected String getKey(AccountHistoryRecord record) {
		return buildKeyString(record.getId());
	}
	
	@Override
	protected void setAutoIncrementedKey(AccountHistoryRecord record, long value) {
		//record.setId((Long)value);
		record.setId(value);
	}

	//-------------------------------------------------------------------------------------
	// Persistence interface implementations
	//-------------------------------------------------------------------------------------
	@Override
	public long countAll() {
		return super.doCountAll();
	}
	
	@Override
	public AccountHistoryRecord create(AccountHistoryRecord record) {
		super.doCreateAutoIncremented(record);
		return record;
	}

	@Override
	public boolean delete(AccountHistoryRecord record) {
		return super.doDelete(record);
	}

	@Override
	public boolean deleteById(Long id) {
		AccountHistoryRecord record = newInstanceWithPrimaryKey(id);
		return super.doDelete(record);
	}

	@Override
	public boolean exists(AccountHistoryRecord record) {
		return super.doExists(record);
	}

	@Override
	public boolean exists(Long id) {
		AccountHistoryRecord record = newInstanceWithPrimaryKey(id);
		return super.doExists(record);
	}

	@Override
	public List<AccountHistoryRecord> findAll() {
		return super.doFindAll();
	}

	@Override
	public AccountHistoryRecord findById(Long id) {
        AccountHistoryRecord record = newInstanceWithPrimaryKey(id);
		return super.doFind(record);
	}

	@Override
	public AccountHistoryRecord save(AccountHistoryRecord record) {
		if (super.doExists(record)) {
			super.doUpdate(record);
		} else {
			super.doCreateAutoIncremented(record);
		}
        return record;
	}

	@Override
	public boolean update(AccountHistoryRecord record) {
		return super.doUpdate(record);	
	}
}
