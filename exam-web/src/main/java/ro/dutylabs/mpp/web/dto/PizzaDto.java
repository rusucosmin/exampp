package ro.dutylabs.mpp.web.dto;

import lombok.*;
import ro.dutylabs.mpp.core.model.Pizza;

/**
 * Created by cosmin on 14/06/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PizzaDto extends BaseDto {
    private String name;
    private String description;
    private float price;
    private Pizza.Cuisine cuisine;
}

