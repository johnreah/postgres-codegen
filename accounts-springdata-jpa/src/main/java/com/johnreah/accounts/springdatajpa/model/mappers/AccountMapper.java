package com.johnreah.accounts.springdatajpa.model.mappers;

import com.johnreah.accounts.springdatajpa.generated.AccountEntity;
import com.johnreah.accounts.springdatajpa.model.pojos.Account;

public class AccountMapper {

    public static Account entityToPojo(AccountEntity accountEntity) {
        Account account = new Account();

        account.setId(accountEntity.getId());
        account.setAccountType(AccountTypeMapper.entityToPojo(accountEntity.getAccountTypeEntity()));
        account.setDescription(accountEntity.getDescription());
        account.setBalance(accountEntity.getBalance());
        account.setBalanceTimestamp(accountEntity.getBalanceTimestamp());
        account.setReference(accountEntity.getReference());
        //CustomerEntities
        //AccountHistoryEntities

        return account;
    }

    public static AccountEntity pojoToEntity(Account account) {
        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setId(account.getId());
        accountEntity.setAccountTypeEntity(AccountTypeMapper.pojoToEntity(account.getAccountType()));
        accountEntity.setDescription(account.getDescription());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setBalanceTimestamp(account.getBalanceTimestamp());
        accountEntity.setReference(account.getReference());
        //CustomerEntities
        //AccountHistoryEntities

        return accountEntity;
    }

}
