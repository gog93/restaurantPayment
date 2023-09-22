package restaurant.restaurant.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.UserType.UserType;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFood {
    private String name;
    private String ingredient;
    private double price;

}
