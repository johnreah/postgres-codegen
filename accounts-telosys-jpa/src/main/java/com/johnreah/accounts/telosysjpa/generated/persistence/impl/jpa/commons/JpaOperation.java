/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.commons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * JPA operation interface
 * Provided by Telosys Tools for JPA testing
 *
 */
public interface JpaOperation {

	/**
	 * Executes a JPA operation using the given EntityManager
	 * @param em the EntityManager to be used
	 * @return
	 * @throws PersistenceException
	 */
	public Object execute(EntityManager em) throws PersistenceException;
	
}
