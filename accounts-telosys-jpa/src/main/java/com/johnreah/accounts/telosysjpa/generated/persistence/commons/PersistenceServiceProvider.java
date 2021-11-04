/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */

package com.johnreah.accounts.telosysjpa.generated.persistence.commons;

import com.johnreah.accounts.telosysjpa.generated.commons.ImplementationProvider;

/**
 * Persistence service provider 
 * 
 * @author Telosys
 *
 */
public class PersistenceServiceProvider {

	private final static ImplementationProvider provider = new ImplementationProvider(PersistenceServicePattern.PATTERN);
	
	/**
	 * Returns the persistence service implementing the given interface
	 * @param interfaceClass
	 * @return
	 */
	public final static <T> T getService(Class<T> interfaceClass) {
		return provider.getServiceInstance(interfaceClass);
	}
	
}
