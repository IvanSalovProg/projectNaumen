package com.example.ATM.services;

import com.example.ATM.model.AccountHolder;
import com.example.ATM.model.Transactions;
import com.example.ATM.repository.AccountHolderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountHolderService{

    protected final AccountHolderRepository repository;

    public AccountHolderService(AccountHolderRepository repository) {
        this.repository = repository;
    }

    public List<AccountHolder> getAllAccountHolder() {
        List<AccountHolder> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public List<AccountHolder> getAccountHolderByFirstName(String firstName) {
        return new ArrayList<>(repository.findByFirstName(firstName));
    }

    public List<AccountHolder> getAccountHolderByLastName(String lastName) {
        return new ArrayList<>(repository.findByLastName(lastName));
    }

    public String getName() {
        return null;
    }
}
