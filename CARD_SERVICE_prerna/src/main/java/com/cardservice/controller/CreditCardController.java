package com.cardservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardservice.dto.CreditCardDto;
import com.cardservice.models.CreditCard;
import com.cardservice.services.CreditCardService;



@RestController
@RequestMapping("/cards")
public class CreditCardController {

    @Autowired
    private CreditCardService service;

    //Get all cards
    @GetMapping
    public ResponseEntity<List<CreditCard>> getAllCards() {
        List<CreditCard> cards = service.getAllCards();
        return ResponseEntity.ok(cards);
    }

    //Create a new card using DTO
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreditCardDto dto) {
        String accNum = dto.getAccountNumber();
        Map<String, String> error = new HashMap<>();

        if (!accNum.matches("\\d+")) {
            error.put("accountNumber", "Account number must contain only digits.");
        } else if (accNum.length() != 12) {
            error.put("accountNumber", "Account number must be exactly 12 digits long.");
        }

        if (!error.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        CreditCard savedCard = service.issueCard(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard);
    }



    //Get card by ID
    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getById(@PathVariable Long id) {
        CreditCard card = service.getCardByCardId(id);
        return ResponseEntity.ok(card);
    }

    //Get cards by account number (String)
    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<List<CreditCard>> getByAccount(@PathVariable String accountNumber) {
        List<CreditCard> cards = service.getCardsByAccount(accountNumber);
        return ResponseEntity.ok(cards);
    }

    //Update card by ID using DTO
    @PutMapping("/{id}")
    public ResponseEntity<CreditCard> update(@PathVariable Long id, @RequestBody CreditCardDto dto) {
        CreditCard updatedCard = service.updateCard(id, dto);
        return ResponseEntity.ok(updatedCard);
    }

    //Delete card by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String message = service.deleteCardById(id); 
        return ResponseEntity.ok(message);           
    }

}













//package com.cardservice.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cardservice.dto.CreditCardDto;
//import com.cardservice.models.CreditCard;
//import com.cardservice.services.CreditCardService;
//
//
//@RestController
//@RequestMapping("/api/cards")
//public class CreditCardController {
//	
//	@Autowired
//    private CreditCardService service;
//	
//	@GetMapping
//	public List<CreditCard> getAllCards() {
//	    return service.getAllCards();
//	}
//
//
//    @PostMapping
//    public CreditCard create(@RequestBody CreditCardDto dto) {
//        return service.issueCard(dto);
//    }
//
//    @GetMapping("/{id}")
//    public CreditCard getById(@PathVariable Long id) {
//        return service.getCard(id);
//    }
//
//    @GetMapping("/account/{accountNumber}")
//    public List<CreditCard> getByAccount(@PathVariable String accountNumber) {
//        return service.getCardsByAccount(accountNumber);
//    }
//
//    @PutMapping("/{id}")
//    public CreditCard update(@PathVariable Long id, @RequestBody CreditCardDto dto) {
//        return service.updateCard(id, dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        service.deleteCard(id);
//    }
//}
