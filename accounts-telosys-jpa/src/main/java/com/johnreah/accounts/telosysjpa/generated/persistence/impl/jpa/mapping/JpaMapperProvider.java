/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping;

/**
 * Mapper provider 
 *
 * @author Telosys
 * 
 */
public interface JpaMapperProvider {

	/**
	 * Returns the current mapper instance
	 * @return
	 */
	public <JPA,POJO> JpaMapper<JPA,POJO> getMapper(Class<JPA> jpaClass, Class<POJO> pojoClass) ;
}
