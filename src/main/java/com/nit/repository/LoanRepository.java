package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Loans;

public interface LoanRepository extends JpaRepository<Loans, Long> {
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
