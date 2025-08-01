package com.cardservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardDto {
	private String cardType;
	private String accountNumber;
    private String customerName;
    private double creditLimit;
    private LocalDate expiryDate;
    
    
}
