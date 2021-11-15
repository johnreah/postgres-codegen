package com.johnreah.accounts.springdatajpa.repositories;

import com.johnreah.accounts.springdatajpa.generated.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
}
