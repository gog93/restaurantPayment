package restaurant.restaurant.rest.service;

import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.request.RequestFood;
import restaurant.restaurant.model.dto.response.ResponseFood;

import java.util.List;

public interface FoodService {
    void saveFood(ResponseFood food);

    RequestFood findById(Long id);


    List<RequestFood> findAll();

}
