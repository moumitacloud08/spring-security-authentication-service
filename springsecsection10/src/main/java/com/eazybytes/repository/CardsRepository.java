package com.eazybytes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybytes.model.Cards;

public interface CardsRepository extends CrudRepository<Cards, Long>{
	List<Cards> findByCustomerId(long customerId);
}
