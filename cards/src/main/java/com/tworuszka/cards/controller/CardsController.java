package com.tworuszka.cards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tworuszka.cards.config.CardsServiceConfig;
import com.tworuszka.cards.model.Cards;
import com.tworuszka.cards.model.Customer;
import com.tworuszka.cards.model.Properties;
import com.tworuszka.cards.repository.CardsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @Autowired
    private CardsServiceConfig cardsConfig;

    @PostMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestBody Customer customer) {
        List<Cards> cards = cardRepo.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }

    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsConfig.getMsg(),
                cardsConfig.getBuildVersion(),
                cardsConfig.getMailDetails(),
                cardsConfig.getActiveBranches());
        return ow.writeValueAsString(properties);
    }
}
