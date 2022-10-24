package com.tworuszka.loans.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tworuszka.loans.config.LoansServiceConfig;
import com.tworuszka.loans.model.Customer;
import com.tworuszka.loans.model.Loans;
import com.tworuszka.loans.model.Properties;
import com.tworuszka.loans.repository.LoansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project loans
 */

@RestController
public class LoansController {

    @Autowired
    private LoansRepo loansRepo;

    @Autowired
    private LoansServiceConfig loadConfig;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails (@RequestHeader("bank-correlation-id") String correlationId, @RequestBody Customer customer) {
        List<Loans> loans = loansRepo.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (loans!= null) {
            return loans;
        } else {
            return null;
        }
    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loadConfig.getMsg(),
                loadConfig.getBuildVersion(),
                loadConfig.getMailDetails(),
                loadConfig.getActiveBranches());
        return ow.writeValueAsString(properties);
    }
}
