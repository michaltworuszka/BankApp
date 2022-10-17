package com.tworuszka.loans.repository;

import com.tworuszka.loans.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project loans
 */
public interface LoansRepo extends JpaRepository<Loans, Long> {

    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
