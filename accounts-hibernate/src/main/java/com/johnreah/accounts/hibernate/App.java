package com.johnreah.accounts.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;

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
