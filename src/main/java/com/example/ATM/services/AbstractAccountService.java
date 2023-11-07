package com.example.ATM.services;

import com.example.ATM.model.Account;
import com.example.ATM.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbstractAccountService implements AccountService {

    protected final AccountRepository repository;


    public AbstractAccountService(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Account> getAllAccount() {
        List<Account> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().filter(account ->
                account.getName().equals(getName())).collect(Collectors.toList());
    }


    @Override
    public void saveAccount(int countNumber, int countSum, String countName) {

        Account newAccount = new Account(countNumber, countSum, countName);

        repository.save(newAccount);
    }

    @Override
    public String getName() {
        return "HistoryData";
    }

    @Override
    public void saveAccount(Account account) {
        repository.save(account);
    }


}
