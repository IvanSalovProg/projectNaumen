package com.example.ATM.controllers;

import com.example.ATM.services.AccountHolderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoaderController {

    private final AccountHolderService accountHolderService;

    public LoaderController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    @GetMapping("/")
    public String startPage(Model model) {
        if (accountHolderService.isFillDataForAccountHolder(model).getFirst()) {
            return "index";
        }
        return "redirect:/profile";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
