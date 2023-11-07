package com.example.ATM.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterDto {

    @NotBlank(message = "Неверный формат логина")
    @Size(min=3, max = 300)
    private String login;
    @NotBlank(message = "Неверный формат пароля")
    @Size(min=3, max = 300)
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
