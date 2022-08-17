package com.example.security.controllers;

import java.util.List;

import com.example.security.models.Cards;
import com.example.security.models.Customer;
import com.example.security.repo.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CardsController {
	
	@Autowired
	private CardsRepository cardsRepository;
	
	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		List<Cards> cards = cardsRepository.findByCustomerId(Math.toIntExact(customer.getId()));
		if (cards != null ) {
			return cards;
		}else {
			return null;
		}
	}

}
