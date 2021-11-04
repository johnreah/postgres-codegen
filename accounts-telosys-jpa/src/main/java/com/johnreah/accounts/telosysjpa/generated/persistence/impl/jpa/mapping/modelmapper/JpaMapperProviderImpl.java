/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.modelmapper;

import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.JpaMapper;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.mapping.JpaMapperProvider;

/**
 * Mapper provider for "ModelMapper" implementation.
 * 
 * @author Telosys
 */
public class JpaMapperProviderImpl implements JpaMapperProvider {

	@Override
	public <JPA, POJO> JpaMapper<JPA, POJO> getMapper(Class<JPA> jpaClass, Class<POJO> pojoClass) {

		return new JpaMapperImpl<>(jpaClass, pojoClass);
	}

}
