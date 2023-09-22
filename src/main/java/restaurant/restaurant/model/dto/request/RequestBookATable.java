package restaurant.restaurant.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.User;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestBookATable {
    private Long id;
    private User user;
    private int time;
    private int space;
    private double feeAmount;
    private List<Food> foods;
}
