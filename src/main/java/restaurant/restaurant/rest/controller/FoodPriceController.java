package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.model.dto.request.RequestFood;
import restaurant.restaurant.rest.service.FoodService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FoodPriceController {
    private final FoodService foodService;

    @GetMapping("/foodPrice")
    public @ResponseBody
    double findAllTeacherInCourseById(@RequestParam(value = "food") Long id) {
        return foodService.findById(id).getPrice();
    }

}
