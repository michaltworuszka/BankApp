package com.tworuszka.accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project Bank App
 */

@Setter
@Getter
@ToString
public class CustomerDetails {

    private Accounts accounts;
    List<Cards> cards;
    List<Loans> loans;
}
