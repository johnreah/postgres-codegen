package com.johnreah.accounts.springdatajpa;

import com.johnreah.accounts.springdatajpa.generated.Account;
import com.johnreah.accounts.springdatajpa.generated.AccountType;
import com.johnreah.accounts.springdatajpa.generated.Customer;
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
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setReference("C" + UUID.randomUUID().toString());
        customerRepository.save(customer);
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
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setReference("C" + UUID.randomUUID().toString());

        AccountType accountTypeCurrent = accountTypeRepository.findByReference("CURRENT").get(0);
        AccountType accountTypeDeposit = accountTypeRepository.findByReference("DEPOSIT").get(0);

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

        customer.getAccounts().add(currentAccount);
        customer.getAccounts().add(depositAccount);
        accountRepository.save(currentAccount);
        accountRepository.save(depositAccount);
        customerRepository.save(customer);

        Customer duplicateCustomer = new Customer();
        duplicateCustomer.setFirstName(customer.getFirstName());
        duplicateCustomer.setLastName(customer.getLastName());
        duplicateCustomer.setEmail(customer.getEmail());
        customerRepository.save(duplicateCustomer);
    }

    public void createAccountType(String description, String reference) throws SQLException {
        AccountType accountType = new AccountType();
        accountType.setDescription(description);
        accountType.setReference(reference);
        accountTypeRepository.save(accountType);
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
        customerRepository.findAll().forEach(customerList::add);
        return customerList;
    }

    public List<Account> listAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().forEach(accountList::add);
        return accountList;
    }

    public List<AccountType> listAccountTypes() {
        List<AccountType> accountTypeList = new ArrayList<>();
        accountTypeRepository.findAll().forEach(accountTypeList::add);
        return accountTypeList;
    }

}
