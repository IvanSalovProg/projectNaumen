package com.example.ATM.repository;

import com.example.ATM.model.AccountHolder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountHolderRepository extends CrudRepository<AccountHolder,Long> {
    List<AccountHolder> findByFirstName(String firstName);
    List<AccountHolder> findByLastName(String lastName);
}
