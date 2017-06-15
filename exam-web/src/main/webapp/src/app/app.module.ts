import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import { EntitiesComponent } from './entities/entities.component';
import { EntitiesListComponent } from './entities/entities-list/entities-list.component';
import { EntitiesDetailComponent } from './entities/entities-detail/entities-detail.component';
import { EntitiesNewComponent } from './entities/entities-new/entities-new.component';
import { EntityService } from "./entities/shared/entity.service";
import { Pizzashop10Component } from './pizzashop10/pizzashop10.component';
import { PizzaNewComponent } from './pizzashop10/pizza-new/pizza-new.component';
import {PizzaService} from "./pizzashop10/shared/pizza.service";
import { PizzaFilterComponent } from './pizzashop10/pizza-filter/pizza-filter.component';
import { PizzaListComponent } from './pizzashop10/pizza-list/pizza-list.component';

@NgModule({
  declarations: [
    AppComponent,
    EntitiesComponent,
    EntitiesListComponent,
    EntitiesDetailComponent,
    EntitiesNewComponent,
    Pizzashop10Component,
    PizzaNewComponent,
    PizzaFilterComponent,
    PizzaListComponent // and here the components
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [EntityService, PizzaService], //add here the services
  bootstrap: [AppComponent]
})
export class AppModule { }
