package com.johnreah.accounts.springdatajpa.model.mappers;

import com.johnreah.accounts.springdatajpa.generated.AccountTypeEntity;
import com.johnreah.accounts.springdatajpa.model.pojos.AccountType;

public class AccountTypeMapper {

    public static AccountType entityToPojo(AccountTypeEntity accountTypeEntity) {
        AccountType accountType = new AccountType();
        accountType.setId(accountTypeEntity.getId());
        accountType.setDescription(accountTypeEntity.getDescription());
        accountType.setReference(accountTypeEntity.getReference());
        return accountType;
    }

    public static AccountTypeEntity pojoToEntity(AccountType accountType) {
        AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
        accountTypeEntity.setId(accountType.getId());
        accountTypeEntity.setDescription(accountType.getDescription());
        accountTypeEntity.setReference(accountType.getReference());
        return accountTypeEntity;
    }

}
