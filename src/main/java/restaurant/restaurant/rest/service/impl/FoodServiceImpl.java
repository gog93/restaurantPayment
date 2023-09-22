package restaurant.restaurant.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.model.Card;
import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.request.RequestFood;
import restaurant.restaurant.model.dto.response.ResponseFood;
import restaurant.restaurant.model.mapper.CardMapper;
import restaurant.restaurant.model.mapper.FoodMapper;
import restaurant.restaurant.rest.repository.FoodRepository;
import restaurant.restaurant.rest.service.FoodService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Override
    public void saveFood(ResponseFood food) {
        foodRepository.save(FoodMapper.mapToFood(food));

    }

    @Override
    public RequestFood findById(Long id) {
        if(id==null){
            return null;
        }
        return FoodMapper.mapToRequestFood(foodRepository.findById(id).get());
    }


    @Override
    public List<RequestFood> findAll() {
        return FoodMapper.foodListConvert(foodRepository.findAll());
    }


}
