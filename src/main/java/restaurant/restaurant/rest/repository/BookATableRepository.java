package restaurant.restaurant.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.model.Admin;
import restaurant.restaurant.model.BookATable;

import java.util.Optional;

public interface BookATableRepository extends JpaRepository<BookATable, Long> {
}
