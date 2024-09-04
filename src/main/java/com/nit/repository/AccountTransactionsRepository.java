package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.AccountTransactions;

public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, Long>{
	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
