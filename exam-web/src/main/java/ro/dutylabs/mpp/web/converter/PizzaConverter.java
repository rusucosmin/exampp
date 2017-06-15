package ro.dutylabs.mpp.web.converter;

import org.springframework.stereotype.Component;
import ro.dutylabs.mpp.core.model.Pizza;
import ro.dutylabs.mpp.web.dto.PizzaDto;

/**
 * Created by cosmin on 14/06/2017.
 */
@Component
public class PizzaConverter extends BaseConverter<Pizza, PizzaDto> {
    @Override
    public Pizza convertDtoToModel(PizzaDto pizzaDto) {
        Pizza now = Pizza.builder()
                .name(pizzaDto.getName())
                .description(pizzaDto.getDescription())
                .price(pizzaDto.getPrice())
                .cuisine(pizzaDto.getCuisine())
                .build();
        now.setId(pizzaDto.getId());
        return now;
    }

    @Override
    public PizzaDto convertModelToDto(Pizza pizza) {
        PizzaDto now = PizzaDto.builder()
                .name(pizza.getName())
                .description(pizza.getDescription())
                .price(pizza.getPrice())
                .cuisine(pizza.getCuisine())
                .build();
        now.setId(pizza.getId());
        return now;
    }
}
