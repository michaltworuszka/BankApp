package com.tworuszka.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Michał Tworuszka
 * @project accounts
 */
@Entity
@Getter
@Setter
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    private String name;
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "create_dt")
    private LocalDate createDt;
}
