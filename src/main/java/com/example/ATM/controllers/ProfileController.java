package com.example.ATM.controllers;

import com.example.ATM.dto.ProfileDto;
import com.example.ATM.services.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    private final AccountHolderService accountHolderService;

    public ProfileController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    @GetMapping("/profile")
    public String profile(ProfileDto profileDto){
        return "profile";
    }

    @PostMapping("/profile")
    public String addData(@Valid ProfileDto profileDto) {
        accountHolderService.createAccountHolder(profileDto);
        return "redirect:/";
    }
}
