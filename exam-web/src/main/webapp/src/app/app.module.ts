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
import {EntityService} from "./entities/shared/entity.service";

@NgModule({
  declarations: [
    AppComponent,
    EntitiesComponent,
    EntitiesListComponent,
    EntitiesDetailComponent,
    EntitiesNewComponent // and here the components
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [EntityService], //add here the services
  bootstrap: [AppComponent]
})
export class AppModule { }
