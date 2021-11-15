package com.johnreah.accounts.springdatajpa.model.mappers;

import com.johnreah.accounts.springdatajpa.generated.CustomerEntity;
import com.johnreah.accounts.springdatajpa.model.pojos.Customer;

public class CustomerMapper {

        public static Customer entityToPojo(CustomerEntity customerEntity) {
            Customer customer = new Customer();
            customer.setId(customerEntity.getId());
            customer.setFirstName(customerEntity.getFirstName());
            customer.setLastName(customerEntity.getLastName());
            customer.setEmail(customerEntity.getEmail());
            customer.setReference(customerEntity.getReference());
            return customer;
        }

        public static CustomerEntity pojoToEntity(Customer customer) {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setId(customer.getId());
            customerEntity.setFirstName(customer.getFirstName());
            customerEntity.setLastName(customer.getLastName());
            customerEntity.setEmail(customer.getEmail());
            customerEntity.setReference(customer.getReference());
            return customerEntity;
        }

}
