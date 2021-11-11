package com.johnreah.accounts.hibernate;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.johnreah.accounts.hibernate.generated.Customer;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class App_ORMLite {

    private static ConnectionSource connectionSource;
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/accounts_hibernate";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";

    private static Dao<Customer, Long> customerDao;

    public static void main(String[] args) throws Throwable {
        Class.forName("org.postgresql.Driver");

        connectionSource = new JdbcPooledConnectionSource(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        customerDao = DaoManager.createDao(connectionSource, Customer.class);
        customerDao.forEach(c -> {
            try {
                customerDao.delete(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        System.out.println("Count at start: " + customerDao.countOf());

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Reah");
        customer.setEmail("john.reah+" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + "@demo.com");
        customer.setReference("C" + UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        customerDao.create(customer);
        try {
            new TransactionManager(connectionSource).callInTransaction(() -> {
                customer.setLastName(customer.getLastName() + "x");
                customerDao.create(customer);
                customer.setLastName(customer.getLastName() + "x");
                customerDao.create(customer);
                System.out.println("Count within transaction: " + customerDao.countOf());
                customerDao.create(customer); //duplicate
                return 0;
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Thread.sleep(500);
        System.out.println("Count at end: " + customerDao.countOf());
        customerDao.forEach(c -> System.out.println(c.getEmail()));
    }

}