package com.tworuszka.cards.controller;

import com.tworuszka.cards.model.Cards;
import com.tworuszka.cards.model.Customer;
import com.tworuszka.cards.repository.CardsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project cards
 */

@RestController
public class CardsController {

    @Autowired
    private CardsRepo cardRepo;

    @PostMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestBody Customer customer) {
        List<Cards> cards = cardRepo.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }

}
