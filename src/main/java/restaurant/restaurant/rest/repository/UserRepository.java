package restaurant.restaurant.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String s);
}
