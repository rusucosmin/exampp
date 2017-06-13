import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EntitiesComponent} from "./entities/entities.component";
import {EntitiesNewComponent} from "./entities/entities-new/entities-new.component";
import {EntitiesDetailComponent} from "./entities/entities-detail/entities-detail.component";

const routes: Routes = [
    { path: 'entities',     component: EntitiesComponent },
    { path: 'entities/new', component: EntitiesNewComponent },
    { path: 'entities/:id', component: EntitiesDetailComponent},
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
