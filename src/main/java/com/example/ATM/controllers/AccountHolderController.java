package com.example.ATM.controllers;

import com.example.ATM.model.AccountHolder;
import com.example.ATM.model.Transactions;
import com.example.ATM.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


public class AccountHolderController {
    private final AccountHolderService accountHolderService;
    @Autowired
    public AccountHolderController(AccountHolderService accountHolderService){
        this.accountHolderService = accountHolderService;
    }

    @GetMapping("/allAccountHolders")
    @ResponseBody
    public List<AccountHolder> getAccountHolders(){
        return accountHolderService.getAllAccountHolder();
    }

    @GetMapping("/allAccountHolders/{firstName}")
    @ResponseBody
    public List<AccountHolder> getAccountHoldersByFirstName(@PathVariable String firstName){
        return accountHolderService.getAccountHolderByFirstName(firstName);
    }

    @GetMapping("/allAccountHolders/{lastName}")
    @ResponseBody
    public List<AccountHolder> getAccountHoldersByLastName(@PathVariable String lastName){
        return accountHolderService.getAccountHolderByLastName(lastName);
    }

}
