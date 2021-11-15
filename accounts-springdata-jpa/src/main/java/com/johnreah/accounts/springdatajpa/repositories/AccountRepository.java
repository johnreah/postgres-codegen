package com.johnreah.accounts.springdatajpa.repositories;

import com.johnreah.accounts.springdatajpa.generated.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
}
