package restaurant.restaurant.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByUserId(Long userId);
}
