package com.johnreah.accounts.springdatajpa;

import com.johnreah.accounts.springdatajpa.generated.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
