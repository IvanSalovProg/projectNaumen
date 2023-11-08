package com.example.ATM.services;

import com.example.ATM.dto.ProfileDto;
import com.example.ATM.model.Account;
import com.example.ATM.model.AccountHolder;
import com.example.ATM.model.User;
import com.example.ATM.repository.AccountHolderRepository;
import com.example.ATM.repository.UserRepository;
import org.springframework.data.util.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class AccountHolderService implements AccountService {

    protected final AccountHolderRepository repository;
    protected final UserRepository userRepository;

    public AccountHolderService(AccountHolderRepository repository,
                                UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Account> getAllAccount() {
        return null;
    }

    @Override
    public void saveAccount(int countNumber, int countSum, String countName) {

    }

    @Override
    public void saveAccount(Account account) {

    }

    public List<AccountHolder> getAllAccountHolder() {
        List<AccountHolder> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().filter(account ->
                account.getName().equals(getName())).collect(Collectors.toList());
    }

    @Override
    public String getName() {
        return "HistoryData";
    }

    public List<AccountHolder> getAccountHolderByFirstName(String firstName) {
        return new ArrayList<>(repository.findByFirstName(firstName));
    }

    public List<AccountHolder> getAccountHolderByLastName(String lastName) {
        return new ArrayList<>(repository.findByLastName(lastName));
    }

    public void createAccountHolder(ProfileDto profile) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByLogin(auth.getName());
        user.getAccountHolder().setFirstName(profile.getFirstName());
        user.getAccountHolder().setLastName(profile.getLastName());
        userRepository.save(user);
    }

    public AccountHolder getAccountHolderByName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByLogin(auth.getName());
        return user.getAccountHolder();
    }

    public Pair<Boolean, Model> isFillDataForAccountHolder(Model model) {
        AccountHolder accountHolder = getAccountHolderByName();
        if (isNull(accountHolder.getFirstName()) || isNull(accountHolder.getLastName())) {
            return Pair.of(false, model.addAttribute("message", "Не заполнены данные пользователя"));
        }
        return Pair.of(true, model.addAttribute("username", accountHolder.getFirstName() + " " + accountHolder.getLastName()));
    }


}
