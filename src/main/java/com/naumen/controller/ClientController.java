package com.naumen.controller;

import com.naumen.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @GetMapping("/registration")
    public String registration(@ModelAttribute("client") Client client) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addClient(@ModelAttribute("client") Client client) {
        System.out.println(client.getFirstName());
        return "menu";
    }
}
