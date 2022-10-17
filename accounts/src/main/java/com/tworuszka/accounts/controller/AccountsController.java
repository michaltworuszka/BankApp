package com.tworuszka.accounts.controller;

import com.tworuszka.accounts.model.Accounts;
import com.tworuszka.accounts.model.Customer;
import com.tworuszka.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId());
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }
}
