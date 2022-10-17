package com.tworuszka.accounts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Michał Tworuszka
 * @project accounts
 */
@Entity
@Getter
@Setter
@Table(name = "ACCOUNTS")
public class Accounts {

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "account_number")
    @Id
    private Long accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "create_dt")
    private LocalDate createDt;

    @Override
    public String toString() {
        return "Accounts{" +
                "customerId=" + customerId +
                ", accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                ", createDt=" + createDt +
                '}';
    }
}
