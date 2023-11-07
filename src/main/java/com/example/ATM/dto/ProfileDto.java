package com.example.ATM.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProfileDto {

    @NotBlank(message = "Неверный формат имени")
    @Size(min=3, max = 300)
    private String firstName;
    @NotBlank(message = "Неверный формат фамилии")
    @Size(min=3, max = 300)
    private String lastName;

    public ProfileDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ProfileDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ProfileFormDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
