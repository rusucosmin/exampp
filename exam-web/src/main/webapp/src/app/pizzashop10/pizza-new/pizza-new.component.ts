import { Component, OnInit } from '@angular/core';
import {Pizza} from "../shared/pizza.model";
import {PizzaService} from "../shared/pizza.service";

@Component({
  selector: 'app-pizza-new',
  templateUrl: './pizza-new.component.html',
  styleUrls: ['./pizza-new.component.css']
})
export class PizzaNewComponent implements OnInit {

  pizza = new Pizza();
  cuisines = ['MEDITERRANEAN', 'ORIENTAL'];
  constructor(private pizzaService: PizzaService) { }

  ngOnInit() {
  }

  save() {
    console.log("callings ")
    this.pizzaService.savePizza(this.pizza)
      .subscribe(_ => console.log("saved"))
  }

}
