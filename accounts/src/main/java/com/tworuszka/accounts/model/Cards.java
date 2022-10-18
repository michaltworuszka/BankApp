package com.tworuszka.accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Michał Tworuszka
 * @project Bank App
 */
@Getter
@Setter
@ToString
public class Cards {

    private int cardId;

    private int customerId;

    private String cardNumber;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

    private Date createDt;

}
