package com.naumen.atm.repository;

import com.naumen.atm.model.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountHolderRepository extends CrudRepository<User,Long> {
}
