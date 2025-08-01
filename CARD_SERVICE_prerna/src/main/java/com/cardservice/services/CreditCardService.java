package com.cardservice.services;

import java.util.List;

import com.cardservice.dto.CreditCardDto;
import com.cardservice.models.CreditCard;

public interface CreditCardService {
	List<CreditCard> getAllCards();
	CreditCard issueCard(CreditCardDto dto);
    CreditCard getCardByCardId(Long id);
    List<CreditCard> getCardsByAccount(String accountNumber);
    CreditCard updateCard(Long id, CreditCardDto dto);
    public String deleteCardById(Long cardId);
}
