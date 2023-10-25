package com.naumen.atm.repository;

import com.naumen.atm.model.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<Transactions,Long> {
}
