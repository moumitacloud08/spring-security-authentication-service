package com.eazybytes.repository;

import org.springframework.stereotype.Repository;

import com.eazybytes.model.Customer;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
	
	Optional<Customer> findByEmail(String email);

}
