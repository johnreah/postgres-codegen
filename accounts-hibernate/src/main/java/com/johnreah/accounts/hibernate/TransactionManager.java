package com.johnreah.accounts.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TransactionManager {

    private static TransactionManager singletonTransactionManager;

    private EntityManager entityManager;

    public synchronized static TransactionManager getInstance(EntityManagerFactory entityManagerFactory) {
        if (singletonTransactionManager == null) {
            singletonTransactionManager = new TransactionManager(entityManagerFactory);
        }
        return singletonTransactionManager;
    }

    private TransactionManager(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void runInTransaction(Runnable runnable) {
        this.entityManager.getTransaction().begin();
        try {
            runnable.run();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
