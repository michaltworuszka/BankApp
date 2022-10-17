package com.tworuszka.loans.controller;

import com.tworuszka.loans.model.Customer;
import com.tworuszka.loans.model.Loans;
import com.tworuszka.loans.repository.LoansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project loans
 */

@RestController
public class LoansController {

    @Autowired
    private LoansRepo loansRepo;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails (@RequestBody Customer customer) {
        List<Loans> loans = loansRepo.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (loans!= null) {
            return loans;
        } else {
            return null;
        }
    }
}
