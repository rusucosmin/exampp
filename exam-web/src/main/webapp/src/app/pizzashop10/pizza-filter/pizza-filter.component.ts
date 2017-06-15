import { Component, OnInit } from '@angular/core';
import {PizzaService} from "../shared/pizza.service";
import {Pizza} from "../shared/pizza.model";

@Component({
  selector: 'app-pizza-filter',
  templateUrl: './pizza-filter.component.html',
  styleUrls: ['./pizza-filter.component.css']
})
export class PizzaFilterComponent implements OnInit {
  lessThan: boolean = false;
  isCuisine: boolean = false;
  cuisine: string = null;
  lessThanValue: number = null;
  pizzas: Pizza[];

  cuisines = ['MEDITERRANEAN', 'ORIENTAL'];
  constructor(private pizzaService: PizzaService) { }

  ngOnInit() {
    this.pizzaService
      .filterPizza({"filters": []})
      .subscribe(pizzas => this.pizzas = pizzas);
  }

  filter() {
    let body = {filters: []};
    if(this.lessThan) {
      if(this.lessThanValue === null) {
        alert("Less Than Value is null");
        return
      }
      body.filters.push({
        filterType: "lessThan",
        filterValue: this.lessThanValue + ""
      });
    }
    if(this.isCuisine) {
      if (this.cuisine === null) {
        alert("Please choose a cuisine or uncheck cuisine");
        return
      }
      body.filters.push({
        filterType: "isCuisine",
        filterValue: this.cuisine + ""
      });
    }
    console.log("filter" + JSON.stringify(body));
    this.pizzaService
      .filterPizza(body)
      .subscribe(pizzas => this.pizzas = pizzas);
  }
}
