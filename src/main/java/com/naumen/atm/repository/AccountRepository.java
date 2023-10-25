package com.naumen.atm.repository;

import com.naumen.atm.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {

}
