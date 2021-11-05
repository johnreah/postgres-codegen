package com.johnreah.accounts.hibernate;

import com.johnreah.accounts.hibernate.generated.Customer;
import com.johnreah.accounts.hibernate.generated.CustomerHome;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("accounts_hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CustomerDAO customerDAO = new CustomerDAO(entityManager);

        customerDAO.findAllCustomers().stream().forEach(c -> customerDAO.delete(c));

        customerDAO.createNewCustomer("Hibernate", "User", "hibernate.user+" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + "@org.demo.com");

        customerDAO.findAllCustomers().stream().forEach(c -> System.out.println("Customer: " + c.toString() + " " + c.getEmail()));
    }

}