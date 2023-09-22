package restaurant.restaurant.rest.service;

import restaurant.restaurant.model.dto.request.RequestAdmin;
import restaurant.restaurant.model.dto.response.ResponseAdmin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    void saveAdmin(ResponseAdmin admin);

    RequestAdmin findById(Long id);

    Optional<RequestAdmin> findByEmail(String email);

    List<RequestAdmin> findAll();
}
