package restaurant.restaurant.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
