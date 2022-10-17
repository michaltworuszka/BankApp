package com.tworuszka.accounts.repository;

import com.tworuszka.accounts.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Michał Tworuszka
 * @project accounts
 */
public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Accounts findByCustomerId(int customerId);
}
