package com.johnreah.accounts.springdatajpa.services;

import com.johnreah.accounts.springdatajpa.generated.AccountEntity;
import com.johnreah.accounts.springdatajpa.generated.AccountTypeEntity;
import com.johnreah.accounts.springdatajpa.generated.CustomerEntity;
import com.johnreah.accounts.springdatajpa.model.mappers.AccountMapper;
import com.johnreah.accounts.springdatajpa.model.mappers.AccountTypeMapper;
import com.johnreah.accounts.springdatajpa.model.mappers.CustomerMapper;
import com.johnreah.accounts.springdatajpa.model.pojos.Account;
import com.johnreah.accounts.springdatajpa.model.pojos.AccountType;
import com.johnreah.accounts.springdatajpa.model.pojos.Customer;
import com.johnreah.accounts.springdatajpa.repositories.AccountRepository;
import com.johnreah.accounts.springdatajpa.repositories.AccountTypeRepository;
import com.johnreah.accounts.springdatajpa.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountTypeRepository accountTypeRepository;

    public void createBankingCustomer(String firstName, String lastName, String email) throws SQLException {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(firstName);
        customerEntity.setLastName(lastName);
        customerEntity.setEmail(email);
        customerEntity.setReference("C" + UUID.randomUUID().toString());
        customerRepository.save(customerEntity);
    }

    @Transactional
    public void createBankingCustomerWithAccountsTransactional(String firstName, String lastName, String email) throws SQLException {
        createBankingCustomerWithAccounts(firstName, lastName, email);
    }

    @Transactional(Transactional.TxType.NEVER)
    public void createBankingCustomerWithAccountsNonTransactional(String firstName, String lastName, String email) throws SQLException {
        createBankingCustomerWithAccounts(firstName, lastName, email);
    }

    private void createBankingCustomerWithAccounts(String firstName, String lastName, String email) throws SQLException {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(firstName);
        customerEntity.setLastName(lastName);
        customerEntity.setEmail(email);
        customerEntity.setReference("C" + UUID.randomUUID().toString());

        AccountTypeEntity accountTypeCurrent = accountTypeRepository.findByReference("CURRENT").get(0);
        AccountTypeEntity accountTypeDeposit = accountTypeRepository.findByReference("DEPOSIT").get(0);

        AccountEntity currentAccount = new AccountEntity();
        currentAccount.setDescription(String.format("This is %s %s's current account", firstName, lastName));
        currentAccount.setBalance(0.0);
        currentAccount.setAccountTypeEntity(accountTypeCurrent);
        currentAccount.setBalanceTimestamp(Date.from(Instant.now()));

        AccountEntity depositAccount = new AccountEntity();
        depositAccount.setDescription(String.format("This is %s %s's deposit account", firstName, lastName));
        depositAccount.setBalance(0.0);
        depositAccount.setAccountTypeEntity(accountTypeDeposit);
        depositAccount.setBalanceTimestamp(Date.from(Instant.now()));

        customerEntity.getAccountEntities().add(currentAccount);
        customerEntity.getAccountEntities().add(depositAccount);
        accountRepository.save(currentAccount);
        accountRepository.save(depositAccount);
        customerRepository.save(customerEntity);

        CustomerEntity duplicateCustomerEntity = new CustomerEntity();
        duplicateCustomerEntity.setFirstName(customerEntity.getFirstName());
        duplicateCustomerEntity.setLastName(customerEntity.getLastName());
        duplicateCustomerEntity.setEmail(customerEntity.getEmail());
        customerRepository.save(duplicateCustomerEntity);
    }

    public void createAccountType(String description, String reference) throws SQLException {
        AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
        accountTypeEntity.setDescription(description);
        accountTypeEntity.setReference(reference);
        accountTypeRepository.save(accountTypeEntity);
    }

    public void deleteEverything() throws SQLException {
        accountRepository.deleteAll();
        customerRepository.deleteAll();
        accountTypeRepository.deleteAll();
    }

    public long countCustomers() throws SQLException {
        return customerRepository.count();
    }

    public long countAccounts() throws SQLException {
        return accountRepository.count();
    }

    public long countAccountTypes() throws SQLException {
        return accountTypeRepository.count();
    }

    public List<Customer> listCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customerEntity -> customerList.add(CustomerMapper.entityToPojo(customerEntity)));
        return customerList;
    }

    public List<Account> listAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().forEach(accountEntity -> accountList.add(AccountMapper.entityToPojo(accountEntity)));
        return accountList;
    }

    public List<AccountType> listAccountTypes() {
        List<AccountType> accountTypeList = new ArrayList<>();
        accountTypeRepository.findAll().forEach(accountTypeEntity -> accountTypeList.add(AccountTypeMapper.entityToPojo(accountTypeEntity)));
        return accountTypeList;
    }

}
