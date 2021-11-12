package com.johnreah.accounts.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Example of a transactional service that can invoke multiple DAOs within a single transaction using code
 * for Entities and DAOs generated by Hibernate Tools. Because JPA transactions are handled by EntityManagers,
 * a common EntityManager object is shared by all services and DAOs. A home-brew TransactionManager is used to
 * ensure that when transactional method calls are nested only the outermost call manages the transaction.
 */
public class App {

    public static void main(String[] args) throws Exception {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("accounts_hibernate")
                .createEntityManager();

        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        customerDAO.findAll().stream().forEach(customerDAO::destroy);

        BankingService bankingService = new BankingService(entityManager);
        bankingService.createBankingCustomer("John", "Reah", "john.reah+" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + "@demo.com");

        System.out.println("Count: " + customerDAO.count());
        customerDAO.findAll().stream().forEach(c -> System.out.println("Customer: " + c.toString() + " " + c.getEmail()));
    }

}
