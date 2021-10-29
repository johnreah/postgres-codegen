package com.johnreah.accounts.netbeans;


import com.johnreah.accounts.netbeans.generated.Customer;
import com.johnreah.accounts.netbeans.generated.CustomerJpaController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[]args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("accounts_netbeans");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Reah");
        customer.setEmail("john.reah+" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + "@johnreah.com");

        CustomerJpaController customerJpaController = new CustomerJpaController(entityManagerFactory);
        customerJpaController.create(customer);

        List<Customer> customerList = customerJpaController.findCustomerEntities();
        customerList.stream().forEach(c -> System.out.println("Customer: " + c.toString()));
    }

}
