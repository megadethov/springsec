package com.example.demo.controller;

import com.example.demo.model.Cards;
import com.example.demo.model.Customer;
import com.example.demo.repository.CardsRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CardsController {

    private final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @PostMapping("/my-cards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getId());
        if (CollectionUtils.isEmpty(cards)) {
            return Collections.emptyList();
        } else {
            return cards;
        }
    }
}
