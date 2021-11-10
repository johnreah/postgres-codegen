package com.johnreah.accounts.hibernate;

//import com.j256.ormlite.dao.Dao;
//import com.j256.ormlite.dao.DaoManager;
//import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
//import com.j256.ormlite.support.ConnectionSource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("accounts_hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CustomerDAO customerDAO = new CustomerDAO(entityManager);

        customerDAO.findAllCustomers().stream().forEach(c -> customerDAO.delete(c));

        CustomerEntityPOJO customerEntityPOJO = new CustomerEntityPOJO();
        customerEntityPOJO.setFirstName("Hibernate");
        customerEntityPOJO.setLastName("User");
        customerEntityPOJO.setEmail("hibernate.user+" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + "@demo.com");
        customerDAO.create(customerEntityPOJO);

        BankingService bankingService = new BankingService(entityManagerFactory);
        bankingService.createBankingCustomer("John", "Reah", "john.reah+" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + "@demo.com");

        customerDAO.findAllCustomers().stream().forEach(c -> System.out.println("Customer: " + c.toString() + " " + c.getEmail()));
    }

//    private static ConnectionSource connectionSource;
//    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/accounts";
//    private static final String JDBC_USER = "postgres";
//    private static final String JDBC_PASSWORD = "postgres";

//    private static Dao<Customer, Long> customerDao;

//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//        connectionSource = new JdbcPooledConnectionSource(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//
////        TableUtils.createTableIfNotExists(connectionSource, LineEntity.class);
//
//        customerDao = DaoManager.createDao(connectionSource, Customer.class);
//
//    }

}