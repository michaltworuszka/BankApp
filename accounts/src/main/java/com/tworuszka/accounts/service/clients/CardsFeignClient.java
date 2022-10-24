package com.tworuszka.accounts.service.clients;

import com.tworuszka.accounts.model.Cards;
import com.tworuszka.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project Bank App
 */
@FeignClient("cards")
public interface CardsFeignClient {

    @PostMapping(value ="/myCards", consumes = "application/json")
    List<Cards> getCardsDetails(@RequestHeader("bank-correlation-id") String correlationId, @RequestBody Customer customer);
}
