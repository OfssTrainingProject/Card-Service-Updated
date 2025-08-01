package com.cardservice.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardId;
	
	private String cardNumber;
	private String cardType;
	private String accountNumber;

    private String customerName;
    private double creditLimit;
    private double currentUsage;
    private String status;
    private LocalDate issueDate;
    private LocalDate expiryDate;
}
