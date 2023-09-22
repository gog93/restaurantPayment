package restaurant.restaurant.rest.service;

import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(ResponseUser user);

    RequestUser findById(Long id);


    List<RequestUser> findAll();

    Optional<RequestUser> findByLogin(String username);
}
