package com.johnreah.accounts.telosysjpa;

import com.johnreah.accounts.telosysjpa.generated.data.record.CustomerRecord;
import com.johnreah.accounts.telosysjpa.generated.persistence.CustomerPersistence;
import com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.CustomerPersistenceJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("accounts_telosys_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CustomerPersistence customerPersistence = new CustomerPersistenceJpa();
        customerPersistence.findAll().stream().forEach(c -> customerPersistence.delete(c));

        CustomerRecord customerRecord = new CustomerRecord();
        customerRecord.setFirstName("John");
        customerRecord.setLastName("Reah");
        customerRecord.setEmail("john.reah+" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + "@johnreah.com");

        customerPersistence.create(customerRecord);

        List<CustomerRecord> customerList = customerPersistence.findAll();
        customerList.stream().forEach(c -> System.out.println("Customer: " + c.toString()));
    }
}
