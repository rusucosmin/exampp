package ro.dutylabs.mpp.core.service;

import ro.dutylabs.mpp.core.model.Pizza;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by cosmin on 14/06/2017.
 */
public interface PizzaService {
    List<Pizza> findAll();
    List<Pizza> filter(Predicate<Pizza> testFilter);
    Pizza createPizza(String name, String descr, float price, Pizza.Cuisine cuisine);
}
