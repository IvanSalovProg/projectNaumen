package com.naumen.atm.services;

import com.naumen.atm.model.Account;
import com.naumen.atm.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository repository) {
        this.accountRepository = repository;
    }


    public List<Account> getAllAccount() {
        return (List<Account>) accountRepository.findAll();
    }

    public void saveAccount(int countNumber, int countSum, String countName) {
        Account newAccount = new Account(countNumber, countSum, countName);
        accountRepository.save(newAccount);
    }


    public void saveAccount(Account account) {
        accountRepository.save(account);
    }


}
