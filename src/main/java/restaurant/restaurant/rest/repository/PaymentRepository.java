package restaurant.restaurant.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByUserId(Long userId);
}
