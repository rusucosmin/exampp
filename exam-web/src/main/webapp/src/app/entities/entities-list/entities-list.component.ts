import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {EntityService} from "../shared/entity.service";
import {Entity} from "../shared/entity.model";

@Component({
  selector: 'app-entities-list',
  templateUrl: './entities-list.component.html',
  styleUrls: ['./entities-list.component.css']
})
export class EntitiesListComponent implements OnInit {
  errorMessage: string
  entities: Entity[]
  constructor(private router: Router,
    private entityService: EntityService) { }

  ngOnInit() {
    this.entityService.getEntities()
      .subscribe(
        entities => this.entities = entities,
        error => this.errorMessage = error
      )
  }

}
