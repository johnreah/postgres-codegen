package com.johnreah.accounts.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Service {

    private EntityManagerFactory entityManagerFactory;

    public Service(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.entityManagerFactory;
    }


}
