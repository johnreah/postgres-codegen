package com.johnreah.accounts.springdatajpa.repositories;

import com.johnreah.accounts.springdatajpa.generated.AccountTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountTypeRepository extends CrudRepository<AccountTypeEntity, Long> {

    List<AccountTypeEntity> findByReference(String reference);

}
