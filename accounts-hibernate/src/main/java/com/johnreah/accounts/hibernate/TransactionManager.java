package com.johnreah.accounts.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TransactionManager {

    private EntityManager entityManager;

    @FunctionalInterface
    public interface DataCallable {
        void call(EntityManager entityManager) /*throws Exception*/;
    }

    public TransactionManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void runInTransaction(DataCallable callable) throws Exception {
        if (entityManager.getTransaction().isActive()) {
            try {
                System.out.println("Calling without transaction");
                callable.call(entityManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Calling in new transaction");
            this.entityManager.getTransaction().begin();
            try {
                callable.call(entityManager);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                entityManager.getTransaction().rollback();
            }
        }
    }

}
