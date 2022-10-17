package com.tworuszka.cards.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Michał Tworuszka
 * @project cards
 */

@Entity
@Getter
@Setter
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private int totalLimit;

    @Column(name = "amount_used")
    private int amountUsed;

    @Column(name = "available_amount")
    private int availableAmount;

    @Column(name = "create_dt")
    private Date createdDt;

    @Override
    public String toString() {
        return "Cards{" +
                "cardId=" + cardId +
                ", customerId=" + customerId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", totalLimit=" + totalLimit +
                ", amountUsed=" + amountUsed +
                ", availableAmount=" + availableAmount +
                ", createdDt=" + createdDt +
                '}';
    }
}
