package com.johnreah.accounts.hibernate;

import javax.persistence.EntityManager;
import java.util.UUID;

public class BankingService {

    EntityManager entityManager;
    CustomerDAO customerDAO;

    public BankingService(EntityManager entityManager) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        this.entityManager = entityManager;
        this.customerDAO = new CustomerDAO(entityManager);
    }

    public void createBankingCustomer(String firstName, String lastName, String email) throws Exception {
        new TransactionManager(entityManager).runInTransaction(em -> {
            CustomerEntityPOJO customerEntityPOJO = new CustomerEntityPOJO();
            customerEntityPOJO.setFirstName(firstName);
            customerEntityPOJO.setLastName(lastName);
            customerEntityPOJO.setEmail(email);
            customerEntityPOJO.setReference("C" + UUID.randomUUID().toString().replace("-", "").substring(0, 8));
            customerDAO.create(customerEntityPOJO);
        });
    }

}
