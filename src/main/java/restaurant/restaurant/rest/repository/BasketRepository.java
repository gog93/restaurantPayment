package restaurant.restaurant.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.model.Basket;
import restaurant.restaurant.model.BasketItem;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Basket findByUserId(Long id);

}
