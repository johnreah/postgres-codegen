package com.johnreah.accounts.springdatajpa.model.pojos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Account {
    private Long id;
    private AccountType accountType;
    private String description;
    private Double balance;
    private Date balanceTimestamp;
    private String reference;
    private Set<Customer> customers = new HashSet<Customer>(0);
    //private Set<AccountHistory> accountHistories = new HashSet<AccountHistory>(0);
}
