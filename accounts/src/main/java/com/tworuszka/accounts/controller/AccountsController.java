package com.tworuszka.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tworuszka.accounts.config.AccountsServiceConfig;
import com.tworuszka.accounts.model.Accounts;
import com.tworuszka.accounts.model.Customer;
import com.tworuszka.accounts.model.Properties;
import com.tworuszka.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michał Tworuszka
 * @project accounts
 */
@RestController
public class AccountsController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountsServiceConfig accountsConfig;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId());
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

    @GetMapping("/accounts/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountsConfig.getMsg(),
                accountsConfig.getBuildVersion(),
                accountsConfig.getMailDetails(),
                accountsConfig.getActiveBranches());
        return ow.writeValueAsString(properties);
    }
}
