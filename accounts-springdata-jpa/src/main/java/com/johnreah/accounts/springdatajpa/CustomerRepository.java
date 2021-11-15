package com.johnreah.accounts.springdatajpa;

import com.johnreah.accounts.springdatajpa.generated.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
