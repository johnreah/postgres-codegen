package com.johnreah.accounts.springdatajpa;

import com.johnreah.accounts.springdatajpa.generated.AccountTypeEntity;
import com.johnreah.accounts.springdatajpa.services.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    BankingService bankingService;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            bankingService.deleteEverything();
            System.out.println("Customers at start: " + bankingService.countCustomers());
            System.out.println("Accounts at start: " + bankingService.countAccounts());
            System.out.println("AccountTypes at start: " + bankingService.countAccountTypes());

            bankingService.createAccountType("Current account", "CURRENT");
            bankingService.createAccountType("Deposit account", "DEPOSIT");
            bankingService.listAccountTypes().forEach(accountType -> System.out.println(accountType.getDescription()));

            try {
                bankingService.createBankingCustomerWithAccountsTransactional("John", "Reah", "john.reah+" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + "@demo.com");
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

            System.out.println("Customers at end: " + bankingService.countCustomers());
            System.out.println("Accounts at end: " + bankingService.countAccounts());

            bankingService.listCustomers().forEach(c -> System.out.println(c.getEmail()));

        };
    }
}
