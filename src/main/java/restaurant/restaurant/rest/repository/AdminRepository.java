package restaurant.restaurant.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.model.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String username);
}
