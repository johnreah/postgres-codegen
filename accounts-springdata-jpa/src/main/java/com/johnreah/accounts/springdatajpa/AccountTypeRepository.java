package com.johnreah.accounts.springdatajpa;

import com.johnreah.accounts.springdatajpa.generated.AccountType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountTypeRepository extends CrudRepository<AccountType, Long> {

    List<AccountType> findByReference(String reference);

}
