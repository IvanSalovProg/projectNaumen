package com.example.ATM.services;

import com.example.ATM.dto.RegisterDto;
import com.example.ATM.model.AccountHolder;
import com.example.ATM.model.Role;
import com.example.ATM.model.User;
import com.example.ATM.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(RegisterDto user) throws Exception {
        User userFromDb = userRepository.findByLogin(user.getLogin());
        if (userFromDb != null) {
            throw new Exception("user exist");
        }

        User newUser = new User();
        newUser.setRoles(Collections.singleton(Role.USER));
        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        AccountHolder accountHolder = new AccountHolder();
        newUser.setAccountHolder(accountHolder);
        userRepository.save(newUser);
    }

    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles) {
        return roles.stream().map(
                r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User myUser = userRepository.findByLogin(login);
        return new org.springframework.security.core.userdetails.User(myUser.getLogin(), myUser.getPassword(), mapRolesToAthorities(myUser.getRoles()));

    }
}
