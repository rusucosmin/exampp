import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EntitiesDetailComponent } from './entities-detail.component';

describe('EntitiesDetailComponent', () => {
  let component: EntitiesDetailComponent;
  let fixture: ComponentFixture<EntitiesDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EntitiesDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EntitiesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
