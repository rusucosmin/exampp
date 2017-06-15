import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EntitiesComponent} from "./entities/entities.component";
import {EntitiesNewComponent} from "./entities/entities-new/entities-new.component";
import {EntitiesDetailComponent} from "./entities/entities-detail/entities-detail.component";
import {Pizzashop10Component} from "./pizzashop10/pizzashop10.component";
import {PizzaNewComponent} from "./pizzashop10/pizza-new/pizza-new.component";
import {PizzaFilterComponent} from "./pizzashop10/pizza-filter/pizza-filter.component";

const routes: Routes = [
    { path: 'entities',     component: EntitiesComponent },
    { path: 'entities/new', component: EntitiesNewComponent },
    { path: 'entities/:id', component: EntitiesDetailComponent},
    { path: 'pizzashop10',     component: Pizzashop10Component },
    { path: 'pizzashop10/new', component: PizzaNewComponent },
    { path: 'pizzashop10/filter', component: PizzaFilterComponent },
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
