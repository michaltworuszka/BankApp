package com.tworuszka.accounts.service.clients;

import com.tworuszka.accounts.model.Customer;
import com.tworuszka.accounts.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project Bank App
 */
@FeignClient("loans")
public interface LoansFeignClient {

    @PostMapping(value = "/myLoans", consumes = "application/json")
    List<Loans> getLoansDetails (@RequestBody Customer customer);
}
