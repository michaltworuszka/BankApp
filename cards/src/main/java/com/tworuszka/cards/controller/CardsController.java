package com.tworuszka.cards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tworuszka.cards.config.CardsServiceConfig;
import com.tworuszka.cards.model.Cards;
import com.tworuszka.cards.model.Customer;
import com.tworuszka.cards.model.Properties;
import com.tworuszka.cards.repository.CardsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project cards
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class CardsController {

    private final CardsRepo cardRepo;

    private final CardsServiceConfig cardsConfig;

    @PostMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestHeader("bank-correlation-id") String correlationId,
                                       @RequestBody Customer customer) {
        log.info("getCardsDetails() method started");
        List<Cards> cards = cardRepo.findByCustomerId(customer.getCustomerId());
        log.info("getCardsDetails() method ended");
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
