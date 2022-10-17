package com.tworuszka.cards.repository;

import com.tworuszka.cards.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project cards
 */
public interface CardsRepo extends JpaRepository<Cards, Long> {

    List<Cards> findByCustomerId(int customerId);
}
