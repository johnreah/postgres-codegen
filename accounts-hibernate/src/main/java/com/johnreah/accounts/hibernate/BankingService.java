package com.johnreah.accounts.hibernate;

import javax.persistence.EntityManagerFactory;

public class BankingService {

    EntityManagerFactory entityManagerFactory;

    public BankingService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void createBankingCustomer(String firstName, String lastName, String email) {
    }
}
