package restaurant.restaurant.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.model.BasketItem;

import java.util.List;

public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {
    List<BasketItem> findByBasketId(Long id);

    List<BasketItem> findByFoodsInBasketId(Long id);
}
