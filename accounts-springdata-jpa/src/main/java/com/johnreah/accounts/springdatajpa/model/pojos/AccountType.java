package com.johnreah.accounts.springdatajpa.model.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountType {
    private Long id;
    private String description;
    private String reference;
}
