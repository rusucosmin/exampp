import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Pizzashop10Component } from './pizzashop10.component';

describe('Pizzashop10Component', () => {
  let component: Pizzashop10Component;
  let fixture: ComponentFixture<Pizzashop10Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Pizzashop10Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Pizzashop10Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
