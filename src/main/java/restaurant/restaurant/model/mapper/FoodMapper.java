package restaurant.restaurant.model.mapper;

import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.dto.request.RequestFood;
import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseFood;

import java.util.List;
import java.util.stream.Collectors;

public class FoodMapper {
    public static Food mapToFood(ResponseFood foodDto) {
        return Food.builder()
                .name(foodDto.getName())
                .ingredient(foodDto.getIngredient())
                .price(foodDto.getPrice())
                .build();
    }

    public static List<RequestFood> foodListConvert(List<Food> foodList) {
        return foodList.stream()
                .map(FoodMapper::mapToRequestFood)
                .collect(Collectors.toList());
    }

    public static RequestFood mapToRequestFood(Food food) {
        return RequestFood.builder()
                .id(food.getId())
                .name(food.getName())
                .price(food.getPrice())
                .build();
    }

    public static ResponseFood mapToResponseFood(Food food) {
        return ResponseFood.builder()
                .name(food.getName())
                .ingredient(food.getIngredient())
                .price(food.getPrice())
                .build();
    }

    public static Food mapToFoodFromRequestFood(RequestFood requestFood) {
        return Food.builder()
                .id(requestFood.getId())
                .name(requestFood.getName())
                .price(requestFood.getPrice())
                .build();
    }
}
