package com.naumen.controller;

import com.naumen.model.Account;
import com.naumen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/allAccount")
    @ResponseBody
    public List<Account> getAccount() {

        return accountService.getAllAccount();
    }


    @GetMapping("/addAccount/{countNumber}/{countSum}/{countName}")
    @ResponseBody
    public List<Account> addAccount(@PathVariable int countNumber, @PathVariable int countSum,
                                    @PathVariable String countName) {
        Account newAccount = new Account(countNumber, countSum, countName);
        newAccount.setCountName(countName);
        accountService.saveAccount(newAccount);
        return getAccount();
    }

}
