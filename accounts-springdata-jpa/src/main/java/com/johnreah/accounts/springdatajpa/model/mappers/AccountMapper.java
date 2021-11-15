package com.johnreah.accounts.springdatajpa.model.mappers;

import com.johnreah.accounts.springdatajpa.generated.AccountEntity;
import com.johnreah.accounts.springdatajpa.model.pojos.Account;

public class AccountMapper {

        public static Account entityToPojo(AccountEntity accountEntity) {
            Account account = new Account();
            account.setId(accountEntity.getId());
            account.setAccountType(AccountTypeMapper.entityToPojo(accountEntity.getAccountTypeEntity()));
            return account;
        }

        public static AccountEntity pojoToEntity(Account account) {
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setId(account.getId());
            return accountEntity;
        }

}
