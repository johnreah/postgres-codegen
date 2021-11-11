package com.johnreah.accounts.hibernate;

import com.johnreah.accounts.hibernate.generated.Customer;

public class CustomerMapper {

    public static CustomerEntityPOJO entityToPOJO(Customer customer) {
        CustomerEntityPOJO customerEntityPOJO = new CustomerEntityPOJO();
        customerEntityPOJO.setId(customer.getId());
        customerEntityPOJO.setFirstName(customer.getFirstName());
        customerEntityPOJO.setLastName(customer.getLastName());
        customerEntityPOJO.setEmail(customer.getEmail());
        customerEntityPOJO.setReference(customer.getReference());
        return customerEntityPOJO;
    }

    public static Customer pojoToEntity(CustomerEntityPOJO customerEntityPOJO) {
        Customer customer = new Customer();
        customer.setId(customerEntityPOJO.getId());
        customer.setFirstName(customerEntityPOJO.getFirstName());
        customer.setLastName(customerEntityPOJO.getLastName());
        customer.setEmail(customerEntityPOJO.getEmail());
        customer.setReference(customerEntityPOJO.getReference());
        return customer;
    }

}
