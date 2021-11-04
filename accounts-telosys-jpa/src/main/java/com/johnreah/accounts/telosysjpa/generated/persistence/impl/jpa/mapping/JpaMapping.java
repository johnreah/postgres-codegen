/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping;

// Choose you mapper implementation here
// import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.modelmapper.JpaMapperProviderImpl;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.manual.JpaMapperProviderImpl;

/**
 * Use this class to choose your prefered mapping implementation 
 *
 * @author Telosys
 *
 */
public class JpaMapping {

	/**
	 * Current mapper provider
	 */
	private static JpaMapperProvider mapperProvider = new JpaMapperProviderImpl() ;
	
	/**
	 * Set the current mapper provider
	 * @param provider
	 */
	protected static void setMapperProvider(JpaMapperProvider provider) {
		mapperProvider = provider ;
	}
	
	/**
	 * Returns the current mapper provider
	 * @return
	 */
	public static JpaMapperProvider getMapperProvider() {
		return mapperProvider;
	}
}
