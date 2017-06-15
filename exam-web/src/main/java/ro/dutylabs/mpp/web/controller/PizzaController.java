package ro.dutylabs.mpp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.dutylabs.mpp.core.model.Pizza;
import ro.dutylabs.mpp.core.service.PizzaService;
import ro.dutylabs.mpp.web.converter.PizzaConverter;
import ro.dutylabs.mpp.web.dto.FilterDto;
import ro.dutylabs.mpp.web.dto.FiltersDto;
import ro.dutylabs.mpp.web.dto.PizzaDto;
import ro.dutylabs.mpp.web.dto.PizzasDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by cosmin on 14/06/2017.
 */
@RestController
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private PizzaConverter pizzaConverter;

    private static final Logger log = LoggerFactory.getLogger(EntityController.class);

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public PizzasDto getAll() {
        log.trace("PizzaController::getAll()");
        return new PizzasDto(pizzaConverter.convertModelsToDtos(pizzaService.findAll()));
    }

    @RequestMapping(value = "/pizzas", method = RequestMethod.POST)
    public Map<String, PizzaDto> createPizza(@RequestBody final Map<String, PizzaDto> map) {
        log.trace("PizzaController::createEntity()");
        PizzaDto pizzaDto = map.get("pizza");
        Pizza pizza = pizzaService.createPizza(pizzaDto.getName(), pizzaDto.getDescription(), pizzaDto.getPrice(), pizzaDto.getCuisine());
        log.trace("created: " + pizza.getName());
        Map<String, PizzaDto> res = new HashMap<>();
        res.put("pizza", pizzaConverter.convertModelToDto(pizza));
        return res;
    }

    @RequestMapping(value = "/pizzas-filter", method = RequestMethod.POST)
    public PizzasDto filterPizza(@RequestBody final FiltersDto filtersDto) {
        log.trace("PizzaController::filteEntity()");
        log.trace(filtersDto.toString());
        //FiltersDto filtersDto = map.get("filters");
        Predicate<Pizza> pred = new Predicate<Pizza>() {
            /// TODO: check for null
            @Override
            public boolean test(Pizza pizza) {
                Optional<FilterDto> filterLessThan = filtersDto.getFilters()
                        .stream()
                        .filter(f -> f.getFilterType().equals("lessThan"))
                        .findFirst();
                if(filterLessThan.isPresent()) {
                    log.trace("lessThanIsPresent");
                    if(!filterLessThan.get().getFilterValue().equals("null")) {
                        float val = Float.valueOf(filterLessThan.get().getFilterValue());
                        log.trace("lessThanValue: ");
                        log.trace(String.valueOf(val));
                        if (pizza.getPrice() >= val)
                            return false;
                    }
                    else {
                        log.trace("lessThanValue is null");
                    }
                }
                Optional<FilterDto> filterCuisine = filtersDto.getFilters()
                        .stream()
                        .filter(f -> f.getFilterType().equals("isCuisine"))
                        .findFirst();
                if(filterCuisine.isPresent()) {
                    log.trace("isCuisinePresent");
                    if(!filterCuisine.get().getFilterValue().equals("null")) {
                        Pizza.Cuisine val = Pizza.Cuisine.valueOf(filterCuisine.get().getFilterValue());
                        log.trace("isCuisineValue: ");
                        log.trace(String.valueOf(val));
                        if (pizza.getCuisine() != val)
                            return false;
                    }
                    else {
                        log.trace("isCuisineValues is null");
                    }
                }
                return true;
            }
        };
        List<Pizza> list = pizzaService.filter(pred);
        log.trace("done");
        return new PizzasDto(pizzaConverter.convertModelsToDtos(list));
    }

}
