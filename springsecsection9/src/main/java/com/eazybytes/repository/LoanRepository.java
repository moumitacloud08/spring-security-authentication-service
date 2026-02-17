package com.eazybytes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybytes.model.Loans;

public interface LoanRepository extends CrudRepository<Loans, Long>{
	List<Loans> findByCustomerIdOrderByStartDtDesc(long customerId);

}
