package com.cardservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardservice.models.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long>{
	List<CreditCard> findByAccountNumber(String accountNumber);
}
