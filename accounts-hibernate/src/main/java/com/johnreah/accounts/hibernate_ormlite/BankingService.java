package com.johnreah.accounts.hibernate_ormlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.johnreah.accounts.hibernate.generated.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BankingService {

    private ConnectionSource connectionSource;
    private Dao<Customer, Long> customerDao;
    private Dao<AccountType, Long> accountTypeDao;
    private Dao<Account, Long> accountDao;
    private Dao<LinkCustomerAccount, LinkCustomerAccountId> linkCustomerAccountDao;

    public BankingService(ConnectionSource connectionSource) throws SQLException {
        this.connectionSource = connectionSource;
        this.customerDao = DaoManager.createDao(connectionSource, Customer.class);
        this.accountTypeDao = DaoManager.createDao(connectionSource, AccountType.class);
        this.accountDao = DaoManager.createDao(connectionSource, Account.class);
        this.linkCustomerAccountDao = DaoManager.createDao(connectionSource, LinkCustomerAccount.class);
    }

    public void createBankingCustomer(String firstName, String lastName, String email) throws SQLException {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setReference("C" + UUID.randomUUID().toString());
        customerDao.create(customer);
    }

    public void createBankingCustomerWithAccounts(String firstName, String lastName, String email) throws SQLException {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setReference("C" + UUID.randomUUID().toString());

        AccountType accountTypeCurrent = accountTypeDao.queryForEq("reference", "CURRENT").get(0);
        AccountType accountTypeDeposit = accountTypeDao.queryForEq("reference", "DEPOSIT").get(0);
        System.out.println("Current account type: " + accountTypeCurrent.getDescription());
        System.out.println("Deposit account type: " + accountTypeDeposit.getDescription());

        Account currentAccount = new Account();
        currentAccount.setDescription(String.format("This is %s %s's current account", firstName, lastName));
        currentAccount.setBalance(0.0);
        currentAccount.setAccountType(accountTypeCurrent);
        currentAccount.setBalanceTimestamp(Date.from(Instant.now()));

        Account depositAccount = new Account();
        depositAccount.setDescription(String.format("This is %s %s's deposit account", firstName, lastName));
        depositAccount.setBalance(0.0);
        depositAccount.setAccountType(accountTypeDeposit);
        depositAccount.setBalanceTimestamp(Date.from(Instant.now()));

        LinkCustomerAccount linkCustomerAccount = new LinkCustomerAccount();
        linkCustomerAccount.setCustomer(customer);
        linkCustomerAccount.setAccount(currentAccount);

        LinkCustomerAccount linkCustomerAccountD = new LinkCustomerAccount();
        linkCustomerAccountD.setCustomer(customer);
        linkCustomerAccountD.setAccount(depositAccount);

        try {
            new TransactionManager(connectionSource).callInTransaction(() -> {
                accountDao.create(currentAccount);
                accountDao.create(depositAccount);
                customerDao.create(customer);
                linkCustomerAccountDao.create(linkCustomerAccount);
//                customerDao.create(customer); // boom - causes rollback
                linkCustomerAccountDao.create(linkCustomerAccountD);
                return null;
            });
        } catch (Exception e) {
            System.out.println("Exception caught during transaction: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createAccountType(String description, String reference) throws SQLException {
        AccountType accountType = new AccountType();
        accountType.setDescription(description);
        accountType.setReference(reference);
        accountTypeDao.create(accountType);
    }

    public void createAccount() {

    }

    public void deleteEverything() throws SQLException {
        linkCustomerAccountDao.deleteBuilder().delete();
        customerDao.deleteBuilder().delete();
        accountDao.deleteBuilder().delete();
        accountTypeDao.deleteBuilder().delete();
    }

    public long countCustomers() throws SQLException {
        return customerDao.countOf();
    }

    public long countAccounts() throws SQLException {
        return accountDao.countOf();
    }

    public List<Customer> listCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerDao.forEach(customerList::add);
        return customerList;
    }

    public List<AccountType> listAccountTypes() {
        List<AccountType> accountTypeList = new ArrayList<>();
        accountTypeDao.forEach(accountTypeList::add);
        return accountTypeList;
    }

}
