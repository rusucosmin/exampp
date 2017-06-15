package ro.dutylabs.mpp.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dutylabs.mpp.core.model.Pizza;
import ro.dutylabs.mpp.core.repository.PizzaRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by cosmin on 14/06/2017.
 */
@Service
public class PizzaServiceImp implements PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    private static final Logger log = LoggerFactory.getLogger(EntityServiceImpl.class);
    @Override
    public List<Pizza> findAll() {
        log.trace("start - PizzaService::findAll()");
        List<Pizza> list = pizzaRepository.findAll(); /// pizda repository
        log.trace("done - PizzaService::findAll()");
        return list;
    }

    @Override
    public List<Pizza> filter(Predicate<Pizza> testFilter) {
        log.trace("start - PizzaService::filter()");
        List<Pizza> list = pizzaRepository.findAll()
                .stream()
                .filter(testFilter)
                .collect(Collectors.toList());
        log.trace("done - PizzaService::filter()");
        return list;
    }

    @Override
    public Pizza createPizza(String name, String descr, float price, Pizza.Cuisine cuisine) {
        log.trace("start - pizzaService::save()");
        Pizza now = Pizza.builder()
                .name(name)
                .description(descr)
                .price(price)
                .cuisine(cuisine)
                .build();
        now = pizzaRepository.save(now);
        log.trace("done - pizzaService::save()");
        return now;
    }
}
