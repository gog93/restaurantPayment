package restaurant.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookATable")
public class BookATable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private int time;
    private int space;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "bookATable_food_mapping",
            joinColumns = @JoinColumn(name = "bookATable_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List<Food> foods;
    private double feeAmount;

}
