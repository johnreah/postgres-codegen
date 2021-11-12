package com.johnreah.accounts.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Service {

    private final EntityManager entityManager;

    public Service(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }


}
