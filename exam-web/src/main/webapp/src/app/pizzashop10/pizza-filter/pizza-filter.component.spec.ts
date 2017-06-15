import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaFilterComponent } from './pizza-filter.component';

describe('PizzaFilterComponent', () => {
  let component: PizzaFilterComponent;
  let fixture: ComponentFixture<PizzaFilterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PizzaFilterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PizzaFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
